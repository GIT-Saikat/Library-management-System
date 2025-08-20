package Library;

public class Book {

    private String  name;
    private String  author;
    private String  publisher;
    private String  address; //collection location
    private String  status; //Borrowing Status
    private int qty;
    private double price;
    private int brwCopies; //Borrowing Copies

    public Book(){};

    public Book(String name, String author, String publisher, String address, String status, int qty, double  price, int brwCopies){

        this.name = name;
        this.author=author;
        this.publisher=publisher;
        this.address=address;
        this.status=status;
        this.qty=qty;
        this.price=price;
        this.brwCopies=brwCopies;
    }

    public String toString(){
        String text= "Book Name: "+ name +"Book Author: "+ author + "Book Publisher: "+ publisher +"Book Collection Address: "+  address +"Borrowing  Status:"+ status +"Qty: "+  String.valueOf(qty)  +"Price: "+ String.valueOf(price)+ "Borrwoing Copies: "+ String.valueOf(brwCopies);

        return text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBrwCopies() {
        return brwCopies;
    }

    public void setBrwCopies(int brwCopies) {
        this.brwCopies = brwCopies;
    };

    



}
