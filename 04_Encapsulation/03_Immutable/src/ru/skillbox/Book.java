package ru.skillbox;

public class Book {
    private final String title;
    private final String author;
    private final int numbersOfPages;
    private final int numbersIsbn;

    public Book(String title, String author, int numbersOfPages, int numbersIsbn) {
        this.title = title;
        this.author = author;
        this.numbersOfPages = numbersOfPages;
        this.numbersIsbn = numbersIsbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumbersOfPages() {
        return numbersOfPages;
    }

    public int getNumbersIsbn() {
        return numbersIsbn;
    }
}
