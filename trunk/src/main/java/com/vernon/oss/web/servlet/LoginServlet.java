package com.vernon.oss.web.servlet;

import com.vernon.oss.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 13-11-24
 * Time: PM10:56
 * To change this template use File | Settings | File Templates.
 */
public class LoginServlet extends HttpServlet{
    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("------------ LoginServlet process() -------------");
        String path = request.getServletPath();
        logger.info("path : {}" + path);
        if (path.startsWith("/login") || "/".equals(path)) {
            response.sendRedirect(Constant.DOMAIN + "/login.do");
        } else {
            response.sendRedirect(Constant.DOMAIN);
        }

    }
}
