package servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import model.registerModel;

@WebServlet("/registerServlet")
// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる
public class registerServlet extends HttpServlet {

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

        HttpSession session = request.getSession(false);



        //正しく入力されているかのチェック
        boolean check = true;
        // モデルをインスタンス化する
        registerModel registerModel = new registerModel();
        String forward_jsp = "/views/register.jsp";

        // ユーザによって入力された情報を取り出す
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String name = request.getParameter("name");
        String post = request.getParameter("post");
        String address = request.getParameter("address");
        String login = request.getParameter("login");
        String register = request.getParameter("register");
        String confirmation = request.getParameter("confirmation");


        if(login != null) {
        	forward_jsp = "/views/login.jsp";
        	session.removeAttribute("msg");
        	//session.invalidate();
        }


        // 取り出した情報を loginBean に格納する
        UserBean userBean = new UserBean();
        userBean.setUsername(username);
        userBean.setPassword(password);
        userBean.setPassword2(password2);
        userBean.setName(name);
        userBean.setPost(post);
        userBean.setAddress(address);


        if(register != null) {
        if(registerModel.accountCheck(username)) {
        	userBean.setMessege("既に使用されているユーザ名です。変更してください。");
        	request.setAttribute("msg",userBean);
        	check = false;
        }
        if(password.equals(password2)==false){
        	userBean.setPassmsg("パスワードの確認が取れませんでした。");
        	request.setAttribute("msg",userBean);
        	check = false;
        }
        if((username == "")|| (password == "") || (name == "") || (post == "") || (address == "")) {
        	userBean.setEmpmsg("入力されていない項目があります。");
            request.setAttribute("msg", userBean);

        }
        else if((username != "") && (password != "") && (name != "") && (post != "") && (address != "") && check) {

        	session = request.getSession(true);
            session.setAttribute("msg", userBean);
            System.out.println(2);
            forward_jsp = "/views/registerConfirmation.jsp";
        }
        }

        try {
        if(confirmation != null) {

        	//int postInt = Integer.parseInt(post);
        	registerModel.register(username, password, name, post, address);
        	userBean.setMessege("登録が完了しました。");
        	request.setAttribute("msg",userBean);
        	session.invalidate();
        	forward_jsp = "/views/success.jsp";
        }
        }catch(Exception e) {
        	//e.printStackTrace();
        	userBean.setMessege("登録に失敗しました。");
        	request.setAttribute("msg",userBean);
        	forward_jsp = "/views/registerConfirmation.jsp";
        }


        // forwaed_jsp に設定されているJSPへディスパッチ
        RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
        rDispatcher.forward(request, response);



    }
}