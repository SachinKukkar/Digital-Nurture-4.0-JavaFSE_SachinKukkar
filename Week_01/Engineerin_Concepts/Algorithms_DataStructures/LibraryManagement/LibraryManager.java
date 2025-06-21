package Week_01.Engineerin_Concepts.LibraryManagement;


import java.util.Arrays;

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

public class LibraryManager {

    // Linear search
    public static int linearSearch(Book[] books, String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    // Binary search (assumes books are sorted by title)
    public static int binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0)
                return mid;
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Data Structures", "Mark Weiss"),
            new Book(2, "Operating Systems", "Silberschatz"),
            new Book(3, "Clean Code", "Robert Martin"),
            new Book(4, "Java Programming", "Herbert Schildt")
        };

        System.out.println("Linear Search: Searching for 'Clean Code'");
        int linIndex = linearSearch(books, "Clean Code");
        System.out.println(linIndex != -1 ? books[linIndex] : "Book not found");

        // Sort by title for binary search
        Arrays.sort(books, (a, b) -> a.title.compareToIgnoreCase(b.title));

        System.out.println("\nBinary Search: Searching for 'Clean Code'");
        int binIndex = binarySearch(books, "Clean Code");
        System.out.println(binIndex != -1 ? books[binIndex] : "Book not found");
    }
}

