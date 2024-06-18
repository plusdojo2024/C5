package dao;

import java.util.ArrayList;
import java.util.List;

import model.Books;

//Books,Channelsテーブルアクセス用DAO。

public class BooksDAO {

	//booksテーブルから、指定したChannel_id(int)のデータ(books)を複数取得する。

	public List<Books> getChannelBooks(int channel_id) {
		List<Books> booksList = new ArrayList<Books>();

		//SELECT item_name FROM handbook WHERE channel_id = ?;


		//SELECT item_name FROM handbook WHERE channel_id = 1;
		//SELECT item_name FROM handbook WHERE channel_id = 2;
		//SELECT item_name FROM handbook WHERE channel_id = 3;

		return booksList;
	}

}
