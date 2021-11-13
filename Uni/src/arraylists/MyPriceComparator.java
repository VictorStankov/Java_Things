package arraylists;

import java.util.Comparator;

public class MyPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product first, Product second) {
        double result;
        return (int) ((result = (first.getPrice() - second.getPrice())) < 0 ? Math.floor(result) : Math.ceil(result));
    }
}
