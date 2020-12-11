package com.itexcelsior.broadcast.video.impl;

import com.itexcelsior.broadcast.common.core.base.BaseApiService;
import com.itexcelsior.broadcast.common.core.base.BaseResponse;
import com.itexcelsior.broadcast.video.manage.DeviceInfoManager;
import com.itexcelsior.broadcast.video.model.DeviceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zxw </br>
 * @create 2020/11/10/10:24 </br>
 * @description: 设备信息相关接口</br>
 */
@RestController
@RequestMapping("/device")
public class DeviceInfoServiceImpl extends BaseApiService {


    @Autowired
    public DeviceInfoManager deviceInfoManager;

    @GetMapping("/getAllDevices")
    public BaseResponse getAllDevices(){

        List<DeviceInfo> deviceInfos=deviceInfoManager.findAll();

        return setResultSuccess(deviceInfos);
    }



}
