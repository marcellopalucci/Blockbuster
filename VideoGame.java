/**
 * This class extends from media class and describes a video game, a specific kind of media
 * item that customers can check out.
 * @author mpalucci3
 * @version 05.04
 */
public class VideoGame extends Media {
    private int maxPlayers;
    private boolean needsConsole;

    /**
     * Constructor that takes in genre, name, rating, rentalPrice, maxPlayers, and needsConsole.
     * @param genre Genre representing the genre of this media item
     * @param name String representing the name of this media item
     * @param rating int representing the rating of this media item
     * @param rentalPrice double representing the price in dollars to rent this media item
     * @param maxPlayers int representing the maximum number of players that can play this video game at once
     * @param needsConsole boolean representing whether this video game needs a gaming console to play
     */
    public VideoGame(Genre genre, String name, int rating, double rentalPrice, int maxPlayers, boolean needsConsole) {
        super(genre, name, rating, rentalPrice);
        this.maxPlayers = maxPlayers;
        this.needsConsole = needsConsole;
    }

    /**
     * Constructor that takes in genre, name, and rating. Sets rentalPrice = 5.0,
     * maxPlayers = 2, and needsConsole = False.
     * @param genre Genre representing the genre of this media item
     * @param name String representing the name of this media item
     * @param rating int representing the rating of this media item
     */
    public VideoGame(Genre genre, String name, int rating) {
        this(genre, name, rating, 5.0, 2, false);
    }

    @Override
    public String toString() {
        String doitNeed = (needsConsole) ? "does" : "does not";
        return super.toString()
                + ", Players: " + maxPlayers
                + ", " + doitNeed + " need console";
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof VideoGame)) {
            return false;
        }
        VideoGame obj = (VideoGame) o;
        return (super.equals(obj) && this.maxPlayers == obj.maxPlayers && this.needsConsole == obj.needsConsole);
    }

    /**
     * Getter for boolean needsConsole.
     * @return boolean needsConsole representing whether this video game needs a gaming console to play
     */
    public boolean isNeedsConsole() {
        return needsConsole;
    }
}
