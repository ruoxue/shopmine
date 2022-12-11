package com.ruoyi.phone.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.phone.mapper.TSmsDetailMapper;
import com.ruoyi.phone.domain.TSmsDetail;
import com.ruoyi.phone.service.ITSmsDetailService;

/**
 * 短信内容Service业务层处理
 *
 * @author ruoyi
 * @date 2022-12-06 14:58:03
 */
@Service
public class TSmsDetailServiceImpl implements ITSmsDetailService {
    @Autowired
    private TSmsDetailMapper tSmsDetailMapper;

    /**
     * 查询短信内容
     *
     * @param id 短信内容主键
     * @return 短信内容
     */
    @Override
    public TSmsDetail selectTSmsDetailById(Long id) {
        return tSmsDetailMapper.selectTSmsDetailById(id);
    }

    /**
     * 查询短信内容列表
     *
     * @param tSmsDetail 短信内容
     * @return 短信内容
     */
    @Override
    public List<TSmsDetail> selectTSmsDetailList(TSmsDetail tSmsDetail) {
        return tSmsDetailMapper.selectTSmsDetailList(tSmsDetail);
    }

    /**
     * 新增短信内容
     *
     * @param tSmsDetail 短信内容
     * @return 结果
     */
    @Override
    public int insertTSmsDetail(TSmsDetail tSmsDetail) {
        try {

            tSmsDetail.setCreateTime(DateUtils.getNowDate());
            tSmsDetail.setUpdateTime(DateUtils.getNowDate());
            return tSmsDetailMapper.insertTSmsDetail(tSmsDetail);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 修改短信内容
     *
     * @param tSmsDetail 短信内容
     * @return 结果
     */
    @Override
    public int updateTSmsDetail(TSmsDetail tSmsDetail) {
        tSmsDetail.setUpdateTime(DateUtils.getNowDate());
        return tSmsDetailMapper.updateTSmsDetail(tSmsDetail);
    }

    /**
     * 批量删除短信内容
     *
     * @param ids 需要删除的短信内容主键
     * @return 结果
     */
    @Override
    public int deleteTSmsDetailByIds(Long[] ids) {
        return tSmsDetailMapper.deleteTSmsDetailByIds(ids);
    }

    /**
     * 删除短信内容信息
     *
     * @param id 短信内容主键
     * @return 结果
     */
    @Override
    public int deleteTSmsDetailById(Long id) {
        return tSmsDetailMapper.deleteTSmsDetailById(id);
    }
}
