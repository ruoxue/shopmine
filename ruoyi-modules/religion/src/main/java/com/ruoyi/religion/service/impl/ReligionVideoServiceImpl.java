package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionVideoMapper;
import com.ruoyi.religion.domain.ReligionVideo;
import com.ruoyi.religion.service.IReligionVideoService;

/**
 * 视频数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:48
 */
@Service
public class ReligionVideoServiceImpl implements IReligionVideoService 
{
    @Autowired
    private ReligionVideoMapper religionVideoMapper;

    /**
     * 查询视频数据
     * 
     * @param id 视频数据主键
     * @return 视频数据
     */
    @Override
    public ReligionVideo selectReligionVideoById(Long id)
    {
        return religionVideoMapper.selectReligionVideoById(id);
    }

    /**
     * 查询视频数据列表
     * 
     * @param religionVideo 视频数据
     * @return 视频数据
     */
    @Override
    public List<ReligionVideo> selectReligionVideoList(ReligionVideo religionVideo)
    {
        return religionVideoMapper.selectReligionVideoList(religionVideo);
    }

    /**
     * 新增视频数据
     * 
     * @param religionVideo 视频数据
     * @return 结果
     */
    @Override
    public int insertReligionVideo(ReligionVideo religionVideo)
    {
        religionVideo.setCreateTime(DateUtils.getNowDate());
        return religionVideoMapper.insertReligionVideo(religionVideo);
    }

    /**
     * 修改视频数据
     * 
     * @param religionVideo 视频数据
     * @return 结果
     */
    @Override
    public int updateReligionVideo(ReligionVideo religionVideo)
    {
        religionVideo.setUpdateTime(DateUtils.getNowDate());
        return religionVideoMapper.updateReligionVideo(religionVideo);
    }

    /**
     * 批量删除视频数据
     * 
     * @param ids 需要删除的视频数据主键
     * @return 结果
     */
    @Override
    public int deleteReligionVideoByIds(Long[] ids)
    {
        return religionVideoMapper.deleteReligionVideoByIds(ids);
    }

    /**
     * 删除视频数据信息
     * 
     * @param id 视频数据主键
     * @return 结果
     */
    @Override
    public int deleteReligionVideoById(Long id)
    {
        return religionVideoMapper.deleteReligionVideoById(id);
    }
}
