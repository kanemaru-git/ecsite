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

import bean.CartBean;
import bean.HistoryBean;
import bean.ItemBean;
import model.ItemUserModel;

@WebServlet("/ItemUserServlet")
// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる
public class ItemUserServlet extends HttpServlet {

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
		String forward_jsp = "/views/index.jsp";

		// インスタンス
		ItemUserModel itemUserModel = new ItemUserModel();

		// 検索に関するリクエスト取得
		String keyword = request.getParameter("keyword");
		String category = request.getParameter("category");
		String sort = request.getParameter("sort");

		// リクエスト入力値
		String item_code = request.getParameter("item_code");
		String item_name = request.getParameter("item_name");
		String price = request.getParameter("price");
		String count = request.getParameter("count");
		// String category = request.getParameter("category");

		// ItemBean
		ItemBean itemBean = new ItemBean();

		String details = request.getParameter("details");
		String purchase = request.getParameter("purchase");
		String cart = request.getParameter("cart");
		String history = request.getParameter("history");
		String purchase_confirm = request.getParameter("purchase_confirm");
		String purchase_finish = request.getParameter("purchase_finish");
		String purchase_back = request.getParameter("purchase_back");
		String back = request.getParameter("back");
		String delete_cart = request.getParameter("delete_cart");
		String cart_back = request.getParameter("cart_back");
		String account = request.getParameter("account");

		if (cart == null && history == null && account == null && details == null && purchase == null
				&& purchase_confirm == null && purchase_finish == null && back == null && delete_cart == null
				&& purchase_back == null) {
			try {
				if (cart_back != null) {
					keyword = "人気";
					category = "";
					sort = "";
				}
				List<ItemBean> itemList = itemUserModel.itemSerchLike(keyword, category, sort);
				request.setAttribute("itemes", itemList);
				request.setAttribute("keyword", keyword);
				request.setAttribute("category", category);
				request.setAttribute("sort", sort);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				System.out.println("検索エラー");
				e.printStackTrace();
				request.setAttribute("emsg", "該当する商品がありませんでした。");
			}
		}

		// 詳細ボタン
		if (details != null) {
			try {
				itemBean = itemUserModel.itemSerchList(item_code);
				request.setAttribute("itemes", itemBean);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				System.out.println("詳細エラー");
				e.printStackTrace();
			}
			forward_jsp = "/views/details.jsp";
		}

		// 購入ボタン(カート表示)
		if (purchase != null || purchase_back != null) {
			// カートテーブルに挿入
			HttpSession session = request.getSession(true);
			String username = (String) session.getAttribute("usernamesession");
			try {
				if (purchase != null) {
					int priceInt = Integer.parseInt(price);
					int countInt = Integer.parseInt(count);

					itemUserModel.intoCart(username, item_code, item_name, priceInt, countInt);
				}
				List<CartBean> cartList = itemUserModel.cartSerch(username);

				request.setAttribute("cart", cartList);
				request.setAttribute("sum", "合計" + String.valueOf(itemUserModel.getSum()) + "円");
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				System.out.println("購入エラー");
				e.printStackTrace();
			}
			forward_jsp = "/views/cart.jsp";
		}

		// カートボタン
		if (cart != null || delete_cart != null) {
			// カートテーブルを検索
			HttpSession session = request.getSession(true);
			String username = (String) session.getAttribute("usernamesession");
			try {
				if (delete_cart != null) {
					itemUserModel.deleteItemCart(username, item_code);
				}

				List<CartBean> cartList = itemUserModel.cartSerch(username);
				request.setAttribute("cart", cartList);
				request.setAttribute("sum", "合計：" + String.valueOf(itemUserModel.getSum()) + "円");
				forward_jsp = "/views/cart.jsp";
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				System.out.println("cartエラー");
				e.printStackTrace();
				request.setAttribute("emsg", "カートに商品が入っていません。");
				forward_jsp = "/views/cart.jsp";
			}
		}

		// 購入履歴ボタン
		if (history != null) {
			HttpSession session = request.getSession(true);
			String username = (String) session.getAttribute("usernamesession");
			try {
				List<HistoryBean> historyList = itemUserModel.historySerch(username);
				request.setAttribute("history", historyList);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				System.out.println("購入履歴エラー");
				e.printStackTrace();
				request.setAttribute("emsg", "購入履歴はありません。");
			}
			forward_jsp = "/views/history.jsp";
		}

		// 購入確認ボタン
		if (purchase_confirm != null) {
			HttpSession session = request.getSession(true);
			String username = (String) session.getAttribute("usernamesession");
			try {
				List<CartBean> cartList = itemUserModel.cartSerch(username);
				request.setAttribute("cart", cartList);
				request.setAttribute("sum", "合計：" + String.valueOf(itemUserModel.getSum()) + "円");
				forward_jsp = "/views/purchase_confirm.jsp";
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				System.out.println("購入確認エラー");
				e.printStackTrace();
				request.setAttribute("emsg", "カートに商品を入れてください。");
				forward_jsp = "/views/cart.jsp";
			}
		}

		// 購入完了ボタン
		if (purchase_finish != null) {
			HttpSession session = request.getSession(true);
			String username = (String) session.getAttribute("usernamesession");

			try {

				itemUserModel.deleteUserCart(username);
				String[] arr_username = request.getParameterValues("username");
				String[] arr_item_code = request.getParameterValues("item_code");
				String[] arr_item_name = request.getParameterValues("item_name");
				String[] arr_price = request.getParameterValues("price");
				String[] arr_count = request.getParameterValues("count");
				for (int i = 0; i < arr_username.length; i++) {
					int priceInt = Integer.parseInt(arr_price[i]);
					int countInt = Integer.parseInt(arr_count[i]);
					itemUserModel.intoHistory(arr_username[i], arr_item_code[i], arr_item_name[i], priceInt, countInt);
					System.out.println(arr_username[i] + arr_item_code[i] + arr_item_code[i]);
				}

			} catch (Exception e) {
				System.out.println("購入完了エラー");
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			forward_jsp = "/views/purchase_finish.jsp";
		}
		// forwaed_jsp に設定されているJSPへディスパッチ
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);

	}

}