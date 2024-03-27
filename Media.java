/**
 * This class defines the basic behaviors of media items a customer can check out.
 * @author mpalucci3
 * @version 05.02
 */
public abstract class Media implements Comparable<Media> {
    private Genre genre;
    private String name;
    private int rating;
    private double rentalPrice;

    /**
     * Constructor taking in genre, name, rating, & rentalPrice.
     * @param genre Genre representing the genre of this media item
     * @param name String representing the name of this media item
     * @param rating int representing the rating of this media item
     * @param rentalPrice double representing the price in dollars to rent this media item
     */
    public Media(Genre genre, String name, int rating, double rentalPrice) {
        this.genre = genre;
        this.name = name;
        this.rating = rating;
        this.rentalPrice = rentalPrice;
    }

    /**
     * Constructor that takes in genre, name and rating and sets rentalPrice to 7.0.
     * @param genre Genre representing the genre of this media item
     * @param name String representing the name of this media item
     * @param rating int representing the rating of this media item
     */
    public Media(Genre genre, String name, int rating) {
        this(genre, name, rating, 7.0);
    }
    @Override
    public String toString() {
        return String.format("Genre: %s, Name: %s, Rating: %d, Rental Price: $%.2f", genre, name, rating, rentalPrice);
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof Media)) {
            return false;
        }
        Media mediaComp = (Media) o;
        return (this.name.equals(mediaComp.name)
                && this.genre.equals(mediaComp.genre)
                && this.rating == mediaComp.rating
                && this.rentalPrice == mediaComp.rentalPrice);
    }

    @Override
    public int compareTo(Media o) {
        if (o == null) {
            return -9999;
        }

        if (!(this.genre.ordinal() == o.genre.ordinal())) {
            return this.genre.ordinal() - o.genre.ordinal();
        } else if (this.name.compareTo(o.name) != 0) {
            return this.name.compareTo(o.name);
        } else if (this.rating - o.rating != 0) {
            return this.rating - o.rating;
        }
        return 0;
    }

    /**
     * Getter for String name.
     * @return String name representing the name of this media item
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for int rating.
     * @return int rating representing the rating of this media item
     */
    public int getRating() {
        return rating;
    }

    /**
     * Getter for double rentalPrice.
     * @return double rentalPrice representing the price in dollars to rent this media item
     */
    public double getRentalPrice() {
        return rentalPrice;
    }
}
