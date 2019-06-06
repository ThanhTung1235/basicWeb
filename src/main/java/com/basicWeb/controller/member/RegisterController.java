package com.basicWeb.controller.member;

import com.basicWeb.entity.Member;
import com.basicWeb.model.MemberModel;
import com.basicWeb.utility.HandleString;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {
    private MemberModel model = new MemberModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member member = new Member();
        req.setAttribute("member", member);
        req.getRequestDispatcher("/member/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        try {
            String salt = HandleString.generateSalt();
            String passwords = salt + HandleString.stringHash(password);

            Member member = new Member();

            member.setUserName(name);
            member.setEmail(email);
            member.setPassword(passwords);
            member.setAddress(address);
            member.setPhone(phone);
            member.setSalt(salt);

            boolean isSuccess = model.register(member);
            if (isSuccess) {
                resp.getWriter().println("Register success" + new Gson().toJson(member));
            } else {
                resp.getWriter().println("Register failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
