package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionFinance;

/**
 * 财务数据Service接口
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:47
 */
public interface IReligionFinanceService 
{
    /**
     * 查询财务数据
     * 
     * @param id 财务数据主键
     * @return 财务数据
     */
    public ReligionFinance selectReligionFinanceById(Long id);

    /**
     * 查询财务数据列表
     * 
     * @param religionFinance 财务数据
     * @return 财务数据集合
     */
    public List<ReligionFinance> selectReligionFinanceList(ReligionFinance religionFinance);

    /**
     * 新增财务数据
     * 
     * @param religionFinance 财务数据
     * @return 结果
     */
    public int insertReligionFinance(ReligionFinance religionFinance);

    /**
     * 修改财务数据
     * 
     * @param religionFinance 财务数据
     * @return 结果
     */
    public int updateReligionFinance(ReligionFinance religionFinance);

    /**
     * 批量删除财务数据
     * 
     * @param ids 需要删除的财务数据主键集合
     * @return 结果
     */
    public int deleteReligionFinanceByIds(Long[] ids);

    /**
     * 删除财务数据信息
     * 
     * @param id 财务数据主键
     * @return 结果
     */
    public int deleteReligionFinanceById(Long id);
}