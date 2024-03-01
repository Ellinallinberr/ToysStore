package Toys.SoftToysCollection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import Toys.SoftToys.SoftToy;

public class SoftToysCollection {
    public static List<SoftToy> softToys = loadSoftToysFromFile();
    
    static {
        // Инициализация коллекции мягких игрушек
        
    }
    
    public static int getNextId() {
        return softToys.isEmpty() ? 1 : softToys.get(softToys.size() - 1).getId() + 1;
    }

    // Добавление игрушки
    public static void addSoftToy(String name, String type, int size) {
        int id = getNextId();
        SoftToy newToy = new SoftToy(name, type, id, size);
        softToys.add(newToy);
        saveSoftToysToFile(newToy); // Сохраняем только новую игрушку
    }

    public static void saveSoftToysToFile(SoftToy newToy) {
        try (PrintWriter out = new PrintWriter(new FileWriter("softToys.csv", true))) {
            out.println(newToy.getId() + "," + newToy.getName() + "," + newToy.getType() + "," + newToy.getSize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // метод saveSoftToysToFile для сохранения одной игрушки
    public static void saveSoftToysToFile() {
        try (PrintWriter out = new PrintWriter(new FileWriter("softToys.csv"))) {
            for (SoftToy toy : softToys) {
                out.println(toy.getId() + "," + toy.getName() + "," + toy.getType() + "," + toy.getSize());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

// загрузка существующего списка
public static List<SoftToy> loadSoftToysFromFile() {
    List<SoftToy> softToys = new ArrayList<>();
    File file = new File("softToys.csv");
    if (file.exists()) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 4) {
                    // Если данных не достаточно, выводим сообщение об ошибке и пропускаем эту строку
                    System.out.println("Некорректные данные в строке: " + line);
                    continue;
                }
                SoftToy toy = new SoftToy(data[1], data[2], Integer.parseInt(data[0]), Integer.parseInt(data[3]));
                softToys.add(toy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return softToys;
    }
    // очистить файл
    public static void clearSoftToysFile() {
    try (PrintWriter out = new PrintWriter(new FileWriter("softToys.csv"))) {
        
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
    public static boolean removeSoftToyById(int id) {
        for (int i = 0; i < softToys.size(); i++) {
            if (softToys.get(i).getId() == id) {
                softToys.remove(i);
                saveSoftToysToFile(); // Обновляем вызов метода здесь
                return true;
            }
        }
        return false;
    }

}


















// package Toys.SoftToysCollection;

// import java.util.ArrayList;
// import java.util.List;
// import Toys.Toy;
// import Toys.SoftToys.SoftToy;

// public class SoftToysCollection {
//     public static List<Toy> softToys = new ArrayList<>();
    
//     static {
//         // Инициализация коллекции мягких игрушек
//         initializeCollection();
//     }
//     public static List<Toy> createSoftToyCollection() {
//         List<Toy> newCollection = new ArrayList<>();
//         // Здесь добавьте логику для наполнения newCollection игрушками
//         return newCollection;

//     public static void initializeCollection() {

//         // Мягкие брелоки
//         softToys.add(new SoftToy("Frog Keychain", "KeychainSoftToy", 1, 1));
//         softToys.add(new SoftToy("Mouse Keychain", "KeychainSoftToy", 2, 1));
//         softToys.add(new SoftToy("Tiger Keychain", "KeychainSoftToy", 3, 1));

//         // Маленькие мягкие игрушки
//         softToys.add(new SoftToy("Little Bunny", "SmallSoftToy", 4, 2));
//         softToys.add(new SoftToy("Little Bear", "SmallSoftToy", 5, 2));
//         softToys.add(new SoftToy("Little Elephant", "SmallSoftToy", 6, 2));

//         // Средние мягкие игрушки
//         softToys.add(new SoftToy("Dinosaur", "AverageSoftToy", 7, 3));
//         softToys.add(new SoftToy("Kitty", "AverageSoftToy", 8, 3));
//         softToys.add(new SoftToy("Puppy", "AverageSoftToy", 9, 3));

//         // Большие мягкие игрушки
//         softToys.add(new SoftToy("Crocodile", "BigSoftToy", 10, 4));
//         softToys.add(new SoftToy("Caterpillar", "BigSoftToy", 11, 4));
//         softToys.add(new SoftToy("Panda", "BigSoftToy", 12, 4));

//         // Огромные мягкие игрушки
//         softToys.add(new SoftToy("Goose", "HugeSoftToy", 13, 5));
//         softToys.add(new SoftToy("Gorilla", "HugeSoftToy", 14, 5));
//         softToys.add(new SoftToy("Dragon", "HugeSoftToy", 15, 5));

       
//     }
//     public static int getNextId() {
//         // Возвращает уникальный ID, основываясь на размере списка softToys
//         return softToys.size() + 1;
//     }
    
//     // Метод для добавления новой игрушки в коллекцию
//     public static void addSoftToy(String name, String type, int size) {
//         softToys.add(new SoftToy(name, type, getNextId(), size));
//     }
//     public static List<Toy> createSoftToyCollection() {
        
//         throw new UnsupportedOperationException("Unimplemented method 'createSoftToyCollection'");
//     }
// }
// }