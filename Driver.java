public class Driver {
    public static void main(String[] args) {
        Media movie1 = new Media(Genre.SCI_FI, "DUNE", 9, 17.0);
        Media movie2 = new Media(Genre.SCI_FI, "DUNE", 9, 17.0);
        System.out.println(movie1.toString());
        System.out.println(movie1.equals(movie2));

        Movie dune = new Movie(Genre.SCI_FI, "DUNE", 9, 17.0, 300);
        Movie dune1 = new Movie(Genre.SCI_FI, "DUNE", 9, 17.0, 300);
        System.out.println(dune.toString());
        System.out.println(dune.equals(dune1));

    }
}
