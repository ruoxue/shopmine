package com.ruoyi.phone.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.phone.mapper.TPhoneNumberMapper;
import com.ruoyi.phone.domain.TPhoneNumber;
import com.ruoyi.phone.service.ITPhoneNumberService;

/**
 * 手机管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-12 03:52:11
 */
@Service
public class TPhoneNumberServiceImpl implements ITPhoneNumberService 
{
    @Autowired
    private TPhoneNumberMapper tPhoneNumberMapper;

    /**
     * 查询手机管理
     * 
     * @param id 手机管理主键
     * @return 手机管理
     */
    @Override
    public TPhoneNumber selectTPhoneNumberById(Long id)
    {
        return tPhoneNumberMapper.selectTPhoneNumberById(id);
    }

    /**
     * 查询手机管理列表
     * 
     * @param tPhoneNumber 手机管理
     * @return 手机管理
     */
    @Override
    public List<TPhoneNumber> selectTPhoneNumberList(TPhoneNumber tPhoneNumber)
    {
        return tPhoneNumberMapper.selectTPhoneNumberList(tPhoneNumber);
    }

    /**
     * 新增手机管理
     * 
     * @param tPhoneNumber 手机管理
     * @return 结果
     */
    @Override
    public int insertTPhoneNumber(TPhoneNumber tPhoneNumber)
    {
        return tPhoneNumberMapper.insertTPhoneNumber(tPhoneNumber);
    }

    /**
     * 修改手机管理
     * 
     * @param tPhoneNumber 手机管理
     * @return 结果
     */
    @Override
    public int updateTPhoneNumber(TPhoneNumber tPhoneNumber)
    {
        return tPhoneNumberMapper.updateTPhoneNumber(tPhoneNumber);
    }

    /**
     * 批量删除手机管理
     * 
     * @param ids 需要删除的手机管理主键
     * @return 结果
     */
    @Override
    public int deleteTPhoneNumberByIds(Long[] ids)
    {
        return tPhoneNumberMapper.deleteTPhoneNumberByIds(ids);
    }

    /**
     * 删除手机管理信息
     * 
     * @param id 手机管理主键
     * @return 结果
     */
    @Override
    public int deleteTPhoneNumberById(Long id)
    {
        return tPhoneNumberMapper.deleteTPhoneNumberById(id);
    }
}
