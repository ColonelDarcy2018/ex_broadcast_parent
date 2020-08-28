package com.itexcelsior.broadcast.video.manage;

import com.itexcelsior.broadcast.video.dao.VideoFileInfoDao;
import com.itexcelsior.broadcast.video.model.VideoFileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zxw </br>
 * @create 2020/8/25/9:54 </br>
 * @description: </br>
 */
@Service
public class VideoFileInfoManager {

    @Autowired
    private VideoFileInfoDao videoFileInfoDao;

    /**
     * 新增
     * @param videoFileInfo
     */
    public void add(VideoFileInfo videoFileInfo){

        videoFileInfoDao.save(videoFileInfo);
    }


    /**
     * 查询全部
     * @return
     */
    public List<VideoFileInfo> findAll(){
        return videoFileInfoDao.findAll();
    }

}
