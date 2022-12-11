package com.ruoyi.phone.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.ruoyi.phone.domain.SupBalanceModel;
import com.ruoyi.phone.domain.SuplierRetModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.phone.mapper.TSuplierMapper;
import com.ruoyi.phone.domain.TSuplier;
import com.ruoyi.phone.service.ITSuplierService;

/**
 * 供应商Service业务层处理
 *
 * @author ruoyi
 * @date 2022-12-06 14:58:04
 */
@Service
public class TSuplierServiceImpl implements ITSuplierService {
    @Autowired
    private TSuplierMapper tSuplierMapper;

    /**
     * 查询供应商
     *
     * @param supId 供应商主键
     * @return 供应商
     */
    @Override
    public TSuplier selectTSuplierBySupId(Long supId) {
        return tSuplierMapper.selectTSuplierBySupId(supId);
    }

    /**
     * 查询供应商列表
     *
     * @param tSuplier 供应商
     * @return 供应商
     */
    @Override
    public List<TSuplier> selectTSuplierList(TSuplier tSuplier) {
        return tSuplierMapper.selectTSuplierList(tSuplier);
    }

    /**
     * 新增供应商
     *
     * @param tSuplier 供应商
     * @return 结果
     */
    @Override
    public int insertTSuplier(TSuplier tSuplier) {
        return tSuplierMapper.insertTSuplier(tSuplier);
    }

    /**
     * 修改供应商
     *
     * @param tSuplier 供应商
     * @return 结果
     */
    @Override
    public int updateTSuplier(TSuplier tSuplier) {
        return tSuplierMapper.updateTSuplier(tSuplier);
    }

    /**
     * 批量删除供应商
     *
     * @param supIds 需要删除的供应商主键
     * @return 结果
     */
    @Override
    public int deleteTSuplierBySupIds(Long[] supIds) {
        return tSuplierMapper.deleteTSuplierBySupIds(supIds);
    }

    /**
     * 删除供应商信息
     *
     * @param supId 供应商主键
     * @return 结果
     */
    @Override
    public int deleteTSuplierBySupId(Long supId) {
        return tSuplierMapper.deleteTSuplierBySupId(supId);
    }

    @Override
    public int editAmount(TSuplier tSuplier) {
        TSuplier tSuplier1 = tSuplierMapper.selectTSuplierBySupId(tSuplier.getSupId());
        String url = tSuplier.getUrl();
        Map<String, Object> param = new HashMap<>();
        param.put("action", "balance");
        param.put("rt", "json");
        param.put("account", tSuplier.getAccount());
        param.put("password", tSuplier.getPwd());

        HttpResponse httpResponse = HttpUtil.createPost(url + "/sms").form(param).executeAsync();
        System.out.println(param);
        boolean ok = httpResponse.isOk();
        if (ok) {
            SupBalanceModel suplierRetModel = JSONUtil.toBean(httpResponse.body(), SupBalanceModel.class);
            if (0 == suplierRetModel.getStatus()) {
                tSuplier1.setBalance(suplierRetModel.getBalance());
                updateTSuplier(tSuplier1);
                return 1;
            }
        }
        return 0;

    }
}
