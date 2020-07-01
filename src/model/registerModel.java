package model;

import java.sql.ResultSet;

import util.DBUtil;

public class registerModel {

	/**
	 * 入力されたデータがDBに上に存在するかどうかを調べる。
	 */
	public boolean accountCheck(String username) {

		ResultSet rs = null;

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行
			String SQL = "SELECT * FROM `users` WHERE username = '" + username + "'";
			rs = DBUtil.execute(SQL);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}

		return rs != null;
	}

	/**
	 * 入力されたデータをDBに上に登録。
	 */
	public int register(String username, String password, String name, String post, String address) throws Exception {
		// 実行結果を格納する変数
		int num = 0;

		// DBに接続するための手続
		DBUtil.makeConnection();
		DBUtil.makeStatement();

		// SQLを実行
		String SQL = "INSERT INTO `users` (username,password,name,post,address) VALUES ('" + username + "','" + password
				+ "','" + name + "','" + post + "','" + address + "')";
		num = DBUtil.executeUpdate(SQL);

		DBUtil.closeConnection();

		return num;
	}
}
