package Library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Database {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<String> usernames = new ArrayList<String>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<String> bookNames = new ArrayList<String>();

    private File usersfile = new File(("src/data/Users.txt"));
    private File booksfile = new File(("src/data/Books.txt"));

    
    


public Database() {
    try {
        if (!usersfile.exists()) {
            
            usersfile.createNewFile();           
        }
        if (!booksfile.exists()) {
            
            booksfile.createNewFile();
        }
        getUsers();
    } catch (IOException e) {
        e.printStackTrace(); 
    }
}


    public void AddUser(User u){
        users.add(u);
        usernames.add(u.getName());
        saveUsers();
    }

    public int Login(String phoneNumber, String email){
        int n = -1;
        for(User s: users){
            //preventing null pointer exception
            if (phoneNumber == null || email == null) {
                return -1;
            }

            if(s.getPhoneNumber().equals(phoneNumber) && s.getEmail().equals(email)){
                n = users.indexOf(s);
                break;
            }
        }
        return n;
    }

    public User getUser(int n){
        return users.get(n);
    }

    public void AddBook(Book book){
        books.add(book);
        bookNames.add(book.getName());
        
    }

    private void getUsers(){
        String text1 = "";
        try{
            BufferedReader br1 = new BufferedReader(new FileReader(usersfile));
            String s1;
            while((s1=br1.readLine())!=null){
                text1=text1+s1;
            }
            br1.close();

        } catch  (Exception  e){
            System.err.println(e.toString());
        }

        if(!text1.matches("")||!text1.isEmpty()){
            String[] a1 = text1.split("<NewUser/>");
            for(String s : a1){
                String[] a2 =s.split("<N/>");
                if(a2[3].matches("Admin")){
                    User user = new Admin(a2[0],a2[1],a2[2]);
                    users.add(user);
                    usernames.add(user.getName());
                } else{
                    User user = new NormalUser(a2[0],a2[1],a2[2]);
                    users.add(user); 
                    usernames.add(user.getName());
                }
            }
        }
    }

    // private void getUsers() {
    //     String text1 = "";
    //     try {
    //         Scanner scanner = new Scanner(usersfile);
    //         while (scanner.hasNextLine()) {
    //             String line = scanner.nextLine();
    //             text1 += line + "\n"; 
    //         }
    //         scanner.close();
    //     } catch (Exception e) {
    //         System.err.println(e.toString());
    //     }
    // }

    private void saveUsers(){
        String text1 =  "";
        for(User  user : users){
            text1= text1+user.toString()+"<NewUser/>\n";
        }
        try {
            PrintWriter pw  = new PrintWriter(usersfile);
            pw.print(text1);
            pw.close();
            
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
