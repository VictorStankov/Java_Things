package arraylists;

import java.util.Comparator;

public class MyNameComparator implements Comparator<Product> {
    @Override
    public int compare(Product first, Product second) {
        return second.getName().compareTo(first.getName());  // Sorts in reverse order, just for testing purposes
    }
}
