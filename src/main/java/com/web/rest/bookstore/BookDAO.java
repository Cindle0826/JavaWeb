package com.web.rest.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    //書籍資料庫
    public static List<Book> books = new ArrayList();
    // 資料庫連線物件
    private static Connection conn;

    static {
        try {
            // 建立驅動物件
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 建立 conn物件
            String url = "jdbc:derby://localhost:1527/javaweb";
            String user = "app";
            String password = "app";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
        }
    }

    //多筆查詢
    public static List<Book> getBooks() {
        books.clear();
        String sql = "SELECT id,name,price,amount,ts FROM Book ";
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            // 所抓到的每一筆紀錄,要注入到 book 物件中存放
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getInt("price"));
                book.setAmount(rs.getInt("amount"));
                books.add(book);
            }
        } catch (Exception e) {
        }

        return books;
    }
    // 單筆查詢

    public static Book getBook(Integer id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().get();
    }

    // 新增
    public static Boolean createBook(Book book) {
        boolean flag = books.stream().filter(b -> b.getId() == book.getId()).findAny().isPresent();
        if (flag == false) {
            books.add(book);
            return true;
        }
        return false;
    }

    // 修改
    public static Boolean updateBook(Integer id, Book book) {
        Book oBook = getBook(id);
        if (oBook == null) {
            return false;
        }
        oBook.setName(book.getName());
        oBook.setPrice(book.getPrice());
        return true;
    }

    // 刪除
    public static Boolean deleteBook(Integer id) {
        // 是否書庫中存有此筆資料?
        Book oBook = getBook(id);
        if (oBook == null) {
            return false;
        }
        books.remove(oBook);
        return true;

    }

}
