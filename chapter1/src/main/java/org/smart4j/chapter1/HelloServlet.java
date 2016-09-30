package org.smart4j.chapter1;/**
 * Created by JuN on 16/9/29.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * hello servlet
 *
 * @authorJuN
 * @create2016-09-29 18:55
 */
public class HelloServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(new Date());

        req.setAttribute("currentTime",currentTime);
        req.getRequestDispatcher("/jsp/hello.jsp").forward(req,resp);
    }
}
