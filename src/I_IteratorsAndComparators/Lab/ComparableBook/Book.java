package I_IteratorsAndComparators.Lab.ComparableBook;

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
        int comp = this.title.compareTo(book.getTitle());
        return comp == 0 ?
                Integer.compare(this.year, book.getYear()) :
                comp;
    }

    private void print() {
        System.out.printf("%n%s, %d", this.title, this.year);
        if(this.authors.size() > 0) {
            System.out.printf(", %s", String.join(", ", authors));
        }
    }
}
