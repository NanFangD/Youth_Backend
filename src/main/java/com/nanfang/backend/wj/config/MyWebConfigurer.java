package com.nanfang.backend.wj.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author nanfang
 * @create 2020/02/10/11:13
 */
@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer {

    //拦截图片访问地址，并改变为当前地址
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("test");
//       存取图片路径取代
        registry.addResourceHandler("/api/file/**").addResourceLocations("file:" + "/home/Youth-imgs/");
    }
}
