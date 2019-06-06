package com.basicWeb.controller.member;

import com.basicWeb.entity.Member;
import com.basicWeb.model.MemberModel;
import com.basicWeb.utility.HandleString;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private MemberModel memberModel = new MemberModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName());
            }
        }
        HttpSession session = req.getSession();
        Member member = (Member) session.getAttribute("authentication");
        req.setAttribute("member", member);
        req.getRequestDispatcher("/member/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("name");
        String pass = req.getParameter("password");
        try {

            Member member = memberModel.authentication(username, Member.MemberStatus.DEACTIVE);
            if (member == null) {
                resp.getWriter().println("Account not found");
                resp.setStatus(404);
            } else {
                String password = member.getSalt() + HandleString.stringHash(pass);
                System.out.println(password);
                if (password.equals(member.getPassword())) {
                    HttpSession session = req.getSession();
                    session.setAttribute("authentication", member);
                    resp.getWriter().println("Login success" + new Gson().toJson(member));
                    resp.setStatus(200);
                } else {
                    resp.getWriter().println("Login failure");
                    resp.setStatus(401);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
