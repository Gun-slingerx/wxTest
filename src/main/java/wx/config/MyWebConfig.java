package wx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    //注入
    @Autowired
    private LoginInterceptor loginInterceptor;

    //将拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**") //拦截所有的 url
                .excludePathPatterns("/test/get");
    }
}
