package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ItemBean;
import model.ItemModel;

@WebServlet("/ItemServlet")
// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる
public class ItemServlet extends HttpServlet {

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

        //フォワード先指定
        String forward_jsp = "/views/item_serch.jsp";

        //インスタンス
        ItemModel itemModel = new ItemModel();

        //リクエスト入力値
        String item_code = request.getParameter("item_code");
        String item_name = request.getParameter("item_name");
        String phonetic = request.getParameter("phonetic");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        String stock = request.getParameter("stock");
        String details = request.getParameter("details");
        String serch_word = request.getParameter("serch_word");

        //ItemBeanに情報を格納
        ItemBean itemBean = new ItemBean();
        itemBean.setItem_code(item_code);
        itemBean.setItem_name(item_name);
        itemBean.setPhonetic(phonetic);
        itemBean.setAuthor(author);
        itemBean.setPublisher(publisher);
        itemBean.setPrice(price);
        itemBean.setCategory(category);
        itemBean.setStock(stock);
        itemBean.setDetails(details);
        itemBean.setSerch_word(serch_word);

        //itemBeanをsetAttribute
        //request.setAttribute("itemes",itemBean);

        //リクエストボタン取得
        String update = request.getParameter("update");
        String all = request.getParameter("all");
        String serch = request.getParameter("serch");
        String delete = request.getParameter("delete");
        String delete_view = request.getParameter("delete_view");
        String delete_confirm = request.getParameter("delete_confirm");

        /**
         * すべて表示ボタン押下時
         */
        if(all != null) {
        try {
        	//ItemModel itemModel = new ItemModel();
            List<ItemBean> itemes = itemModel.itemAll();
            request.setAttribute("itemes", itemes);
        }catch(Exception e) {
        	request.setAttribute("emsg", "表示に失敗しました");
        }
        }

        /**
         * 商品コード検索時
         */
        if(serch != null) {
        try {
        if(item_code != "") {
        //ItemModel itemModel = new ItemModel();
        List<ItemBean> itemes = itemModel.itemSerchLike(item_code);
        request.setAttribute("itemes", itemes);
        }
        }catch(Exception e) {
        	System.out.println("eeee");
        	request.setAttribute("emsg", "商品コードが存在しません");
        }
        }

        /**
         * 削除商品検索
         */
        if(delete_view != null) {
        	try {
				if(itemModel.itemSerch(item_code)) {
					itemBean = itemModel.itemSerchList(item_code);
					request.setAttribute("itemes", itemBean);
				}else {
					itemBean.setItem_code(item_code);
					request.setAttribute("itemes", itemBean);
					request.setAttribute("emsg", "商品コードが存在しません");
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("emsg", "表示に失敗しました");
			}
        	forward_jsp = "/views/item_delete.jsp";
            }

        /**
         * 削除時
         */
        if(delete != null) {
        	 try {
				if(itemModel.itemSerch(item_code)) {

					if(item_name.isEmpty()) {
						forward_jsp = "/views/item_delete.jsp";
						request.setAttribute("itemes", itemBean);
						request.setAttribute("emsg", "←検索ボタンを押して、商品内容を確認してください");
					}else {
						request.setAttribute("itemes", itemBean);
						forward_jsp = "/views/item_deleteConfirmation.jsp";
					}
				 }else {
					 itemBean.setItem_code(item_code);
					 request.setAttribute("itemes", itemBean);
					 request.setAttribute("emsg", "商品コードが存在しません");
					 forward_jsp = "/views/item_delete.jsp";
				 }
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
        }

        /**
         * 削除実行
         */
        if(delete_confirm != null) {
        	try {
				itemModel.deleteMove(item_code);
				request.setAttribute("msg", "削除しました。");
				forward_jsp = "/views/item_deleteConfirmation.jsp";
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				request.setAttribute("emsg", "削除に失敗しました。");
				forward_jsp = "/views/item_deleteConfirmation.jsp";
			}
        }

        // forwaed_jsp に設定されているJSPへディスパッチ
        RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
        rDispatcher.forward(request, response);

    }


}