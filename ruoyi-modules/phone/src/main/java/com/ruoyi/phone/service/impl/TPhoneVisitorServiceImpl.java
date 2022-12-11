package com.ruoyi.phone.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.phone.mapper.TPhoneVisitorMapper;
import com.ruoyi.phone.domain.TPhoneVisitor;
import com.ruoyi.phone.service.ITPhoneVisitorService;

/**
 * 访问记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-12 03:52:12
 */
@Service
public class TPhoneVisitorServiceImpl implements ITPhoneVisitorService 
{
    @Autowired
    private TPhoneVisitorMapper tPhoneVisitorMapper;

    /**
     * 查询访问记录
     * 
     * @param id 访问记录主键
     * @return 访问记录
     */
    @Override
    public TPhoneVisitor selectTPhoneVisitorById(Long id)
    {
        return tPhoneVisitorMapper.selectTPhoneVisitorById(id);
    }

    /**
     * 查询访问记录列表
     * 
     * @param tPhoneVisitor 访问记录
     * @return 访问记录
     */
    @Override
    public List<TPhoneVisitor> selectTPhoneVisitorList(TPhoneVisitor tPhoneVisitor)
    {
        return tPhoneVisitorMapper.selectTPhoneVisitorList(tPhoneVisitor);
    }

    /**
     * 新增访问记录
     * 
     * @param tPhoneVisitor 访问记录
     * @return 结果
     */
    @Override
    public int insertTPhoneVisitor(TPhoneVisitor tPhoneVisitor)
    {
        tPhoneVisitor.setCreateTime(DateUtils.getNowDate());
        return tPhoneVisitorMapper.insertTPhoneVisitor(tPhoneVisitor);
    }

    /**
     * 修改访问记录
     * 
     * @param tPhoneVisitor 访问记录
     * @return 结果
     */
    @Override
    public int updateTPhoneVisitor(TPhoneVisitor tPhoneVisitor)
    {
        tPhoneVisitor.setUpdateTime(DateUtils.getNowDate());
        return tPhoneVisitorMapper.updateTPhoneVisitor(tPhoneVisitor);
    }

    /**
     * 批量删除访问记录
     * 
     * @param ids 需要删除的访问记录主键
     * @return 结果
     */
    @Override
    public int deleteTPhoneVisitorByIds(Long[] ids)
    {
        return tPhoneVisitorMapper.deleteTPhoneVisitorByIds(ids);
    }

    /**
     * 删除访问记录信息
     * 
     * @param id 访问记录主键
     * @return 结果
     */
    @Override
    public int deleteTPhoneVisitorById(Long id)
    {
        return tPhoneVisitorMapper.deleteTPhoneVisitorById(id);
    }
}
