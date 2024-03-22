import java.util.ArrayList;

/**
 * Class defines Olivia's states and behaviors.
 * @author mpalucci3
 * @version 05.05
 */
public class Olivia {
    private static double budget = 50.0;
    private static ArrayList<Media> cart = new ArrayList<Media>();
    private static boolean canUseConsole = true;

    public static boolean addToCart(Media item, Blockbuster blockbusterStore) {
        if (item == null || blockbusterStore == null) {
            return false;
        }
        if (budget > item.getRentalPrice() && item.equals(blockbusterStore.findMedia(item))) {
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
