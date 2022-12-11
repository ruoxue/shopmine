package com.ruoyi.phone.service;

import java.util.List;
import com.ruoyi.phone.domain.TPhoneVisitor;

/**
 * 访问记录Service接口
 * 
 * @author ruoyi
 * @date 2022-11-12 03:52:12
 */
public interface ITPhoneVisitorService 
{
    /**
     * 查询访问记录
     * 
     * @param id 访问记录主键
     * @return 访问记录
     */
    public TPhoneVisitor selectTPhoneVisitorById(Long id);

    /**
     * 查询访问记录列表
     * 
     * @param tPhoneVisitor 访问记录
     * @return 访问记录集合
     */
    public List<TPhoneVisitor> selectTPhoneVisitorList(TPhoneVisitor tPhoneVisitor);

    /**
     * 新增访问记录
     * 
     * @param tPhoneVisitor 访问记录
     * @return 结果
     */
    public int insertTPhoneVisitor(TPhoneVisitor tPhoneVisitor);

    /**
     * 修改访问记录
     * 
     * @param tPhoneVisitor 访问记录
     * @return 结果
     */
    public int updateTPhoneVisitor(TPhoneVisitor tPhoneVisitor);

    /**
     * 批量删除访问记录
     * 
     * @param ids 需要删除的访问记录主键集合
     * @return 结果
     */
    public int deleteTPhoneVisitorByIds(Long[] ids);

    /**
     * 删除访问记录信息
     * 
     * @param id 访问记录主键
     * @return 结果
     */
    public int deleteTPhoneVisitorById(Long id);
}
