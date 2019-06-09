package I_IteratorsAndComparators.Lab.BookComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    int getYear() {
        return year;
    }

    void setYear(int year) {
        this.year = year;
    }

    List<String> getAuthors() {
        return authors;
    }

    void setAuthors(String... authors) {
        if (authors.length == 0) {
            this.authors = new ArrayList<>();
        } else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", this.getTitle(), this.getYear());
    }

    @Override
    public int compareTo(Book book) {

        if (this.title == null || book == null) {
            return (this.title == null && book == null) ? 0 : this.title == null ? -1 : 1;
        }

        if (book.getTitle() == null) {
            return this.title == null ? 0 : 1;
        }

        int comp = this.title.compareTo(book.getTitle());
        return comp == 0 ?
                Integer.compare(this.year, book.getYear()) :
                comp;
    }
}
