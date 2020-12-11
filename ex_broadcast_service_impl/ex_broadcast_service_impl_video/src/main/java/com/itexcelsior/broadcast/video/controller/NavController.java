package com.itexcelsior.broadcast.video.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zxw </br>
 * @create 2020/8/26/11:04 </br>
 * @description: 网页跳转控制层</br>
 */
@Controller
public class NavController {

    @Value("${video.path.prefix}")
    private String videoPathPrefix;
    @Value("${video.stream.prefix}")
    private String livePrefix;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/console")
    public String console() {
        return "console";
    }



    private static final String LIVE_PREFIX="http://49.232.93.219:7070/live/";
    private static final String VIDEO_PATH_PREFIX="http://49.232.93.219:8080";
    private static final String LIVE_END=".flv";
    private static Map<String,String> channelMap;

    static {
        channelMap=new HashMap<>();
        channelMap.put("helmet_device_01",LIVE_PREFIX+"device1"+LIVE_END);
        channelMap.put("helmet_device_02",LIVE_PREFIX+"device2"+LIVE_END);
        channelMap.put("helmet_device_03",LIVE_PREFIX+"device3"+LIVE_END);
        channelMap.put("CCTV6","http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8");
        channelMap.put("CCTV1","http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8");
        channelMap.put("CCTV3","http://ivi.bupt.edu.cn/hls/cctv3hd.m3u8");
        channelMap.put("default","http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8");
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
    public String toHlsStream(@RequestParam String id, Model model) {

        if (StringUtils.isEmpty(id)){
            model.addAttribute("rtmp_url", channelMap.get("default"));
        }else {
            model.addAttribute("rtmp_url", channelMap.get(id));
        }

        model.addAttribute("a_id", id);
        return "video_stream_hls";
    }

    @GetMapping("/toRegister")
    public String toRegister() {

        return "register";
    }



}
