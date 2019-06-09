package I_IteratorsAndComparators.Lab.BookComparator;

import java.util.Comparator;

class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b) {

        if (a == null || b == null) {
            return (a == b) ? 0 : a == null ? -1 : 1;
        }

        if (a.getTitle() == null || b.getTitle() == null) {
            return (a.getTitle() == null && b.getTitle() == null) ? 0 : a.getTitle() == null ? -1 : 1;
        }

        int result = a.getTitle().compareTo(b.getTitle());
        return result == 0 ?
                Integer.compare(a.getYear(), b.getYear()) :
                result;
    }
}
