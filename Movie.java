/**
 * @author mpalucci3
 * @version 05.02
 * This class extends from the Media class and describes a movie, a specific kind of media
 * item that customers can check out.
 */
public class Movie extends Media{
    private int runtime;

    /**
     * Constructor taking in genre, name, rating, rentalPrice, and runTime.
     * @param genre Genre representing the genre of this media item
     * @param name String representing the name of this media item
     * @param rating int representing the rating of this media item
     * @param rentalPrice double representing the price in dollars to rent this media item
     * @param runtime int representing the runtime of this movie in minutes
     */
    public Movie (Genre genre, String name, int rating, double rentalPrice, int runtime){
        super(genre, name, rating, rentalPrice);
        this.runtime = runtime;
    }

    /**
     * Constructor taking in genre, name, and rating. Setting rentalPrice to 5.0 and runtime to 111.
     * @param genre Genre representing the genre of this media item
     * @param name String representing the name of this media item
     * @param rating int representing the rating of this media item
     */
    public Movie (Genre genre, String name, int rating){
        this(genre, name, rating, 5.0, 111);
    }
    @Override
    public String toString(){
        return super.toString() + ", Runtime: " + runtime;
    }
    @Override
    public boolean equals(Object o){
        if (o == null){
            return false;
        } else if (!(o instanceof Movie)){
            return false;
        }
        Movie obj = (Movie) o;
        if (super.equals(obj) && this.runtime == obj.runtime){
            return true;
        } else {
            return false;
        }
    }

}
