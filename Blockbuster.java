/**
 * This class represents a Blockbuster store that has movies and video games customers can check out.
 * @author mpalucci3
 * @version 05.05
 */
import java.util.ArrayList;
public class Blockbuster {
    private ArrayList<Media> inventory;

    /**
     * No arg constructor that initializes inventory to an ArrayList of type Media.
     */
    public Blockbuster() {
        this.inventory = new ArrayList<Media>();
    }

    /**
     * This method takes in a non-null media item and adds it to the end of inventory.
     * @param item representing Media object to be appended
     */
    public void addMedia(Media item) {
        if (item == null) {
            return;
        }
        inventory.add(item);
    }

    /**
     * This method takes in a non-null media item and removes the first occurrence of it.
     * @param item Media representing the item to be removed from Blockbuster's inventory
     * @return Media representing the item to be removed from Blockbuster's inventory
     */
    public Media removeMedia(Media item) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (item == null) {
            return null;
        }
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).equals(item)) {
                Media mediaToReturn = inventory.get(i);
                inventory.remove(i);
                return mediaToReturn;
            }
        }
        return null;
    }

    /**
     * Sort method using the bubble sort algorithm.
     * Source: https://www.geeksforgeeks.org/bubble-sort/
     */
    public void sortMedia() {
        boolean swapped;
        Media temp;

        for (int i = 0; i < inventory.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < inventory.size() - 1 - i; j++) {
                if (inventory.get(j).compareTo(inventory.get(j + 1)) > 0) {
                    temp = inventory.get(j);
                    inventory.set(j, inventory.get(j + 1));
                    inventory.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Search method, using binary search, that finds and returns the item in the store.
     * @param obj Media object representing item to be searched
     * @return Media object representing the item in the inventory list matching the searched item
     */
    public Media findMedia(Media obj) {
        int min = 0;
        int max = inventory.size();
        int mid = 0;

        boolean found = false;
        while (!found && min <= max) {
            mid = (min + max) / 2;
            if (inventory.get(mid).equals(obj)) {
                found = true;
            } else if (obj.compareTo(inventory.get(mid)) < 0) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        if (found) {
            return inventory.get(mid);

        } else {
            return null;
        }
    }

    /**
     * Method which returns the most popular movie, based on rating, then lexicographical order, using linear search.
     * @return Movie representing the most popular Movie
     */
    public Movie getMostPopularMovie() {
        //CHECK THIS, use of generics?
        int currentRating = 0;
        Media mostPopularMovie = inventory.get(0);
        for (Media item : inventory) {
            if (item instanceof Movie) {
                if (item.getRating() > currentRating) {
                    currentRating = item.getRating();
                    mostPopularMovie = item;
                } else if (item.getRating() == currentRating) {
                    if (item.compareTo(mostPopularMovie) < 0) {
                        mostPopularMovie = item;
                    }
                }

            }
        }
        if (!(mostPopularMovie instanceof Movie)){
            return null;
        }
        return (Movie) mostPopularMovie;
    }
}
