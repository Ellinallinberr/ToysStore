package Toys.SoftToys;

import Toys.Toy;

public class SoftToy extends Toy {

    public SoftToy(String name, String type, int id, int size) {
        super(name, type, id, size);
        calculateWinningChance(); // Вызов метода для установки шанса
    }
    

    @Override
    protected void calculateWinningChance() {
        switch (size) {
            case 1: winningChance = 30.0; break; // мягкий брелок
            case 2: winningChance = 25.0; break; // маленькая мягкая игрушка
            case 3: winningChance = 20.0; break; // средняя мягкая игрушка
            case 4: winningChance = 15.0; break;  // большая мягкая игрушка
            case 5: winningChance = 10.0; break;  // огромная мягкая игрушка
            default: winningChance = 0.0;        // на случай, если размер вне ожидаемого диапазона
        }
    }
}