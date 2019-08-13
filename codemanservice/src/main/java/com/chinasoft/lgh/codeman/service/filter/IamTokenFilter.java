package com.chinasoft.lgh.codeman.service.filter;

import com.alibaba.fastjson.JSON;
import com.chinasoft.lgh.iam.core.config.Constants;
import com.chinasoft.lgh.iam.core.model.MUser;
import com.chinasoft.lgh.iam.core.pojo.Response;
import com.chinasoft.lgh.iam.core.util.TokenStore;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@ServletComponentScan
@WebFilter(filterName = "iamFilter", urlPatterns = "/**")
public class IamTokenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestFacade facade = (RequestFacade) servletRequest;
        String tokenHeader = facade.getHeader(Constants.IAM_TOKEN_HEADER);
        if (StringUtils.isEmpty(tokenHeader)) {
            String path = facade.getServletPath();
            if (path.startsWith(Constants.PUBLIC)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                failed(servletResponse);
            }
        } else {
            try {
                MUser user = JSON.parseObject(Base64Utils.decodeFromString(tokenHeader), MUser.class);
                if (user.isLogged()) {
                    if (System.currentTimeMillis() > user.getLoginTime() + user.getExpireTime()) {
                        failed(servletResponse);
                    } else {
                        TokenStore.currentUser.set(user);
                        filterChain.doFilter(servletRequest, servletResponse);
                    }
                } else {
                    String path = facade.getServletPath();
                    if (path.startsWith(Constants.PUBLIC)) {
                        filterChain.doFilter(servletRequest, servletResponse);
                    } else {
                        failed(servletResponse);
                    }
                }
            } catch (Exception e) {
                failed(servletResponse);
            }

        }

    }

    private void failed(ServletResponse servletResponse) throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        Response response = Response.error("token 校验失败");
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "*");
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "*");
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpServletResponse.getWriter().write(JSON.toJSONString(response));
        httpServletResponse.getWriter().flush();
    }

    @Override
    public void destroy() {

    }
}
