package training.hibernate;

import training.hibernate.entity.Author;
import training.hibernate.entity.Book;

import java.util.List;

public class App {

    public static void main(String[] args)  {

        Author author = new Author("Tolstoy");
        new AuthorHelper().saveAuthor(author);

        BookHelper bookHelper = new BookHelper();

        Book book = new Book();
        book.setAuthor(author);
        book.setName("Voina i mir");
        bookHelper.saveBook(book);

        Book book1 = new Book();
        book1.setAuthor(author);
        book1.setName("Otrochestvo");
        bookHelper.saveBook(book1);

        List<Book> bookList = bookHelper.getBookList();
        for (Book eachBook: bookList){
            System.out.println(eachBook.getName() + " - " + eachBook.getAuthor().getName());
        }
    }
}
