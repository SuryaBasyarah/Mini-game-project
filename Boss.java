public class Boss {
    private int x;
    private int y;
    private int health;
    private int attack;

    public Boss(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.health = 200;
        this.attack = 30;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public int attack() {
        return attack;
    }
}
