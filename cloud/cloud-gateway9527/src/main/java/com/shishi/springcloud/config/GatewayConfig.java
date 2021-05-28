package com.shishi.springcloud.config;

import com.netflix.appinfo.MyDataCenterInfo;
import com.shishi.springcloud.filter.MyLogGatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route3",r->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route4",r->r.path("/dayanjing").uri("https://home.cnblogs.com/u/dayanjing/")).build();
        return routes.build();
    }

    @Bean
    public MyLogGatewayFilter getFilter() {
        return new MyLogGatewayFilter();
    }
}


