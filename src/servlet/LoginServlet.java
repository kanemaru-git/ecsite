package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ItemBean;
import bean.LoginBean;
import bean.UserBean;
import model.ItemUserModel;
import model.LoginModel;

@WebServlet("/LoginServlet")
// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる
public class LoginServlet extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        if(session.getAttribute("isLogin") != "1") {
        	forward_jsp = "/views/login.jsp";
        }

        // ユーザによって入力された情報を取り出す
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 取り出した情報を loginBean に格納する
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        // モデルをインスタンス化する
        LoginModel loginModel = new LoginModel();
        //String forward_jsp = "/views/login.jsp";

        // 入力された情報がDBに存在するか調べる
        if (loginModel.loginCheck(username, password)) {

        	if(username.equals("admin") && password.equals("admin")) {
        		session.setAttribute("isLogin", "1");
        		forward_jsp = "/views/item_serch.jsp";
        	}else {
        	session = request.getSession(true);
            session.setAttribute("usernamesession", username);
            UserBean user = new UserBean();
            user = loginModel.userSerch(username);
            session.setAttribute("usersession", user);
            ItemUserModel itemUserModel = new ItemUserModel();
            List<ItemBean> itemList;
			try {
				itemList = itemUserModel.itemSerchLike("人気", "", "price");
				request.setAttribute("itemes",itemList);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}


            // ログインに成功した先の JSP を指定
            forward_jsp = "/views/index.jsp";
        	}
        // ログインが失敗したときの処理
        } else {
            // エラーメッセージを設定
            loginBean.setEmsg("ユーザ名またはパスワードが違います");
            request.setAttribute("loginBean", loginBean);
        }
        // forwaed_jsp に設定されているJSPへディスパッチ
        RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
        rDispatcher.forward(request, response);

    }
}