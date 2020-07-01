package model;

import java.sql.ResultSet;

import bean.UserBean;
import util.DBUtil;

public class LoginModel {

	/**
	 * 入力されたデータがDBに上に存在するかどうかを調べる。
	 */
	public boolean loginCheck(String username, String password) {
		// 実行結果を格納する変数
		ResultSet rs = null;

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行
			String SQL = "SELECT * FROM `users` WHERE `username`='" + username + "' AND `password`='" + password + "'";
			rs = DBUtil.execute(SQL);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return rs != null;
	}

	/**
	 * 検索結果をUserBeanにセット
	 */
	public UserBean userSerch(String username) {
		// 実行結果を格納する変数
		ResultSet rs = null;
		UserBean userBean = new UserBean();

		// DBに接続するための手続
		try {
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行
			String SQL = "SELECT * FROM `users` WHERE `username` = '" + username + "'";
			rs = DBUtil.execute(SQL);

			userBean.setUsername(rs.getString("username"));
			userBean.setPassword(rs.getString("password"));
			userBean.setName(rs.getString("name"));
			userBean.setPost(rs.getString("post"));
			userBean.setAddress(rs.getString("address"));

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		DBUtil.closeConnection();
		return userBean;
	}
}
