package Toys;

public abstract class Toy {
    protected String name;
    protected String type;
    protected int id;
    protected double winningChance; // Вероятность выигрыша в процентах
    protected int size; 

    public Toy(String name, String type, int id, int size) {
        this.name = name;
        this.type = type;
        this.id = id;
        this.size = size;
        
    }
    protected abstract void calculateWinningChance();

    @Override
    public String toString() {
        return "Toy{name:'" + name + "', type:'" + type + "', id:" + id + ", size:" + size + "}";
    }
    public void play() {
        System.out.println("Playing with " + name);
    }

    public String getName() {
        return name.toLowerCase(); // Возврат имени игрушки в нижнем регистре
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWinningChance() {
        return winningChance;
    }

    public void setWinningChance(double winningChance) {
        this.winningChance = winningChance;
    }

    public int getSize() {
        return size;
    } 
    
}