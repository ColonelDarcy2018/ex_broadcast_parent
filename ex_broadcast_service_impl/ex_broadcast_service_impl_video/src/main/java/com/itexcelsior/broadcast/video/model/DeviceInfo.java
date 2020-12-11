package com.itexcelsior.broadcast.video.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author zxw </br>
 * @create 2020/11/10/10:09 </br>
 * @description: </br>
 */
@Data
@Entity
@Table(name = "device_info")
public class DeviceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String device_name;
    private String device_stream_path;
    private Timestamp create_time;
    private String create_user_id;


}
