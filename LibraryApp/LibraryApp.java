// Name: BADAL PRASAD           
// Course: B.Tech CSE(Full Stack Development)
// Roll Number: 2501351020

import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean isAvailable;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // default book is available
    }

    public void display() {
        System.out.println("Title: " + title + ", Author: " + author + 
                           ", Available: " + (isAvailable ? "Yes" : "No"));
    }
}

class Library {
    Book[] books = new Book[100];
    int count = 0;

    // Add a new book
    public void addBook(Book b) {
        if (count < books.length) {
            books[count++] = b;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Search book by title  (Method Overloading)
    public Book searchBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Search books by author  (Method Overloading)
    public void searchBookByAuthor(String author) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (books[i].author.equalsIgnoreCase(author)) {
                books[i].display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found by this author.");
        }
    }

    // Borrow a book
    public void borrowBook(String title) {
        Book b = searchBook(title);

        if (b == null) {
            System.out.println("Book not found.");
        } else if (!b.isAvailable) {
            System.out.println("Book is already borrowed.");
        } else {
            b.isAvailable = false;
            System.out.println("Book borrowed successfully.");
        }
    }

    // Return a book
    public void returnBook(String title) {
        Book b = searchBook(title);

        if (b == null) {
            System.out.println("Book not found.");
        } else if (b.isAvailable) {
            System.out.println("Book was not borrowed.");
        } else {
            b.isAvailable = true;
            System.out.println("Book returned successfully.");
        }
    }

    // Display all books
    public void displayAllBooks() {
        if (count == 0) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("\nAll books in the library:");
        for (int i = 0; i < count; i++) {
            books[i].display();
        }
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add a new book");
            System.out.println("2. Search for a book by title");
            System.out.println("3. Search for books by author");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Display all books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter book author: ");
                    String author = sc.nextLine();

                    library.addBook(new Book(title, author));
                    break;

                case 2:
                    System.out.print("Enter title to search: ");
                    String searchTitle = sc.nextLine();

                    Book result = library.searchBook(searchTitle);

                    if (result != null) {
                        System.out.println("Book found:");
                        result.display();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter author name to search: ");
                    String searchAuthor = sc.nextLine();

                    library.searchBookByAuthor(searchAuthor);
                    break;

                case 4:
                    System.out.print("Enter title to borrow: ");
                    String borrowTitle = sc.nextLine();

                    library.borrowBook(borrowTitle);
                    break;

                case 5:
                    System.out.print("Enter title to return: ");
                    String returnTitle = sc.nextLine();

                    library.returnBook(returnTitle);
                    break;

                case 6:
                    library.displayAllBooks();
                    break;

                case 7:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}