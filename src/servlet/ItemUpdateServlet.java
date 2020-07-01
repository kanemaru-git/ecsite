package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ItemBean;
import model.ItemModel;

@WebServlet("/ItemUpdateServlet")
// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる
public class ItemUpdateServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// GETリクエストはあり得ないので、無条件でログイン画面に飛ばす
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/login.jsp");
		rDispatcher.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// 文字のエンコードを UTF-8 とする。これがないと文字化け。
		request.setCharacterEncoding("UTF-8");

		// フォワード先指定
		String forward_jsp = "/views/item_update.jsp";

		// インスタンス
		ItemModel itemModel = new ItemModel();

		// リクエスト入力値
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

		// ItemBeanに情報を格納
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

		// itemBeanをsetAttribute
		request.setAttribute("itemes", itemBean);

		// リクエストボタン取得
		String view = request.getParameter("view");
		String update = request.getParameter("update");
		String update_confirm = request.getParameter("update_confirm");

		/**
		 * 変更商品検索
		 */
		if (view != null) {
			try {
				itemBean = itemModel.itemSerchList(item_code);
				request.setAttribute("itemes", itemBean);
				forward_jsp = "/views/item_update.jsp";
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				request.setAttribute("emsg", "商品コードが存在しません。");
				forward_jsp = "/views/item_update.jsp";
			}

		}

		/**
		 * 変更時
		 */
		if (update != null) {
			try {
				if (item_code.isBlank() || item_name.isBlank() || phonetic.isBlank() || author.isBlank()
						|| publisher.isBlank() || price.isBlank() || category.isBlank() || stock.isBlank()
						|| details.isBlank() || serch_word.isBlank()) {
					request.setAttribute("isBlank", "入力されていない項目があります。");
					forward_jsp = "/views/item_update.jsp";
				} else if (itemModel.itemSerch(item_code)) {
					forward_jsp = "/views/item_updateConfirm.jsp";
				} else {
					// int priceInt = Integer.parseInt(price);
					// itemModel.updateMove(item_code, item_name, priceInt, category);
					// request.setAttribute("itemes",itemBean);
					request.setAttribute("emsg", "商品コードが存在しません。");
					forward_jsp = "/views/item_update.jsp";
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("emsg", "商品コードが存在しません。");
				forward_jsp = "/views/item_update.jsp";
			}
		}

		/**
		 * 変更実行
		 */
		if (update_confirm != null) {

			try {
				if (itemModel.itemSerch(item_code)) {
					int priceInt = Integer.parseInt(price);
					int stockInt = Integer.parseInt(stock);
					itemModel.updateMove(item_code, item_name, phonetic, author, publisher, priceInt, category,
							stockInt, details, serch_word);
					request.setAttribute("update", "変更しました。");
					forward_jsp = "/views/item_updateConfirm.jsp";
				} else {
					request.setAttribute("emsg", "商品コードが存在しません");
					forward_jsp = "/views/item_updateConfirm.jsp";
				}
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				request.setAttribute("emsg", "変更に失敗しました。");
				forward_jsp = "/views/item_updateConfirm.jsp";
			}
		}

		// forwaed_jsp に設定されているJSPへディスパッチ
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);

	}

}