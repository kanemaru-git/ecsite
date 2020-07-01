package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる
public class LogoutServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

        // GETリクエストはあり得ないので、無条件でログイン画面に飛ばす
        RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/login.jsp");
        rDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

        // 文字のエンコードを UTF-8 とする。これがないと文字化け。
        request.setCharacterEncoding("UTF-8");

        String forward_jsp = "/views/login.jsp";

        //セッション
        HttpSession session = request.getSession();
        session.invalidate();
//        if(session.getAttribute("isLogin") != null) {
//        	session.removeAttribute("isLogin");
//        	session.invalidate();
//        }
//        if (session.getAttribute("usernamesession") != null) {
//            session.removeAttribute("usernamesession");
//        }


        // forwaed_jsp に設定されているJSPへディスパッチ
        RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
        rDispatcher.forward(request, response);

    }
}