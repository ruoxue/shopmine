package com.ruoyi.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;

/**
 * 认证授权中心
 * 
 * @author ruoyi
 */
//docker run  --restart=always  --network common-network  --env=MYSQL_ROOT_PASSWORD=123456 -p 3306:3306  -t -d mysql


//         docker run -d \
//         --name nacos-server \
//         --network common-network    \
//         -e MODE=standalone -e prefer_host_mode=ip \-p 8848:8848 \-p 9848:9848 \-p 9849:9849 \
//         -e SPRING_DATASOURCE_PLATFORM=mysql \
//         -e MYSQL_SERVICE_HOST=172.18.0.2 \
//         -e MYSQL_SERVICE_PORT=3306 \
//         -e MYSQL_SERVICE_USER=root \
//         -e MYSQL_SERVICE_PASSWORD=123456 \
//         -e MYSQL_SERVICE_DB_NAME=ry_config \
//         nacos/nacos-server






@EnableRyFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RuoYiAuthApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(RuoYiAuthApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  认证授权中心启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |       \\  _. /  '       \n" +
                " |(_ o _) /        _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
    }
}
