import java.util.ArrayList;

public class Inventory {
    private ArrayList<String> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
        System.out.println(item + " added to inventory");
    }

    public void useItem(Player player) {
        if (items.size() > 0) {
            String item = items.remove(0);
            System.out.println("Using " + item);
            if (item.equals("Health Potion")) {
                player.heal(100);
                System.out.println("Health restored");
            }
        } else {
            System.out.println("IT'S EMPTY!");
        }
    }
}
