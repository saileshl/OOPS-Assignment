import java.util.Scanner;

class Book {
    private String title;
    private String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String newAuthor) {
        System.out.println("Updating author from " + this.author + " to " + newAuthor);
        this.author = newAuthor;
    }

    public void display() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

public class Hello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book book1 = new Book("Java Programming", "James Gosling");

        System.out.println("Before Update:");
        book1.display();

        System.out.print("\nEnter new author name: ");
        String newAuthor = sc.nextLine();

        book1.setAuthor(newAuthor);

        System.out.println("\nAfter Update:");
        book1.display();

        sc.close();
    }
}
