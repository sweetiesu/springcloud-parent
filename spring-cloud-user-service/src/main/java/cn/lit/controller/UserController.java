package cn.lit.controller;

import cn.lit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService = null;

    @ResponseBody
    @RequestMapping("/point.action")
    public String point(String userId){
        int point = userService.queryPoint(userId);
        return "{\"points\":"+point+"}";
    }
    //补充一个增加集分的接口方法
    @ResponseBody
    @RequestMapping(value="addPoint.action",method = RequestMethod.GET)
    public Integer addPoint(String userId,Integer money){
        userService.addPoint(userId,money);
        return 1;
    }
}
