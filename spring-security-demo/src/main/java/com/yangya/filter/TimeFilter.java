/**
 * 
 */
package com.yangya.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

@Component
public class TimeFilter implements Filter {

    //不需要登录就可以访问的路径(比如:注册登录等)
	 
    String[] includeUrls = new String[]{"/login","/register","/login.html"};
    
	@Override
	public void destroy() {
		System.out.println("time filter destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("time filter start");
		long start = new Date().getTime();
		chain.doFilter(request, response);
		System.out.println("time filter 耗时:"+ (new Date().getTime() - start));
		System.out.println("time filter finish");
	}
	
	/**
     * @Description: 是否需要过滤
     */
    public boolean isNeedFilter(String uri) {
        for (String includeUrl : includeUrls) {
            if(includeUrl.equals(uri)) {
                return false;
            }
        }
        return true;
 
    }

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("time filter init");
	}
	

}
