package com.itexcelsior.broadcast.video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zxw </br>
 * @create 2020/8/26/11:04 </br>
 * @description: </br>
 */
@Controller
public class PageController {


    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/toVideoPlay")
    public String toVideoPlay(@RequestParam String file, Model model) {

        model.addAttribute("f_path", "room.1598338801993.mp4");
//        model.addAttribute("f_path", file);


        return "video_play";
    }

}
