package Library;

import java.util.Scanner;

public class DeleteBook implements IOOperation{

    @Override
    public void oper(Database database, User user){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter book name: ");
        String bookNAme = sc.next();

        int i = database.getBook(bookNAme);
        if(i>-1){
            database.deleteBook(i);
            System.out.println("Book DELETED !!!!");
        }else{
            System.out.println("Book Doesnt exist");
        }
        user.menu(database,user);

    }
}
