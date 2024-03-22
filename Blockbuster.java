import java.util.ArrayList;

/**
 * This class represents a Blockbuster store that has movies and video games customers can check out.
 * @author mpalucci3
 * @version 05.04
 */
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
     * @param obj representing Media object to be appended
     */
    public void addMedia(Media obj) {
        if (obj == null) {
            return;
        }
        inventory.add(obj);
    }

    /**
     * This method takes in a non-null media item and removes the first occurrence of it.
     * @param obj
     * @return
     */
    public Media removeMedia(Media obj) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (obj == null) {
            return null;
        }
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).equals(obj)) {
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
     * Search method, using binary serach, that finds and returns the item in the store.
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

    public Movie getMostPopularMovie() {
        int currentRating = 0;
        Media mostPopularMovie = inventory.get(0);
        for (Media i : inventory) {
            if (i instanceof Movie) {
                if (i.getRating() > currentRating) {
                    currentRating = i.getRating();
                    mostPopularMovie = i;
                } else if (i.getRating() == currentRating) {
                    if (i.compareTo(mostPopularMovie) < 0) {
                        mostPopularMovie = i;
                    }
                }

            }
        }
        return (Movie) mostPopularMovie;
    }



}
