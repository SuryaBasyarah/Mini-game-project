public class Player {
    private int x;
    private int y;
    public int health;
    private int armor;
    private Inventory inventory;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.health = 100;
        this.armor = 10;
        this.inventory = new Inventory();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public int getArmor() {
        return armor;
    }

    public void heal(int amount) {
        health += amount;
    }

    public void takeDamage(int damage) {
        int effectiveDamage = damage - armor;
        if (effectiveDamage < 0) {
            effectiveDamage = 0;
        }
        health -= effectiveDamage;
        if (health < 0) {
            health = 0;
        }
    }

    public int attack() {
        return 20;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
