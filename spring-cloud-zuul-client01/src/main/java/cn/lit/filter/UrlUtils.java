package cn.lit.filter;

import java.util.ArrayList;
import java.util.List;

public class UrlUtils {
    private List<String> urls;
    //或者读取属性,或者写死
    public UrlUtils(){
        urls=new ArrayList<String>();
        //将需要验证登录的url全部放到这个urls中
        urls.add("/zuul-cart/cart/manage/query");
        urls.add("/zuul-cart/cart/manage/save");
        //..
    }
    public boolean urlShouldFilter(String url){
        return urls.contains(url);
    }

}
