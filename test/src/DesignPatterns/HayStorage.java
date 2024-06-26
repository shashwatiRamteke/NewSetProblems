package DesignPatterns;

public class HayStorage {
    private int quantity =0;
    private HayStorage(){} //probate constrictor

    private static final HayStorage instance = new HayStorage(); // crreating instance with private statc fibal
    public static HayStorage getInstance(){
        return instance;
    }

    public synchronized void addHay(int amount){
        quantity += amount;
    }

    public synchronized int getHayQuantity(){
        return quantity;
    }

    public static void main(String[] args) {
        HayStorage hayStorage = getInstance();
        hayStorage.addHay(3);
        hayStorage.addHay(2);

        System.out.println(hayStorage.getHayQuantity());

    }
}
