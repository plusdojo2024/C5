package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Childinfo;

public class ChildDAO {

	    private Connection con;

	    public ChildDAO(Connection con) {
	        this.con = con;
	    }

	    // ユーザーIDに紐づく子供のリストを取得するメソッド
	    public List<Childinfo> getChildrenByUserId(int id){
	    	Connection con = null;
	    	List<Childinfo> children = new ArrayList<Childinfo>();

	    	try {
	    		// JDBCドライバを読み込む
	    		Class.forName("org.h2.Driver");

	    		// データベースに接続する
	    		con = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

	    		// SQL文を準備する
	    		String sql = "SELECT child_birthday, child_name FROM users WHERE id = ?";

	    		PreparedStatement ps = con.prepareStatement(sql);


	    		try (ResultSet rs = ps.executeQuery()) {

	    			while (rs.next()) {
	    				Date child_birthday = rs.getDate("child_birthday");
	    				String child_name = rs.getString("child_name");
	    				children.add(new Childinfo(child_birthday, child_name));

	    			}
	    		}

	    	// SQL文を実行する

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (con != null) {
				try {
					con.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

        // 結果を返す
        return children;
        }
    }

