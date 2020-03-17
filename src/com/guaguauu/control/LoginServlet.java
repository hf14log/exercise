package com.guaguauu.control;

import com.guaguauu.entity.User;
import com.guaguauu.service.UserService;
import com.guaguauu.service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //用户在客户端（网页）填写登录的用户名和密码，获取请求数据
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        //将name和pwd封装，以便对应数据库进行curd操作
        User user = new User(name, pwd);
        //调用service进行逻辑处理
        User u = userService.checkUser(user);
        System.out.println(u);
        //设置响应编码
        response.setCharacterEncoding("gbk");
        //进行判断返回success or false
        if (u !=null){
            response.getWriter().write("登录成功");
        }else{
//            response.getWriter().write("登录失败");
            //请求转发
            //设置参数，实现不同servlet之间的数据共享
            request.setAttribute("str","用户名或密码错误");
            request.getRequestDispatcher("page").forward(request,response);
            //后续不需要逻辑代码处理
            return;

        }

    }
}
