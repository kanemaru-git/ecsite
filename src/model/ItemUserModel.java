package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.CartBean;
import bean.HistoryBean;
import bean.ItemBean;
import util.DBUtil;

public class ItemUserModel {

	private int sum;// 商品価格の合計

	public int getSum() {
		return sum;
	}

	/**
	 * 検索結果をItemBeanにセット
	 */
	public ItemBean itemSerchList(String item_code) throws Exception {
		// 実行結果を格納する変数
		ResultSet rs = null;

		// DBに接続するための手続
		DBUtil.makeConnection();
		DBUtil.makeStatement();

		// SQLを実行
		String SQL = "SELECT * FROM `itemes` WHERE `item_code` = '" + item_code + "'";
		rs = DBUtil.execute(SQL);

		ItemBean itemBean = new ItemBean();
		itemBean.setItem_code(rs.getString("item_code"));
		itemBean.setItem_name(rs.getString("item_name"));
		itemBean.setAuthor(rs.getString("author"));
		itemBean.setPublisher(rs.getString("publisher"));
		itemBean.setPrice(String.valueOf(rs.getInt("price")));
		itemBean.setCategory(rs.getString("category"));
		itemBean.setDetails(rs.getString("details"));
		itemBean.setStock(String.valueOf(rs.getInt("stock")));

		DBUtil.closeConnection();
		return itemBean;
	}

	/**
	 * 検索結果をリスト化(LIKE)
	 */
	public List<ItemBean> itemSerchLike(String keyword, String category, String sort) throws Exception {
		
		String keyWord3 = keyword.replaceAll("　", " ").replaceAll(" ", "%' AND `serch_word` LIKE '%");
		if (sort.isBlank()) {
			sort = "price";
		}
		ResultSet rs = null;
		List<ItemBean> itemList = new ArrayList<ItemBean>();

		// DBに接続するための手続
		DBUtil.makeConnection();
		DBUtil.makeStatement();

		String SQL = "SELECT * FROM `itemes` WHERE `serch_word` LIKE '%" + keyWord3 + "%' AND `category` LIKE '%"
				+ category + "%' AND `stock` NOT IN (0) ORDER BY " + sort + "";
		System.out.println(SQL);
		
		rs = DBUtil.execute(SQL);

		rs.beforeFirst();
		while (rs.next()) {
			ItemBean itemBean = new ItemBean();
			itemBean.setItem_code(rs.getString("item_code"));
			itemBean.setItem_name(rs.getString("item_name"));
			itemBean.setPrice(String.valueOf(rs.getInt("price")));
			itemBean.setCategory(rs.getString("category"));
			itemBean.setStock(String.valueOf(rs.getInt("stock")));
			itemList.add(itemBean);
			System.out.println(itemList);
		}

		DBUtil.closeConnection();
		return itemList;
	}

	/**
	 * 商品すべてをリスト化
	 */
	public List<ItemBean> itemAll() throws Exception {
		// 実行結果を格納する変数
		ResultSet rs = null;
		List<ItemBean> itemList = new ArrayList<ItemBean>();

		DBUtil.makeConnection();
		DBUtil.makeStatement();

		// SQLを実行
		String SQL = "SELECT * FROM `itemes`";
		rs = DBUtil.execute(SQL);

		rs.beforeFirst();
		while (rs.next()) {
			ItemBean itemBean = new ItemBean();
			itemBean.setItem_code(rs.getString("item_code"));
			itemBean.setItem_name(rs.getString("item_name"));
			itemBean.setPrice(String.valueOf(rs.getInt("price")));
			itemBean.setCategory(rs.getString("category"));
			itemBean.setDetails(rs.getString("details"));
			itemBean.setStock(rs.getString("stock"));
			itemList.add(itemBean);
			System.out.println(itemList);
		}

		DBUtil.closeConnection();
		return itemList;
	}

	/**
	 * カートに商品入れる
	 */
	public void intoCart(String username, String item_code, String item_name, int price, int count) throws Exception {
		DBUtil.makeConnection();
		DBUtil.makeStatement();

		String SQL = "INSERT INTO `carts` VALUES ('" + username + "','" + item_code + "','" + item_name + "'," + price
				+ "," + count + ")";
		DBUtil.executeUpdate(SQL);
		DBUtil.closeConnection();
	}

	/**
	 * カートから商品削除
	 */
	public void deleteItemCart(String username, String item_code) throws Exception {
		DBUtil.makeConnection();
		DBUtil.makeStatement();

		String SQL = "DELETE FROM `carts` WHERE `username` = '" + username + "' AND `item_code` = '" + item_code + "'";
		DBUtil.executeUpdate(SQL);
		DBUtil.closeConnection();
	}

	/**
	 * カートからユーザーのすべての商品削除
	 */
	public void deleteUserCart(String username) throws Exception {
		DBUtil.makeConnection();
		DBUtil.makeStatement();

		String SQL = "DELETE FROM `carts` WHERE `username` = '" + username + "'";
		DBUtil.executeUpdate(SQL);
		DBUtil.closeConnection();
	}

	/**
	 * カートを表示
	 */
	public List<CartBean> cartSerch(String username) throws Exception {
		ResultSet rs = null;
		List<CartBean> cartList = new ArrayList<CartBean>();

		// DBに接続するための手続
		DBUtil.makeConnection();
		DBUtil.makeStatement();

		String SQL = "SELECT * FROM `carts` WHERE `username` = '" + username + "'";
		rs = DBUtil.execute(SQL);

		rs.beforeFirst();
		while (rs.next()) {
			CartBean cartBean = new CartBean();
			cartBean.setUsername(rs.getString("username"));
			cartBean.setItem_code(rs.getString("item_code"));
			cartBean.setItem_name(rs.getString("item_name"));
			cartBean.setPrice(String.valueOf(rs.getInt("price")));
			cartBean.setCount(rs.getString("count"));
			cartList.add(cartBean);
			sum += rs.getInt("price") * rs.getInt("count");
			System.out.println(sum);
		}

		DBUtil.closeConnection();
		return cartList;
	}

	/**
	 * 購入した商品を購入履歴に反映
	 */
	public void intoHistory(String username, String item_code, String item_name, int price, int count)
			throws Exception {
		DBUtil.makeConnection();
		DBUtil.makeStatement();

		String SQL = "INSERT INTO `histories` VALUES ('" + username + "','" + item_code + "','" + item_name + "',"
				+ price + "," + count + ",NOW())";
		DBUtil.executeUpdate(SQL);
		DBUtil.closeConnection();
	}

	/**
	 * 購入履歴を表示
	 */
	public List<HistoryBean> historySerch(String username) throws Exception {
		ResultSet rs = null;
		List<HistoryBean> historyList = new ArrayList<HistoryBean>();

		// DBに接続するための手続
		DBUtil.makeConnection();
		DBUtil.makeStatement();

		String SQL = "SELECT * FROM `histories` WHERE `username` = '" + username + "'";
		rs = DBUtil.execute(SQL);

		rs.beforeFirst();
		// テーブル2行目から最後までuserListに格納
		while (rs.next()) {
			HistoryBean historyBean = new HistoryBean();
			historyBean.setUsername(rs.getString("username"));
			historyBean.setItem_code(rs.getString("item_code"));
			historyBean.setItem_name(rs.getString("item_name"));
			historyBean.setPrice(String.valueOf(rs.getInt("price")));
			historyBean.setCount(rs.getString("count"));
			historyBean.setDate(rs.getString("date"));
			historyList.add(historyBean);
		}

		DBUtil.closeConnection();
		return historyList;
	}

}
