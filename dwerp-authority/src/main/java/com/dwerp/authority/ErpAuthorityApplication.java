package com.dwerp.authority;

import com.dwerp.facade.config.DwErpHessianAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * core启动类
 *
 * @author liuzm
 * @create 2018-02-27 17:30
 **/
@SpringBootApplication
@Import({DwErpHessianAutoConfiguration.class})
public class ErpAuthorityApplication {
    public static void main(String[] args) {
        SpringApplication.run(ErpAuthorityApplication.class, args);
    }
}
