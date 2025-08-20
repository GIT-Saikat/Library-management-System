package Library;

import java.util.Scanner;

public class AddBook implements IOOperation{

    @Override
    public void oper(Database database, User user){
        Scanner sc = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Enter book name: ");
        String name = sc.next();
        if(database.getBook(name)>-1){
            System.out.println("There is a book with this name");
            return;
        }else{
            book.setName(sc.next());
            
            System.out.println("Enter book author: ");
            book.setAuthor(sc.next());
            System.out.println("Enter book publisher: ");
            book.setPublisher(sc.next());
            System.out.println("Enter book collection address: ");
            book.setAddress(sc.next());
            System.out.println("Enter qty: ");
            book.setQty(sc.nextInt());
            System.out.println("Enter price: ");
            book.setPrice(sc.nextDouble());
            System.out.println("Enter borrowing copies: ");
            book.setBrwCopies(sc.nextInt());
            database.AddBook(book);
            System.out.println("Book added Successfully!!!\n");
            }
        
        
            user.menu(database, user);
            sc.close();
    }
}
