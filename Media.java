/**
 * @author mpalucci3
 * @version 05.01
 * This class defines the basic behaviors of media items a customer can check out.
 */
public class Media {
    private Genre genre;
    private String name;
    private int rating;
    private double rentalPrice;

    /**
     * Constructor taking in genre, name, rating, & rentalPrice
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
     * Constructor that takes in genre, name and rating and sets rentalPrice to 7.0
     * @param genre Genre representing the genre of this media item
     * @param name String representing the name of this media item
     * @param rating int representing the rating of this media item
     */
    public Media(Genre genre, String name, int rating) {
        this(genre, name, rating, 7.0);
    }
    @Override
    public String toString(){
        return "Genre: " + genre
                + ", Name: " + name
                + ", Rating: " + rating
                + ", Rental Price: $" + rentalPrice;
    }
    @Override
    public boolean equals(Object o){
        if (o == null) {
            return false;
        } else if (!(o instanceof Media)){
            return false;
        }
        Media obj = (Media) o;
        if (this.name.equals(obj.name) && this.genre.equals(obj.genre) && this.rating == obj.rating && this.rentalPrice == obj.rentalPrice){
            return true;
        } else {
            return false;
        }
    }

    //@Override
    // compareto

    /**
     * Getter for String name
     * @return String name representing the name of this media item
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for int rating
     * @return int rating representing the rating of this media item
     */
    public int getRating() {
        return rating;
    }

    /**
     * Getter for double rentalPrice
     * @return double rentalPrice representing the price in dollars to rent this media item
     */
    public double getRentalPrice() {
        return rentalPrice;
    }
}
