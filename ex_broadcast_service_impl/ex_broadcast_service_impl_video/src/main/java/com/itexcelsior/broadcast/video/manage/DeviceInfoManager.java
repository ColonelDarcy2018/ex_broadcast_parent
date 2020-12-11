package com.itexcelsior.broadcast.video.manage;

import com.itexcelsior.broadcast.video.dao.DeviceInfoDao;
import com.itexcelsior.broadcast.video.model.DeviceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zxw </br>
 * @create 2020/11/10/10:22 </br>
 * @description: </br>
 */
@Service
public class DeviceInfoManager {

    @Autowired
    private DeviceInfoDao deviceInfoDao;

    /**
     * 查询全部
     * @return
     */
    public List<DeviceInfo> findAll(){
        return deviceInfoDao.findAll();
    }




}
