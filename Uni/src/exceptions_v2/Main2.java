package exceptions_v2;

public class Main2 {
    public static void main(String[] args){
        Book book_0 = new Book("Harry Potter", 19.99);
        Book book_1 = new Book("Hunger Games", 24.99);

        Object[] products = {book_0, book_1, "unknown"};

        System.out.printf("%s: %f; %s: %f\n", book_0.getName(), book_0.getPrice(), book_1.getName(), book_1.getPrice());

        try {
            reducePrice(products);
        }
        catch (SellableException e){
            System.out.println(e.getMessage());
        }

        System.out.printf("%s: %f; %s: %f\n", book_0.getName(), book_0.getPrice(), book_1.getName(), book_1.getPrice());
    }

    public static void reducePrice(Object[] books) throws SellableException{
        for (Object book : books){
            if (book instanceof Book book_cast) {
                book_cast.setPrice(book_cast.getPrice() - 5);
            }
            else
                throw new SellableException("Illegal member of array!");
        }
    }
}
