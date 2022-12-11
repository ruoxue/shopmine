package com.ruoyi.phone.mapper;

import java.util.List;
import com.ruoyi.phone.domain.TPhoneNumber;

/**
 * 手机管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-12 03:52:11
 */
public interface TPhoneNumberMapper 
{
    /**
     * 查询手机管理
     * 
     * @param id 手机管理主键
     * @return 手机管理
     */
    public TPhoneNumber selectTPhoneNumberById(Long id);

    /**
     * 查询手机管理列表
     * 
     * @param tPhoneNumber 手机管理
     * @return 手机管理集合
     */
    public List<TPhoneNumber> selectTPhoneNumberList(TPhoneNumber tPhoneNumber);

    /**
     * 新增手机管理
     * 
     * @param tPhoneNumber 手机管理
     * @return 结果
     */
    public int insertTPhoneNumber(TPhoneNumber tPhoneNumber);

    /**
     * 修改手机管理
     * 
     * @param tPhoneNumber 手机管理
     * @return 结果
     */
    public int updateTPhoneNumber(TPhoneNumber tPhoneNumber);

    /**
     * 删除手机管理
     * 
     * @param id 手机管理主键
     * @return 结果
     */
    public int deleteTPhoneNumberById(Long id);

    /**
     * 批量删除手机管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTPhoneNumberByIds(Long[] ids);
}
