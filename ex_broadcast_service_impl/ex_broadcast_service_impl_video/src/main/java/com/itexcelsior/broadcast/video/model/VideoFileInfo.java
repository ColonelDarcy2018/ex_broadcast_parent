package com.itexcelsior.broadcast.video.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zxw </br>
 * @create 2020/8/25/9:26 </br>
 * @description: </br>
 */
@Data
@Entity
@Table(name = "video_file_info")
public class VideoFileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ip;
    private String vhost;
    private String app;
    private String stream;
    private String param;
    private String cwd;
    private String file;

    public VideoFileInfo() {
    }

    public VideoFileInfo(String ip, String vhost, String app, String stream, String param, String cwd, String file) {
        this.ip = ip;
        this.vhost = vhost;
        this.app = app;
        this.stream = stream;
        this.param = param;
        this.cwd = cwd;
        this.file = file;
    }
}
