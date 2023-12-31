package ru.skillbox;

public final class Book
{
    private final String name;
    private final String nameOfAuthor;
    private final int numberOfPages;
    private final int ISBN;

    Book(String name,String nameOfAuthor,int numberOfPages,int ISBN)
    {
        this.name = name;
        this.nameOfAuthor = nameOfAuthor;
        this.numberOfPages = numberOfPages;
        this.ISBN = ISBN;
    }

    public String getName(){return name;}
    public String getNameOfAuthor(){return getNameOfAuthor();}
    public int getNumberOfPages(){return getNumberOfPages();}
    public int getISBN(){return ISBN;}
}
