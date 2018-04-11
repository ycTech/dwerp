package com.dwerp.facade.config;


import com.dwerp.facade.hessian.HessianClientProxyBeanDefinitionRegistryProcessor;
import com.dwerp.facade.hessian.HessianService;
import com.dwerp.facade.hessian.HessianServiceExporterBeanDefinitionRegistry;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * hessian自动注入
 *
 * @author liuzm
 * @create 2018-02-27 17:40
 **/

@Configuration
public class DwErpHessianAutoConfiguration implements ApplicationContextAware {

        /**
         * tc core hessian服务端地址配置参数
         */
        private static final String REMOTE_URL_PROPERTY_NAME = "tims.core.server.host.hessian.url";

        private ApplicationContext applicationContext;

        @Bean(name = "dwErpHessianServiceExporterBeanDefinitionRegistryPostProcessor")
        public HessianServiceExporterBeanDefinitionRegistry hessianServiceExporterBeanDefinitionRegistryPostProcessor() throws Exception {
            return new HessianServiceExporterBeanDefinitionRegistry(this.applicationContext);
        }

        @Bean(name = "dwErpHessianClientProxyBeanDefinitionRegistryParser")
        public HessianClientProxyBeanDefinitionRegistryProcessor hessianClientProxyBeanDefinitionRegistryParser() {
            HessianClientProxyBeanDefinitionRegistryProcessor parser = new HessianClientProxyBeanDefinitionRegistryProcessor();
            parser.setAnnotationClass(HessianService.class);
            parser.setRemoteURLPropertyName(REMOTE_URL_PROPERTY_NAME); //hessian服务端地址
            parser.setBasePackage("com.dwerp.facade.api");    //hessian api 接口包目录
            return parser;
        }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.applicationContext = applicationContext;
        }

}
