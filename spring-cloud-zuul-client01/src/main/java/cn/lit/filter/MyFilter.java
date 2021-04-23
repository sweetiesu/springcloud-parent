package cn.lit.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //刚刚请求进入zuul网关时就开始过滤器逻辑
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //根据请求url地址，判断是否执行过滤
        // uri=/zuul-cart/cart/manage/query的时候需要执行过滤
        //返回true 否则 返回false
        //1 拿到请求到zuul网关的request对象
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取到请求和相应对象 只需要使用request
        HttpServletRequest request = currentContext.getRequest();
        //2 解析出来uri地址 /zuul-cart/cart/manage/query
        //getUri 除了域名端口的剩余字符串
        //getUril 需要带有localhost:8103
        System.out.println("uri:"+request.getRequestURI());
        System.out.println("url"+request.getRequestURL());
        return new UrlUtils().urlShouldFilter(request.getRequestURI());
    }
    @Autowired
    private JedisCluster cluster;
    //run方法过滤逻辑执行，取决于shouldFilter返回值 true
    @Override
    public Object run() {
        //拿到请求中cookie 判断有么有em_ticket 有则连接redis判断是否存在
        //1 现获取request
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletResponse response = currentContext.getResponse();
        HttpServletRequest request = currentContext.getRequest();
        String ticket = CookieUtils.getCookieValue(request, "EM_TICKET");
        if(ticket==null||"".equals(ticket)){
            //没登录 直接response返回403无权限
            response.setStatus(403);
            currentContext.setSendZuulResponse(false);
            return null;
        }else if(!cluster.exists(ticket)){
            //登录过，超时了 直接response返回403无权限
            response.setStatus(403);
            currentContext.setSendZuulResponse(false);//相应直接从这里返回
            return null;
        }
        //上述if判断全部没有进入，则不处理当前请求
        return null;//进行路由匹配，访问后端微服务
    }
}
