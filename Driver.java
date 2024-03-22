public class Driver {
    public static void main(String[] args) {
        Media movie1 = new Media(Genre.ACTION, "Uncut Gems", 9, 17.0);
        Media movie2 = new Media(Genre.SCI_FI, "Dune", 8, 17.0);
        Media movie3 = new Media(Genre.SCI_FI, "Interstellar", 8, 15.0);
        System.out.println(movie1.toString());
        System.out.println(movie1.equals(movie2));

        Movie dune = new Movie(Genre.COMEDY, "Harry Potter & the Chamber of Secrets", 9, 17.0, 300);
        Movie dune1 = new Movie(Genre.COMEDY, "ABC", 9, 17.0, 90);
        Movie borat2 = new Movie(Genre.COMEDY, "Borat", 9, 17.0, 90);
        System.out.println(dune.toString());
        System.out.println(dune.equals(dune1));

        VideoGame cs2 = new VideoGame(Genre.ACTION, "CS2", 8, 5.0, 2, false);
        VideoGame cssource = new VideoGame(Genre.ACTION, "CS2", 8);


        movie3.compareTo(movie2);

        System.out.println(cs2.toString());
        System.out.println(cs2.equals(cssource));
        System.out.println(movie1.compareTo(movie2));
        System.out.println();
        Blockbuster blockbusterStore = new Blockbuster();
        blockbusterStore.addMedia(movie1);
        blockbusterStore.addMedia(dune);
        blockbusterStore.addMedia(movie2);
        blockbusterStore.addMedia(dune1);
        blockbusterStore.addMedia(borat2);
        blockbusterStore.addMedia(cs2);
        blockbusterStore.addMedia(cssource);

        blockbusterStore.sortMedia();

        System.out.println(blockbusterStore.toString());
        System.out.println(blockbusterStore.findMedia(dune1).toString());

        System.out.println(blockbusterStore.getMostPopularMovie());

        Olivia.addToCart(borat2, blockbusterStore);
        Olivia.changeMind(borat2, blockbusterStore);
    }
}
