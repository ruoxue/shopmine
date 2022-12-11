package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionVideo;

/**
 * 视频数据Service接口
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:48
 */
public interface IReligionVideoService 
{
    /**
     * 查询视频数据
     * 
     * @param id 视频数据主键
     * @return 视频数据
     */
    public ReligionVideo selectReligionVideoById(Long id);

    /**
     * 查询视频数据列表
     * 
     * @param religionVideo 视频数据
     * @return 视频数据集合
     */
    public List<ReligionVideo> selectReligionVideoList(ReligionVideo religionVideo);

    /**
     * 新增视频数据
     * 
     * @param religionVideo 视频数据
     * @return 结果
     */
    public int insertReligionVideo(ReligionVideo religionVideo);

    /**
     * 修改视频数据
     * 
     * @param religionVideo 视频数据
     * @return 结果
     */
    public int updateReligionVideo(ReligionVideo religionVideo);

    /**
     * 批量删除视频数据
     * 
     * @param ids 需要删除的视频数据主键集合
     * @return 结果
     */
    public int deleteReligionVideoByIds(Long[] ids);

    /**
     * 删除视频数据信息
     * 
     * @param id 视频数据主键
     * @return 结果
     */
    public int deleteReligionVideoById(Long id);
}
