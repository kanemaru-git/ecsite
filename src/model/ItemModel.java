package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.ItemBean;
import util.DBUtil;

public class ItemModel {


	/**
     * 商品コードがDBに上に存在するかどうかを調べる。
     */
    public boolean itemSerch(String item_code) throws Exception {
        // 実行結果を格納する変数
        ResultSet rs = null;

            // DBに接続するための手続
            DBUtil.makeConnection();
            DBUtil.makeStatement();

            // SQLを実行
            String SQL = "SELECT * FROM `itemes` WHERE `item_code` = '"+item_code+"'";
            rs = DBUtil.execute(SQL);

            //SQLを閉じる
            DBUtil.closeConnection();
            return rs != null;
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
            String SQL = "SELECT * FROM `itemes` WHERE `item_code` = '"+item_code+"'";
            rs = DBUtil.execute(SQL);

          ItemBean itemBean = new ItemBean();
          itemBean.setItem_code(rs.getString("item_code"));
      	  itemBean.setItem_name(rs.getString("item_name"));
      	  itemBean.setPhonetic(rs.getString("phonetic"));
      	  itemBean.setAuthor(rs.getString("author"));
      	  itemBean.setPublisher(rs.getString("publisher"));
      	  itemBean.setPrice(String.valueOf(rs.getInt("price")));
      	  itemBean.setCategory(rs.getString("category"));
      	  itemBean.setStock(String.valueOf(rs.getInt("stock")));
      	  itemBean.setDetails(rs.getString("details"));
      	  itemBean.setSerch_word(rs.getString("serch_word"));

          DBUtil.closeConnection();
          return itemBean;
    }

    /**
     * 検索結果をリスト化(LIKE)
     */
    public List<ItemBean> itemSerchLike(String item_code) throws Exception {
        // 実行結果を格納する変数
        ResultSet rs = null;
        List<ItemBean> itemList = new ArrayList<ItemBean>();

            // DBに接続するための手続
            DBUtil.makeConnection();
            DBUtil.makeStatement();

            // SQLを実行
            String SQL = "SELECT * FROM `itemes` WHERE `item_code` LIKE BINARY '%"+item_code+"%'";
            rs = DBUtil.execute(SQL);

              rs.beforeFirst();
              while(rs.next()) {
            	  ItemBean itemBean = new ItemBean();
            	  itemBean.setItem_code(rs.getString("item_code"));
              	  itemBean.setItem_name(rs.getString("item_name"));
              	  itemBean.setPhonetic(rs.getString("phonetic"));
              	  itemBean.setAuthor(rs.getString("author"));
              	  itemBean.setPublisher(rs.getString("publisher"));
              	  itemBean.setPrice(String.valueOf(rs.getInt("price")));
              	  itemBean.setCategory(rs.getString("category"));
              	  itemBean.setStock(String.valueOf(rs.getInt("stock")));
              	  itemBean.setDetails(rs.getString("details"));
              	  itemBean.setSerch_word(rs.getString("serch_word"));
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
        
        ResultSet rs = null;
        List<ItemBean> itemList = new ArrayList<ItemBean>();

        DBUtil.makeConnection();
        DBUtil.makeStatement();

        String SQL = "SELECT * FROM `itemes`";
        rs = DBUtil.execute(SQL);

        rs.beforeFirst();
              while(rs.next()) {
            	  ItemBean itemBean = new ItemBean();
            	  itemBean.setItem_code(rs.getString("item_code"));
            	  itemBean.setItem_name(rs.getString("item_name"));
            	  itemBean.setPhonetic(rs.getString("phonetic"));
            	  itemBean.setAuthor(rs.getString("author"));
            	  itemBean.setPublisher(rs.getString("publisher"));
            	  itemBean.setPrice(String.valueOf(rs.getInt("price")));
            	  itemBean.setCategory(rs.getString("category"));
            	  itemBean.setStock(String.valueOf(rs.getInt("stock")));
            	  itemBean.setDetails(rs.getString("details"));
            	  itemBean.setSerch_word(rs.getString("serch_word"));
            	  itemList.add(itemBean);
            	  System.out.println(itemList);
             }

            DBUtil.closeConnection();
            return itemList;
    }

    /**
     * 削除実行
     */
    public void deleteMove(String item_code) throws Exception {

    	DBUtil.makeConnection();
    	DBUtil.makeStatement();

    	String SQL = "DELETE FROM `itemes` WHERE item_code = '"+item_code+"'";
    	DBUtil.executeUpdate(SQL);
    }

    /**
     * 変更実行
     */
    public void updateMove(String item_code,String item_name,String phonetic,String author,String publisher,int price,String category,int stock,String details,String serch_word) throws Exception {

    	DBUtil.makeConnection();
    	DBUtil.makeStatement();

    	String SQL = "UPDATE `itemes` SET item_name = '"+item_name+"', phonetic = '"+phonetic+"', author = '"+author+"', publisher = '"+publisher+"',price = "+price+",category = '"+category+"',stock = "+stock+",details = '"+details+"',serch_word = '"+serch_word+"' WHERE item_code = '"+item_code+"'";
    	DBUtil.executeUpdate(SQL);
    }

    /**
     * 登録実行
     */
    public void registerMove(String item_code,String item_name,String phonetic,String author,String publisher,int price,String category,int stock,String details,String serch_word) throws Exception {

    	DBUtil.makeConnection();
    	DBUtil.makeStatement();

    	String SQL = "INSERT INTO `itemes` VALUES('"+item_code+"','"+item_name+"','"+phonetic+"','"+author+"','"+publisher+"',"+price+",'"+category+"',"+stock+",'"+details+"','"+serch_word+"')";
    	DBUtil.executeUpdate(SQL);
    	DBUtil.closeConnection();
    }

}
