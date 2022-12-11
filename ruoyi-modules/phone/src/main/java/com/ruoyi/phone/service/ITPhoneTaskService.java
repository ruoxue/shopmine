package com.ruoyi.phone.service;

import java.util.List;
import com.ruoyi.phone.domain.TPhoneTask;

/**
 * 生产任务Service接口
 * 
 * @author ruoyi
 * @date 2022-11-12 03:52:12
 */
public interface ITPhoneTaskService 
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
     * 批量删除生产任务
     * 
     * @param ids 需要删除的生产任务主键集合
     * @return 结果
     */
    public int deleteTPhoneTaskByIds(Long[] ids);

    /**
     * 删除生产任务信息
     * 
     * @param id 生产任务主键
     * @return 结果
     */
    public int deleteTPhoneTaskById(Long id);

   public int getPhone(Integer type);
   public  int getPhone();
   public  int sendSms();




}
