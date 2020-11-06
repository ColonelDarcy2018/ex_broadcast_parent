package com.itexcelsior.broadcast.video.controller;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${video.path.prefix}")
    private String videoPathPrefix;
    @Value("${video.stream.prefix}")
    private String livePrefix;

    @GetMapping("/test")
    public String test() {
        return "test";
    }


    @GetMapping("/toVideoPlay")
    public String toVideoPlay(@RequestParam String file, Model model) {

        String[] videoPath=file.split("/");
        String app=videoPath[videoPath.length-2];
        String name=videoPath[videoPath.length-1];


        model.addAttribute("f_path", videoPathPrefix+"/"+app+"/"+name);
//        model.addAttribute("f_path", file);


        return "video_play";
    }

    @GetMapping("/toLivePlay")
    public String toLivePlay(@RequestParam String channel, Model model) {


        model.addAttribute("rtmp_url", livePrefix+channel);
//        model.addAttribute("f_path", file);


        return "video_stream";
    }

    @GetMapping("/toStream")
    public String toStream(@RequestParam String channel, Model model) {


        model.addAttribute("rtmp_url", channel);
//        model.addAttribute("f_path", file);


        return "video_stream";
    }

    @GetMapping("/toHlsStream")
    public String toHlsStream(@RequestParam String channel, Model model) {


        model.addAttribute("rtmp_url", channel);
//        model.addAttribute("f_path", file);


        return "video_stream_hls";
    }

    @GetMapping("/toRegister")
    public String toRegister() {

        return "register";
    }



}
