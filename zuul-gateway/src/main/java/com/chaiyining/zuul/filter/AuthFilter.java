package com.chaiyining.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "per";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    //添加过滤条件
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext=RequestContext.getCurrentContext();
        HttpServletRequest request= requestContext.getRequest();
        String requestURI =request.getRequestURI();
        System.out.println(requestURI);
        //放行
        if (requestURI.startsWith("/user")){
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext=RequestContext.getCurrentContext();
        HttpServletRequest request= requestContext.getRequest();
        System.out.println("run"+request.getRequestURI());
        //判断是否授权
        String  token =request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            /** 表示不进行路由,不会被zuul转发到后端服务器 **/
            requestContext.setSendZuulResponse(false);
            /** http状态码，标识未授权 **/
            requestContext.setResponseStatusCode(401);
            /** **/
            HttpServletResponse response= requestContext.getResponse();
            response.setContentType("application/json;charset=utf-8");
            try {
                response.getWriter().write("{\"code\":401,\"message:\":未授权}");

            }catch (IOException e){

            }
        }
        return null;
    }
}
