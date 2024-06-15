package dao;

public class BooksDAO {

}

//Books,Channelsテーブルアクセス用DAO。
//Javaでのデータベースアクセスを行う際の一般的な書き方
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
private static final String URL ="jdbc:mysql://localhost:3306/database_name";
private static final String USERNAME= "username";
private static final String PASSWORD= "password";

public List<Book> getBooks() {
List<Book> books = newArrayList<> 0;

	try {
		Connection connection =
		DriverManager.getConnection (URL,
		USERNAME, PASSWORD);
			String query = "SELECT * FROM books";

		PreparedStatement
		preparedStatement =
		connection.prepareStatement(query);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next)) {
			int id = resultSet.getlnt("id");
			String title =
					resultSet.getString ("title");
			String author = resultSet.getString ("author");
			Book book = new Book(id, title, author);
			books.add (book);
		}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

			return books;

		public class Book {
			private int id;
			private String title;
			private String author;

			public Book(int id, String title, String author) {
				this.id = id;
				this.title = title;
				this.author = author;

// Getters and setters
