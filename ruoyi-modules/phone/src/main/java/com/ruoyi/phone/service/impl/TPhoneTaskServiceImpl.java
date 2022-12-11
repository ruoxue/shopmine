package com.ruoyi.phone.service.impl;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.core.utils.SpringUtils;
import com.ruoyi.common.core.utils.phone.PhoneUtil;
import com.ruoyi.phone.domain.*;
import com.ruoyi.phone.mapper.TPhoneNumberMapper;
import com.ruoyi.phone.mapper.TPhoneTaskMapper;
import com.ruoyi.phone.mapper.TSuplierMapper;
import com.ruoyi.phone.service.ITPhoneTaskService;
import com.ruoyi.phone.service.ITSmsDetailService;
import com.ruoyi.phone.service.ITSmsTemplateService;
import com.ruoyi.phone.util.SmsErrUtil;
import com.ruoyi.system.api.factory.RemoteLogFallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 生产任务Service业务层处理
 *
 * @author ruoyi
 * @date 2022-11-12 03:52:12
 */
@Service
public class TPhoneTaskServiceImpl implements ITPhoneTaskService {
    @Autowired
    private TPhoneTaskMapper tPhoneTaskMapper;
    @Autowired
    private TPhoneNumberMapper tPhoneNumberMapper;
    @Autowired
    private TSuplierMapper tSuplierService;

    private static final Logger log = LoggerFactory.getLogger(TPhoneTaskServiceImpl.class);

    @Autowired
    private ITSmsDetailService itSmsDetailService;
    @Autowired
    private ITSmsTemplateService itSmsTemplateService;

    /**
     * 资源映射路径 前缀
     */


    /**
     * 查询生产任务
     *
     * @param id 生产任务主键
     * @return 生产任务
     */
    @Override
    public TPhoneTask selectTPhoneTaskById(Long id) {
        return tPhoneTaskMapper.selectTPhoneTaskById(id);
    }

    /**
     * 查询生产任务列表
     *
     * @param tPhoneTask 生产任务
     * @return 生产任务
     */
    @Override
    public List<TPhoneTask> selectTPhoneTaskList(TPhoneTask tPhoneTask) {
        return tPhoneTaskMapper.selectTPhoneTaskList(tPhoneTask);
    }

    /**
     * 新增生产任务
     *
     * @param tPhoneTask 生产任务
     * @return 结果
     */
    @Override
    public int insertTPhoneTask(TPhoneTask tPhoneTask) {
        tPhoneTask.setCreateTime(DateUtils.getNowDate());
        return tPhoneTaskMapper.insertTPhoneTask(tPhoneTask);
    }

    /**
     * 修改生产任务
     *
     * @param tPhoneTask 生产任务
     * @return 结果
     */
    @Override
    public int updateTPhoneTask(TPhoneTask tPhoneTask) {
        tPhoneTask.setUpdateTime(DateUtils.getNowDate());
        return tPhoneTaskMapper.updateTPhoneTask(tPhoneTask);
    }

    /**
     * 批量删除生产任务
     *
     * @param ids 需要删除的生产任务主键
     * @return 结果
     */
    @Override
    public int deleteTPhoneTaskByIds(Long[] ids) {

        return tPhoneTaskMapper.deleteTPhoneTaskByIds(ids);
    }

    /**
     * 删除生产任务信息
     *
     * @param id 生产任务主键
     * @return 结果
     */
    @Override
    public int deleteTPhoneTaskById(Long id) {
        TPhoneTask tPhoneTask = tPhoneTaskMapper.selectTPhoneTaskById(id);
        try {
            boolean b = Files.deleteIfExists(Paths.get(tPhoneTask.getPath()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tPhoneTaskMapper.deleteTPhoneTaskById(id);
    }

    @Transactional
    @Override
    public int getPhone(Integer type) {

        if (type == 1) {
            log.info("生成手机号码定时任务");
            return SpringUtils.getAopProxy(this).getPhone();
        } else if (type == 2) {
            log.info("生成短信定时任务");
            return SpringUtils.getAopProxy(this).sendSms();
        } else if (type == 3) {
            log.info("重发短信定时任务");
            return SpringUtils.getAopProxy(this).sendRecycleSms();
        } else {
            return SpringUtils.getAopProxy(this).queryStatus();

        }
    }

    public  int queryStatus() {
        TSuplier tSuplierQuery = new TSuplier();
        tSuplierQuery.setStatus(1L);
        List<TSuplier> tSupliers = tSuplierService.selectTSuplierList(tSuplierQuery);
        TSuplier tSuplier = tSupliers.stream().findFirst().get();
        String url = tSuplier.getUrl();
        Map<String, Object> param = new HashMap<>();
        param.put("action", "report");
        param.put("rt", "json");
        param.put("account", tSuplier.getAccount());
        param.put("size", 100);
        param.put("password", tSuplier.getPwd());

        HttpResponse httpResponse = HttpUtil.createPost(url + "/sms").form(param).executeAsync();
        log.info(param.toString());

        boolean ok = httpResponse.isOk();
        if (ok) {
            String body = httpResponse.body();
            log.info("查询返回：" + "：发送返回" + body);

            SuplierRetModel suplierRetModel = JSONUtil.toBean(body, SuplierRetModel.class);
            if ("0".equals(suplierRetModel.getStatus())) {
                tSuplier.setBalance(suplierRetModel.getBalance());
                tSuplierService.updateTSuplier(tSuplier);

                for (int i = 0; i < suplierRetModel.getList().size(); i++) {
                    SuplierRetModel.ListDTO listDTO = suplierRetModel.getList().get(i);
                    TSmsDetail smsDetailQuery = new TSmsDetail();
                    smsDetailQuery.setRemark(listDTO.getMid());
                    smsDetailQuery.setPhoneNum(listDTO.getMobile());
                    TSmsDetail tSmsDetail = itSmsDetailService.selectTSmsDetailList(smsDetailQuery).stream().findFirst().get();
                    tSmsDetail.setResult(SmsErrUtil.getResult(listDTO.getStat()) + "\t");
                    if (listDTO.getStat().equals("DELIVRD")) {
                        tSmsDetail.setStatus(3L);
                        tSmsDetail.setUpdateTime(new Date());
                    } else {
                        tSmsDetail.setStatus(-1L);
                        tSmsDetail.setUpdateTime(new Date());
                    }
                    itSmsDetailService.updateTSmsDetail(tSmsDetail);

                }
            } else {
                tSuplier.setInfo(body);
                tSuplierService.updateTSuplier(tSuplier);
            }
        } else {

            log.error("调用三方失败" + httpResponse.getStatus());
        }
        return 0;
    }

    @Transactional
    public int sendRecycleSms() {
        try {
            TSmsDetail tSmsDetailQuery = new TSmsDetail();
            tSmsDetailQuery.setStatus(0L);
            tSmsDetailQuery.setCycle(1L);
            List<TSmsDetail> smsDetails = itSmsDetailService.selectTSmsDetailList(tSmsDetailQuery);


            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < smsDetails.size(); i++) {
                TSmsDetail tSmsDetail1 = smsDetails.get(i);
                if (tSmsDetail1.getSuplierId() == null)
                    continue;
                Long templateId = smsDetails.get(i).getTemplateId();
                TSmsTemplate tSmsTemplate = itSmsTemplateService.selectTSmsTemplateById(templateId);
                sb.append(smsDetails.get(i).getPhoneNum()).append("#").append(tSmsTemplate.getContent());
                sb.append("\n");
                TSmsDetail tSmsDetail = smsDetails.get(i);
                tSmsDetail.setStatus(1L);

                itSmsDetailService.updateTSmsDetail(tSmsDetail);
                TSuplier tSuplier = tSuplierService.selectTSuplierBySupId(tSmsDetail1.getSuplierId());
                SpringUtils.getAopProxy(this).senOneSms(sb.toString(), tSuplier, tSmsDetail1.getTaskId());

            }
        } catch (Exception e) {
            log.error("重发失败", e);
            return -3;
        }


        return 0;

    }

    @Transactional
    public int sendSms() {
        TPhoneTask queryTask = new TPhoneTask();
        queryTask.setStatus(2L);
        List<TPhoneTask> tPhoneTasks = selectTPhoneTaskList(queryTask);
        TSuplier tSuplierQuery = new TSuplier();
        tSuplierQuery.setStatus(1L);
        List<TSuplier> tSupliers = tSuplierService.selectTSuplierList(tSuplierQuery);
        TSuplier tSuplier = tSupliers.stream().findFirst().get();

        for (TPhoneTask tPhoneTask : tPhoneTasks) {
            try {
                TSmsDetail tSmsDetailQuery = new TSmsDetail();
                tSmsDetailQuery.setStatus(0L);
                tSmsDetailQuery.setTaskId(tPhoneTask.getId());
                tPhoneTask.setStatus(3L);
                tPhoneTaskMapper.updateTPhoneTask(tPhoneTask);
                List<TSmsDetail> smsDetails = itSmsDetailService.selectTSmsDetailList(tSmsDetailQuery);
                if (smsDetails.isEmpty()) {
                    log.info(tPhoneTask.getName() + ":没有数据");
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < smsDetails.size(); i++) {
                    Long templateId = smsDetails.get(i).getTemplateId();
                    TSmsTemplate tSmsTemplate = itSmsTemplateService.selectTSmsTemplateById(templateId);
                    sb.append(smsDetails.get(i).getPhoneNum()).append("#").append(tSmsTemplate.getContent());
                    sb.append("\n");
                    TSmsDetail tSmsDetail = smsDetails.get(i);
                    tSmsDetail.setStatus(1L);
                    itSmsDetailService.updateTSmsDetail(tSmsDetail);
                    if (i % tSuplier.getMax() == 0) {
                        SpringUtils.getAopProxy(this).senOneSms(sb.toString(), tSuplier, tPhoneTask.getId());
                        sb = new StringBuilder();
                    }
                }
                if (sb.length() > 0)
                    SpringUtils.getAopProxy(this).senOneSms(sb.toString(), tSuplier, tPhoneTask.getId());
            } catch (Exception e) {
                tPhoneTask.setStatus(4L);
                tPhoneTaskMapper.updateTPhoneTask(tPhoneTask);
                log.error(tPhoneTask.getName() + ":发送失败", e);
                return -4;

            }

        }
        return 0;

    }

    public void senOneSms(String smsDetail, TSuplier tSuplier, Long taskId) {
        String url = tSuplier.getUrl();
        Map<String, Object> param = new HashMap<>();
        param.put("action", "p2p");
        param.put("rt", "json");
        param.put("account", tSuplier.getAccount());
        param.put("extno", tSuplier.getExtno());
        param.put("password", tSuplier.getPwd());
        param.put("mobileContentList", (smsDetail));

        HttpResponse httpResponse = HttpUtil.createPost(url + "/sms").form(param).executeAsync();
        log.info(param.toString());
        boolean ok = httpResponse.isOk();
        if (ok) {
            String body = httpResponse.body();
            log.info("taskId：" + taskId + "：发送返回" + body);

            SuplierRetModel suplierRetModel = JSONUtil.toBean(body, SuplierRetModel.class);
            if ("0".equals(suplierRetModel.getStatus())) {
                tSuplier.setBalance(suplierRetModel.getBalance());
                tSuplierService.updateTSuplier(tSuplier);

                for (int i = 0; i < suplierRetModel.getList().size(); i++) {
                    SuplierRetModel.ListDTO listDTO = suplierRetModel.getList().get(i);
                    TSmsDetail smsDetailQuery = new TSmsDetail();
                    smsDetailQuery.setTaskId(taskId);
                    smsDetailQuery.setStatus(1L);
                    smsDetailQuery.setPhoneNum(listDTO.getMobile());
                    TSmsDetail tSmsDetail = itSmsDetailService.selectTSmsDetailList(smsDetailQuery).stream().findFirst().get();
                    tSmsDetail.setRemark(listDTO.getMid());
                    tSmsDetail.setResult(SmsErrUtil.getResult(listDTO.getResult() + ""));
                    if (listDTO.getResult() == 0) {
                        tSmsDetail.setStatus(2L);
                        tSmsDetail.setUpdateTime(new Date());
                    } else {
                        tSmsDetail.setStatus(-1L);
                        tSmsDetail.setUpdateTime(new Date());
                    }
                    itSmsDetailService.updateTSmsDetail(tSmsDetail);

                }
            } else {
                tSuplier.setInfo(body);
                tSuplierService.updateTSuplier(tSuplier);
            }
        } else {

            log.error("调用三方失败" + httpResponse.getStatus());
        }

    }

    public int getPhone() {
        TPhoneTask queryTask = new TPhoneTask();
        queryTask.setStatus(0L);
        List<TPhoneTask> tPhoneTasks = selectTPhoneTaskList(queryTask);
        if (tPhoneTasks.isEmpty()) {
            log.info("没有需要生成手机号的任务");
            return -1;
        }
        for (TPhoneTask tPhoneTask : tPhoneTasks) {
            tPhoneTask.setStatus(1L);
            tPhoneTaskMapper.updateTPhoneTask(tPhoneTask);
        }
        return getRealPhone(tPhoneTasks);
    }

    public int getRealPhone(List<TPhoneTask> tPhoneTasks) {
        for (TPhoneTask tPhoneTask : tPhoneTasks) {
            try {
                int onePhone = getOnePhone(tPhoneTask);
            } catch (Exception e) {
                tPhoneTask.setStatus(0L);
                tPhoneTaskMapper.updateTPhoneTask(tPhoneTask);
                log.error(tPhoneTask.getName() + "生成手机号任务异常", e);

            }
        }
        return 0;
    }

    public int getOnePhone(TPhoneTask tPhoneTask) throws Exception {
        if (tPhoneTask.getStatus() != 1L) {
            log.info(tPhoneTask.getName() + "任务状态失败");
            return -2;
        }

        String scope = tPhoneTask.getScope();
        String[] split = scope.split("-");
        long start = Long.parseLong(split[0].replace("[", ""));

        if (split.length == 1) {

            Long num = tPhoneTask.getNum();
            if (num <= 0) {
                num = 1L;
            }
            TSmsDetail smsDetail = null;

            for (int i = 0; i < num.longValue(); i++) {
                smsDetail = new TSmsDetail();
                smsDetail.setTaskId(tPhoneTask.getId());
                smsDetail.setRemark(tPhoneTask.getRemark());
                smsDetail.setTemplateId(tPhoneTask.getTemplateId());
                smsDetail.setCreateTime(DateUtils.getNowDate());
                Long phone = PhoneUtil.genPhone(start);
                if (phone == null) {
                    log.info("号码生成失败");
                    continue;
                }
                smsDetail.setPhoneNum(String.valueOf(phone));
                TPhoneNumber tPhoneNumber = new TPhoneNumber();
                tPhoneNumber.setNumber(Long.parseLong(String.valueOf(phone).substring(0, 7)));
                try {
                    List<TPhoneNumber> tPhoneNumbers = tPhoneNumberMapper.selectTPhoneNumberList(tPhoneNumber);
                    if (tPhoneNumbers.stream().findFirst().isPresent()) {
                        smsDetail.setCity(tPhoneNumbers.stream().findFirst().get().getCity());
                        if (smsDetail.getCity().contains("周"))
                            continue;
                    } else {
                        if (tPhoneTask.getInSystem() == 1) {
                            continue;
                        }
                    }
                } catch (Exception e) {
                    log.error(smsDetail.getPhoneNum() + "生成失败", e);
                }
                smsDetail.setStatus(0L);
                itSmsDetailService.insertTSmsDetail(smsDetail);
            }
            tPhoneTask.setStatus(2L);
            tPhoneTaskMapper.updateTPhoneTask(tPhoneTask);


        } else {
            long end = Long.parseLong(split[1].replace("]", ""));
            TSmsDetail smsDetail = null;
            for (long i = start; i <= end; i++) {
                smsDetail = new TSmsDetail();
                smsDetail.setTaskId(tPhoneTask.getId());
                smsDetail.setPhoneNum(String.valueOf(i));
                smsDetail.setRemark(tPhoneTask.getRemark());
                smsDetail.setTemplateId(tPhoneTask.getTemplateId());
                smsDetail.setCreateTime(DateUtils.getNowDate());
                TPhoneNumber tPhoneNumber = new TPhoneNumber();
                tPhoneNumber.setNumber(Long.parseLong(String.valueOf(i).substring(0, 7)));
                try {
                    List<TPhoneNumber> tPhoneNumbers = tPhoneNumberMapper.selectTPhoneNumberList(tPhoneNumber);
                    if (tPhoneNumbers.stream().findFirst().isPresent()) {
                        smsDetail.setCity(tPhoneNumbers.stream().findFirst().get().getCity());
                        if (smsDetail.getCity().contains("周"))
                            continue;
                    } else {
                        if (tPhoneTask.getInSystem() == 1) {
                            continue;
                        }
                    }
                } catch (Exception e) {
                    log.error(smsDetail.getPhoneNum() + "生成失败2", e);

                }
                smsDetail.setStatus(0L);

                itSmsDetailService.insertTSmsDetail(smsDetail);
            }

            tPhoneTask.setStatus(2L);
            tPhoneTaskMapper.updateTPhoneTask(tPhoneTask);
        }
        return 0;
    }


}
