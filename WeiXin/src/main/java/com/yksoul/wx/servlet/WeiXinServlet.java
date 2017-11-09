package com.yksoul.wx.servlet;

import com.yksoul.wx.utils.CheackUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yk
 * @version 1.0 Date: 2017/5/18
 */
@WebServlet("/weiXinServlet")
public class WeiXinServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        PrintWriter out = resp.getWriter();
        if(CheackUtil.checkSignature(signature,timestamp, nonce)){
            out.print(echostr);
        }
    }
}
