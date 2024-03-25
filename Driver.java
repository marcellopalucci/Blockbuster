public class Driver {
    public static void main(String[] args) {

        Movie dune = new Movie(Genre.COMEDY, "Harry Potter & the Chamber of Secrets", 10, 17.0, 300);
        Movie dune1 = new Movie(Genre.ACTION, "Inglorious Basterds", 10, 17.0, 90);
        Movie borat1 = new Movie(Genre.COMEDY, "Borat", 9, 17.0, 90);
        Movie borat2 = new Movie(Genre.COMEDY, "Borat", 10, 17.0, 90);
        System.out.println(borat2.toString());
        System.out.println(borat2.equals(borat1));
        VideoGame cs2 = new VideoGame(Genre.ACTION, "CS2", 8, 5.0, 2, false);
        VideoGame csgo = new VideoGame(Genre.ACTION, "CS2", 9);
        System.out.println(cs2.toString());
        System.out.println(cs2.equals(csgo));

        Blockbuster blockbusterStore = new Blockbuster();
        blockbusterStore.addMedia(csgo);
        blockbusterStore.addMedia(cs2);
        blockbusterStore.addMedia(dune);
        blockbusterStore.addMedia(dune1);
        blockbusterStore.addMedia(borat1);
        blockbusterStore.addMedia(borat2);
        blockbusterStore.sortMedia();
        System.out.println(blockbusterStore.findMedia(cs2).toString());
        System.out.println(blockbusterStore.getMostPopularMovie().toString());
        Olivia.addToCart(borat1, blockbusterStore);
        Olivia.changeMind(dune1, blockbusterStore);
        Olivia.changeMind(borat1, blockbusterStore);

    }
}
