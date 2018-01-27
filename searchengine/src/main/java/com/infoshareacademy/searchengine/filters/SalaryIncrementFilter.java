package com.infoshareacademy.searchengine.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(
        filterName = "SalaryIncrementFilter",
        urlPatterns = {"/welcome-user"},
        initParams = {
                @WebInitParam(name = "newSalary", value = "150.0")
        })
public class SalaryIncrementFilter implements Filter {

    double newSalary = 0.0;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        newSalary = Double.parseDouble(filterConfig.getInitParameter(   "newSalary"));
    }

    @Override
    public void destroy() {
        newSalary = 0.0;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String reqSalary = servletRequest.getParameter("salary");
        if (reqSalary == null || reqSalary.isEmpty()) {
            reqSalary = "0.0";
        }

        double salary = Double.parseDouble(reqSalary);
        if (salary < 100.0) {
            salary = newSalary;
        }
        servletRequest.setAttribute("salary", salary);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
