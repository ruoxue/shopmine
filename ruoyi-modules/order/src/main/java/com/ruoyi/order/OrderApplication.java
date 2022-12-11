package com.ruoyi.order;

import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import com.ruoyi.pay.core.client.PayClient;
import com.ruoyi.pay.core.client.PayClientFactory;
import com.ruoyi.pay.core.client.impl.PayClientFactoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * docker run --hostname=37473f0b4023
 * --env=MODE=standalone
 * --env=PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
 * --env=PREFER_HOST_MODE=ip --env=BASE_DIR=/home/nacos
 * --env=CLASSPATH=.:/home/nacos/conf:
 * --env=CLUSTER_CONF=/home/nacos/conf/cluster.conf
 * --env=FUNCTION_MODE=all
 * --env=JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk
 * --env=NACOS_USER=nacos
 * --env=JAVA=/usr/lib/jvm/java-1.8.0-openjdk/bin/java
 * --env=JVM_XMS=1g --env=JVM_XMX=1g --env=JVM_XMN=512m
 * --env=JVM_MS=128m --env=JVM_MMS=320m
 * --env=NACOS_DEBUG=n
 * --env=TOMCAT_ACCESSLOG_ENABLED=false
 * --env=TIME_ZONE=Asia/Shanghai
 * --volume=/Users/mi/IdeaProjects/shopmine/docker/nacos/logs:/home/nacos/logs:rw
 * --volume=/Users/mi/IdeaProjects/shopmine/docker/nacos/conf/application.properties:/home/nacos/conf/application.properties:rw
 * --volume=/home/nacos/conf/application.properties
 * --volume=/home/nacos/logs --network=docker_default
 * --workdir=/home/nacos -p 8848:8848 -p 9848:9848 -p
 * 9849:9849 --label='com.docker.compose.config-hash=21fa4a121b3cc24f963a2cbcbc870294c7d637f58aebf788abeacd41f76f7d3d' --label='com.docker.compose.container-number=1' --label='com.docker.compose.oneoff=False' --label='com.docker.compose.project=docker' --label='com.docker.compose.project.config_files=docker-compose.yml' --label='com.docker.compose.project.working_dir=/Users/mi/IdeaProjects/shopmine/docker' --label='com.docker.compose.service=ruoyi-nacos' --label='com.docker.compose.version=1.26.2' --label='org.label-schema.build-date=20201113' --label='org.label-schema.license=GPLv2' --label='org.label-schema.name=CentOS Base Image' --label='org.label-schema.schema-version=1.0' --label='org.label-schema.vendor=CentOS' --label='org.opencontainers.image.created=2022-10-20T13:16:07.660Z' --label='org.opencontainers.image.description=This project contains a Docker image meant to facilitate the deployment of Nacos .' --label='org.opencontainers.image.licenses=' --label='org.opencontainers.image.revision=3736ce9a58dbc74cf5f0d259e5d66e3a1abdadfd' --label='org.opencontainers.image.source=https://github.com/nacos-group/nacos-docker' --label='org.opencontainers.image.title=nacos-docker' --label='org.opencontainers.image.url=https://github.com/nacos-group/nacos-docker' --label='org.opencontainers.image.vendor=CentOS'
 * --label='org.opencontainers.image.version=v2.1.2' --runtime=runc -d nacos/nacos-server
 docker network inspect  docker_default
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);

    }
}
