package com.itexcelsior.broadcast.video.dao;

import com.itexcelsior.broadcast.video.model.DeviceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zxw </br>
 * @create 2020/11/10/10:19 </br>
 * @description: </br>
 */
public interface DeviceInfoDao extends JpaSpecificationExecutor<DeviceInfoDao>, JpaRepository<DeviceInfo,Integer> {
}
