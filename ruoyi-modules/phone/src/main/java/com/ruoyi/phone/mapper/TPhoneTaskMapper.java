package com.ruoyi.phone.mapper;

import java.util.List;
import com.ruoyi.phone.domain.TPhoneTask;

/**
 * 生产任务Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-12 03:52:12
 */
public interface TPhoneTaskMapper 
{
    /**
     * 查询生产任务
     * 
     * @param id 生产任务主键
     * @return 生产任务
     */
    public TPhoneTask selectTPhoneTaskById(Long id);

    /**
     * 查询生产任务列表
     * 
     * @param tPhoneTask 生产任务
     * @return 生产任务集合
     */
    public List<TPhoneTask> selectTPhoneTaskList(TPhoneTask tPhoneTask);

    /**
     * 新增生产任务
     * 
     * @param tPhoneTask 生产任务
     * @return 结果
     */
    public int insertTPhoneTask(TPhoneTask tPhoneTask);

    /**
     * 修改生产任务
     * 
     * @param tPhoneTask 生产任务
     * @return 结果
     */
    public int updateTPhoneTask(TPhoneTask tPhoneTask);

    /**
     * 删除生产任务
     * 
     * @param id 生产任务主键
     * @return 结果
     */
    public int deleteTPhoneTaskById(Long id);

    /**
     * 批量删除生产任务
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTPhoneTaskByIds(Long[] ids);
}
