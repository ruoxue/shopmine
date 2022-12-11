package com.ruoyi.file.service;

import com.alibaba.nacos.shaded.com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.ruoyi.common.core.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@Service
public class QiniuFileServiceImpl implements ISysFileService {

    /**
     * 资源映射路径 前缀
     */
    @Value("${qiniu.accessKey}")
    public String accessKey;

    /**
     * 域名或本机访问地址
     */
    @Value("${qiniu.secretKey}")
    public String secretKey;

    /**
     * 上传文件存储在本地的根路径
     */
    @Value("${qiniu.bucket}")
    private String bucket;

    @Value("${qiniu.domain}")
    private String domain;
    @Override
    public String uploadFile(MultipartFile file) throws Exception {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.regionAs0());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本


        UploadManager uploadManager = new UploadManager(cfg);

        String key = UUID.fastUUID().toString(true) + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        try {
            Response response = uploadManager.put(file.getInputStream().readAllBytes(),
                    "images" + File.separator + key,
                    upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

            return  domain+putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            throw  new Exception(ex);

        }


    }
}
