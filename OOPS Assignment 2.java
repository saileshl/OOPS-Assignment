import java.util.Scanner;

public class LibraryRecords {
    // Maximum number of books that can be stored
    private static final int MAX_BOOKS = 100;
    
    // Arrays to store book information
    private static String[] bookTitles = new String[MAX_BOOKS];
    private static String[] bookAuthors = new String[MAX_BOOKS];
    private static String[] bookISBN = new String[MAX_BOOKS];
    private static String[] bookPublishers = new String[MAX_BOOKS];
    private static int[] publicationYears = new int[MAX_BOOKS];
    private static double[] bookPrices = new double[MAX_BOOKS];
    private static String[] bookCategories = new String[MAX_BOOKS];
    private static boolean[] bookAvailability = new boolean[MAX_BOOKS];
    private static String[] bookLocations = new String[MAX_BOOKS];
    private static int[] bookCopies = new int[MAX_BOOKS];
    
    // Counter to keep track of number of books
    private static int bookCount = 0;
    
    // Scanner object for user input
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Main method - Entry point of the program
     */
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("    WELCOME TO LIBRARY MANAGEMENT SYSTEM");
        System.out.println("=================================================");
        
        // Initialize with some sample data
        initializeSampleData();
        
        // Main program loop
        boolean continueProgram = true;
        while (continueProgram) {
            continueProgram = displayMenuAndHandleChoice();
        }
        
        System.out.println("\nThank you for using Library Management System!");
        scanner.close();
    }
    
    /**
     * Initialize the system with some sample book data
     */
    private static void initializeSampleData() {
        // Adding sample books to demonstrate the system
        addBookToSystem("The Great Gatsby", "F. Scott Fitzgerald", "978-0-7432-7356-5", 
                       "Scribner", 1925, 12.99, "Fiction", true, "A-101", 3);
        
        addBookToSystem("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4", 
                       "J.B. Lippincott & Co.", 1960, 14.99, "Fiction", true, "A-102", 2);
        
        addBookToSystem("1984", "George Orwell", "978-0-452-28423-4", 
                       "Secker & Warburg", 1949, 13.99, "Dystopian Fiction", false, "A-103", 1);
        
        addBookToSystem("Pride and Prejudice", "Jane Austen", "978-0-14-143951-8", 
                       "T. Egerton", 1813, 11.99, "Romance", true, "B-201", 4);
        
        addBookToSystem("The Catcher in the Rye", "J.D. Salinger", "978-0-316-76948-0", 
                       "Little, Brown and Company", 1951, 15.99, "Fiction", true, "B-202", 2);
    }
    
    /**
     * Display the main menu and handle user choice
     * @return boolean - true to continue program, false to exit
     */
    private static boolean displayMenuAndHandleChoice() {
        System.out.println("\n=================================================");
        System.out.println("              MAIN MENU OPTIONS");
        System.out.println("=================================================");
        System.out.println("1. Add New Book");
        System.out.println("2. Search Book by Title");
        System.out.println("3. Search Book by Author");
        System.out.println("4. Display All Books");
        System.out.println("5. Update Book Price");
        System.out.println("6. Mark Book as Borrowed");
        System.out.println("7. Mark Book as Returned");
        System.out.println("8. Search by Category");
        System.out.println("9. Display Available Books Only");
        System.out.println("10. Display Book Statistics");
        System.out.println("11. Exit Program");
        System.out.println("=================================================");
        System.out.print("Enter your choice (1-11): ");
        
        int choice = getIntegerInput();
        
        switch (choice) {
            case 1:
                addNewBook();
                break;
            case 2:
                searchBookByTitle();
                break;
            case 3:
                searchBookByAuthor();
                break;
            case 4:
                displayAllBooks();
                break;
            case 5:
                updateBookPrice();
                break;
            case 6:
                markBookAsBorrowed();
                break;
            case 7:
                markBookAsReturned();
                break;
            case 8:
                searchByCategory();
                break;
            case 9:
                displayAvailableBooks();
                break;
            case 10:
                displayBookStatistics();
                break;
            case 11:
                return false;
            default:
                System.out.println("Invalid choice! Please enter a number between 1-11.");
        }
        
        return true;
    }
    
    /**
     * Add a new book to the library system
     */
    private static void addNewBook() {
        System.out.println("\n=== ADD NEW BOOK ===");
        
        if (bookCount >= MAX_BOOKS) {
            System.out.println("Sorry! Library database is full. Cannot add more books.");
            return;
        }
        
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        
        System.out.print("Enter Publisher: ");
        String publisher = scanner.nextLine();
        
        System.out.print("Enter Publication Year: ");
        int year = getIntegerInput();
        
        System.out.print("Enter Book Price: $");
        double price = getDoubleInput();
        
        System.out.print("Enter Book Category: ");
        String category = scanner.nextLine();
        
        System.out.print("Enter Shelf Location: ");
        String location = scanner.nextLine();
        
        System.out.print("Enter Number of Copies: ");
        int copies = getIntegerInput();
        
        // Add book to system
        addBookToSystem(title, author, isbn, publisher, year, price, category, true, location, copies);
        
        System.out.println("Book added successfully!");
    }
    
    /**
     * Internal method to add book to arrays
     */
    private static void addBookToSystem(String title, String author, String isbn, String publisher,
                                       int year, double price, String category, boolean available,
                                       String location, int copies) {
        bookTitles[bookCount] = title;
        bookAuthors[bookCount] = author;
        bookISBN[bookCount] = isbn;
        bookPublishers[bookCount] = publisher;
        publicationYears[bookCount] = year;
        bookPrices[bookCount] = price;
        bookCategories[bookCount] = category;
        bookAvailability[bookCount] = available;
        bookLocations[bookCount] = location;
        bookCopies[bookCount] = copies;
        bookCount++;
    }
    
    /**
     * Search for books by title
     */
    private static void searchBookByTitle() {
        System.out.println("\n=== SEARCH BY TITLE ===");
        System.out.print("Enter book title to search: ");
        String searchTitle = scanner.nextLine().toLowerCase();
        
        boolean found = false;
        System.out.println("\nSearch Results:");
        System.out.println("=================================================");
        
        for (int i = 0; i < bookCount; i++) {
            if (bookTitles[i].toLowerCase().contains(searchTitle)) {
                displaySingleBook(i);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No books found with title containing: " + searchTitle);
        }
    }
    
    /**
     * Search for books by author
     */
    private static void searchBookByAuthor() {
        System.out.println("\n=== SEARCH BY AUTHOR ===");
        System.out.print("Enter author name to search: ");
        String searchAuthor = scanner.nextLine().toLowerCase();
        
        boolean found = false;
        System.out.println("\nSearch Results:");
        System.out.println("=================================================");
        
        for (int i = 0; i < bookCount; i++) {
            if (bookAuthors[i].toLowerCase().contains(searchAuthor)) {
                displaySingleBook(i);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No books found by author: " + searchAuthor);
        }
    }
    
    /**
     * Search for books by category
     */
    private static void searchByCategory() {
        System.out.println("\n=== SEARCH BY CATEGORY ===");
        System.out.print("Enter category to search: ");
        String searchCategory = scanner.nextLine().toLowerCase();
        
        boolean found = false;
        System.out.println("\nBooks in category: " + searchCategory);
        System.out.println("=================================================");
        
        for (int i = 0; i < bookCount; i++) {
            if (bookCategories[i].toLowerCase().contains(searchCategory)) {
                displaySingleBook(i);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No books found in category: " + searchCategory);
        }
    }
    
    /**
     * Display all books in the library
     */
    private static void displayAllBooks() {
        System.out.println("\n=== ALL LIBRARY BOOKS ===");
        
        if (bookCount == 0) {
            System.out.println("No books found in the library.");
            return;
        }
        
        System.out.println("Total Books: " + bookCount);
        System.out.println("=================================================");
        
        for (int i = 0; i < bookCount; i++) {
            System.out.println("Book #" + (i + 1));
            displaySingleBook(i);
        }
    }
    
    /**
     * Display only available books
     */
    private static void displayAvailableBooks() {
        System.out.println("\n=== AVAILABLE BOOKS ===");
        
        boolean hasAvailable = false;
        System.out.println("=================================================");
        
        for (int i = 0; i < bookCount; i++) {
            if (bookAvailability[i]) {
                displaySingleBook(i);
                hasAvailable = true;
            }
        }
        
        if (!hasAvailable) {
            System.out.println("No books are currently available.");
        }
    }
    
    /**
     * Display details of a single book
     */
    private static void displaySingleBook(int index) {
        System.out.println("Title: " + bookTitles[index]);
        System.out.println("Author: " + bookAuthors[index]);
        System.out.println("ISBN: " + bookISBN[index]);
        System.out.println("Publisher: " + bookPublishers[index]);
        System.out.println("Publication Year: " + publicationYears[index]);
        System.out.printf("Price: $%.2f%n", bookPrices[index]);
        System.out.println("Category: " + bookCategories[index]);
        System.out.println("Location: " + bookLocations[index]);
        System.out.println("Copies Available: " + bookCopies[index]);
        System.out.println("Status: " + (bookAvailability[index] ? "Available" : "Not Available"));
        System.out.println("-------------------------------------------------");
    }
    
    /**
     * Update the price of a book
     */
    private static void updateBookPrice() {
        System.out.println("\n=== UPDATE BOOK PRICE ===");
        System.out.print("Enter book title to update price: ");
        String title = scanner.nextLine().toLowerCase();
        
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (bookTitles[i].toLowerCase().equals(title)) {
                System.out.println("Current price: $" + bookPrices[i]);
                System.out.print("Enter new price: $");
                double newPrice = getDoubleInput();
                
                bookPrices[i] = newPrice;
                System.out.println("Price updated successfully!");
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Book not found!");
        }
    }
    
    /**
     * Mark a book as borrowed (not available)
     */
    private static void markBookAsBorrowed() {
        System.out.println("\n=== BORROW BOOK ===");
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine().toLowerCase();
        
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (bookTitles[i].toLowerCase().equals(title)) {
                if (bookAvailability[i] && bookCopies[i] > 0) {
                    bookCopies[i]--;
                    if (bookCopies[i] == 0) {
                        bookAvailability[i] = false;
                    }
                    System.out.println("Book borrowed successfully!");
                    System.out.println("Remaining copies: " + bookCopies[i]);
                } else {
                    System.out.println("Book is not available for borrowing.");
                }
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Book not found!");
        }
    }
    
    /**
     * Mark a book as returned (available)
     */
    private static void markBookAsReturned() {
        System.out.println("\n=== RETURN BOOK ===");
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine().toLowerCase();
        
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (bookTitles[i].toLowerCase().equals(title)) {
                bookCopies[i]++;
                bookAvailability[i] = true;
                System.out.println("Book returned successfully!");
                System.out.println("Available copies: " + bookCopies[i]);
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Book not found!");
        }
    }
    
    /**
     * Display library statistics
     */
    private static void displayBookStatistics() {
        System.out.println("\n=== LIBRARY STATISTICS ===");
        System.out.println("=================================================");
        
        int availableBooks = 0;
        int totalCopies = 0;
        double totalValue = 0;
        
        for (int i = 0; i < bookCount; i++) {
            if (bookAvailability[i]) {
                availableBooks++;
            }
            totalCopies += bookCopies[i];
            totalValue += (bookPrices[i] * bookCopies[i]);
        }
        
        System.out.println("Total Unique Books: " + bookCount);
        System.out.println("Total Book Copies: " + totalCopies);
        System.out.println("Available Books: " + availableBooks);
        System.out.println("Borrowed Books: " + (bookCount - availableBooks));
        System.out.printf("Total Library Value: $%.2f%n", totalValue);
        
        // Display category breakdown
        System.out.println("\nBooks by Category:");
        displayCategoryStatistics();
    }
    
    /**
     * Display category-wise book statistics
     */
    private static void displayCategoryStatistics() {
        String[] categories = new String[bookCount];
        int[] categoryCount = new int[bookCount];
        int uniqueCategories = 0;
        
        // Count books in each category
        for (int i = 0; i < bookCount; i++) {
            String currentCategory = bookCategories[i];
            boolean categoryExists = false;
            
            // Check if category already exists
            for (int j = 0; j < uniqueCategories; j++) {
                if (categories[j].equals(currentCategory)) {
                    categoryCount[j]++;
                    categoryExists = true;
                    break;
                }
            }
            
            // If category doesn't exist, add it
            if (!categoryExists) {
                categories[uniqueCategories] = currentCategory;
                categoryCount[uniqueCategories] = 1;
                uniqueCategories++;
            }
        }
        
        // Display category statistics
        for (int i = 0; i < uniqueCategories; i++) {
            System.out.println("- " + categories[i] + ": " + categoryCount[i] + " books");
        }
    }
    
    /**
     * Helper method to get integer input with error handling
     */
    private static int getIntegerInput() {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a valid number: ");
            }
        }
    }
    
    /**
     * Helper method to get double input with error handling
     */
    private static double getDoubleInput() {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a valid number: ");
            }
        }
    }
}
