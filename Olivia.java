import java.util.ArrayList;
/**
 * Class defines Olivia's states and behaviors.
 * @author mpalucci3
 * @version 05.06
 */
public class Olivia {
    private static double budget;
    private static ArrayList<Media> cart = new ArrayList<Media>();
    private static boolean canUseConsole;

    /**
     * Method which adds a Media item to Olivia's cart. If the item exists in Blockbuster's inventory, then it
     * is added to her cart and the media item is removed from Blockbuster's inventory, and Olivia's budget is updated.
     * @param item Media representing the item that will be added to Olivia's cart
     * @param blockbusterStore Blockbuster representing a Blockbuster store
     * @return boolean representing if an item was added to Olivia's cart
     */
    public static boolean addToCart(Media item, Blockbuster blockbusterStore) {
        if (item == null || blockbusterStore == null) {
            return false;
        }
        if (budget >= item.getRentalPrice() && item.equals(blockbusterStore.findMedia(item))) {
            if (item instanceof VideoGame) {
                if (((VideoGame) item).isNeedsConsole() && canUseConsole) {
                    cart.add(item);
                    budget -= item.getRentalPrice();
                    blockbusterStore.removeMedia(item);
                    return true;
                }
            }
            cart.add(item);
            budget -= item.getRentalPrice();
            blockbusterStore.removeMedia(item);
            return true;
        }
        return false;
    }

    /**
     * Method which removes a Media item from Olivia's cart and places it back in the Blockbuster store's inventory.
     * @param item Media representing the item that is to be put back on the shelves
     * @param blockbusterStore Blockbuster representing a Blockbuster store
     */
    public static void changeMind(Media item, Blockbuster blockbusterStore) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).equals(item)) {
                blockbusterStore.addMedia(item);
                budget += cart.get(i).getRentalPrice();
                cart.remove(i);
                return;
            }
        }
    }

}
