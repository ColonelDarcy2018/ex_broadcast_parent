package com.itexcelsior.broadcast.video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zxw </br>
 * @create 2020/8/28/14:06 </br>
 * @description: </br>
 */
@Controller
@RequestMapping("/layout")
public class DecoratorController {

    @GetMapping("/default")
    public String defaultDecorator(){
        return "layout/default";
    }

}
