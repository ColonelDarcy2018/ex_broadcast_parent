package com.itexcelsior.broadcast.video.dao;

        import com.itexcelsior.broadcast.video.model.VideoFileInfo;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author zxw </br>
 * @create 2020/8/25/9:51 </br>
 * @description: </br>
 */
public interface VideoFileInfoDao extends JpaRepository<VideoFileInfo,Integer>, JpaSpecificationExecutor<VideoFileInfoDao> {
}
