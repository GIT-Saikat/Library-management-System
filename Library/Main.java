package Library;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Database database;
    //static Scanner sc;

    public static void main(String[] args) {

        database = new Database();
        System.out.println("Welcome to Library Management System!");

        int num;
        
        do{
            System.out.println("0. Exit\n1. Login\n2. New User");

            num= sc.nextInt();

            switch(num){
                case 0: break;
                case 1: login();
                        break;
                case 2: newUser();
                        break;
                default: System.out.println("Error!");
            }
        }while(num!=0);
        
        

    }

    private static void login(){
        System.out.println("Enter Phone Number:");
        String phoneNumber  = sc.next();
        System.out.println("Enter Email:");
        String email  = sc.next();
        int n = database.Login(phoneNumber, email);
        if(n!=-1){
            User user = database.getUser(n);
            user.menu(database,user);
            System.out.println("Welcome"+user.getName());
        }else {
            System.out.println("User Doesnt exist");
        }   
    }
    
    private static void newUser(){
        System.out.println("\n=== NEW USER ===");
        System.out.println("Enter name:");
        String  name = sc.next();
        System.out.println("Enter Phone Number:");
        String phoneNumber  = sc.next();
        System.out.println("Enter Email:");
        String email  = sc.next();
        System.out.println("1.Admin\n2. Normal User");
        int n2 =sc.nextInt();
        User user;
        if(n2 == 1){
            user = new Admin(name,email,phoneNumber);
    
        } else {
            user = new NormalUser(name,email,phoneNumber);

        }
        database.AddUser(user);
        user.menu(database,user);
    }
}
