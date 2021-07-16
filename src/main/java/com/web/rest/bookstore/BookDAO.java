package com.web.rest.bookstore;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    
    //書籍資料庫
    public static List<Book>  books= new ArrayList();
    
    //多筆查詢
    public static List<Book> getBooks(){
        return  books;
    }
    
    // 單筆查詢
    public static Book getBook(Integer id){
        return   books.stream().filter(b -> b.getId() == id).findFirst().get();
    }
    
    // 新增
    public static Boolean createBook(Book book){
        books.add(book);
        return true;
    }
    
    // 修改
    public static Boolean updateBook(Integer id,Book book){
        Book oBook = getBook(id);
        if(oBook == null){
            return false;
        }
        oBook.setName(book.getName());
        oBook.setPrice(book.getPrice());
        return  true;
    }
    
    // 刪除
    public static Boolean deleteBook(Integer id){
        // 是否書庫中存有此筆資料?
        Book oBook = getBook(id);
        if(oBook == null){
            return  false;
        }
        books.remove(oBook);
        return  true;
        
        
    }
    
}
