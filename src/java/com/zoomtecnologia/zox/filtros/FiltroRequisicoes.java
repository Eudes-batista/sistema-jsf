package com.zoomtecnologia.zox.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class FiltroRequisicoes implements Filter{

    @Override
    public void init(FilterConfig fc) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        sr.setCharacterEncoding("UTF-8");
        fc.doFilter(sr, sr1);
        
    }

    @Override
    public void destroy() {
        
    }
    
}
