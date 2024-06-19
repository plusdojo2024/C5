package test;

import java.util.List;

import dao.BooksDAO;
import model.Books;

public class BooksDAOTest {

    public static void main(String[] args) {
        BooksDAO booksDAO = new BooksDAO();

        // 仮のチャンネルIDとして1を使用
        int channelId = 1;

        // BooksDAOからchannelIdに対応する本のリストを取得
        List<Books> booksList = booksDAO.getChannelBooks(channelId);

        // 取得した本のリストを拡張for文で表示
        System.out.println("Channel ID は " + channelId + ".衣のページ");
        for (Books book : booksList) {
            System.out.println(book.getItem_name()); // Booksクラスに適切なgetItemName()メソッドを仮定
        }
    }
}