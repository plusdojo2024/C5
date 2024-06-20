package test;
import java.util.List;

import dao.ChildDAO;
//import model.Users;
import model.Childinfo;

public class ChildDAOTest {
	public static void main(String[] args) {
		ChildDAO dao = new ChildDAO();

		// selectメソッドのテスト
		System.out.println("<< selectメソッドのテスト（すべてのレコードを検索します）>>");

		//Childinfoには、子供の名前と誕生日しか、もたない。
		Childinfo info = new Childinfo();
		int id = 0;

		List<Childinfo> children;


		//子供の情報は検索するときは、IDがいい。
		children  =  dao.select(  id  );


		for (Childinfo child : children) {
			System.out.println("誕生日：" + child.getChild_birthday());
			System.out.println("子どもの名前：" + child.getChild_name());

		}

	}
}
