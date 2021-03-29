package jp.co.okato;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String loginId = req.getParameter("login_id");
        String password = req.getParameter("password");

        RequestDispatcher rd;

        if (password.equals("1234")) {
            rd = req.getRequestDispatcher("hello");
            rd.forward(req, res);
        } else {
            out.println("Invalid login id or password! ");
            rd = req.getRequestDispatcher("/index.html");
            rd.include(req, res);
        }

    }
}
