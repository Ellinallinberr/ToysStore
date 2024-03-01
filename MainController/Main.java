package MainController;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Toys.Toy;
import Toys.SoftToys.SoftToy;
import Toys.SoftToysCollection.SoftToysCollection;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean exit = false;

        while (!exit) {
            System.out.println("Выберите действие: \n1. Розыгрыш \n2. Поиск игрушки \n3. Добавить игрушку \n4. Очистить список игрушек \n5. Выйти");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    performDraw(scanner);
                    break;
                case "2":
                    searchToy(scanner);
                    break;
                case "3":
                    addToy(scanner);
                    break;
                case "4":
                   clearSoftToysFile(scanner); // Очистка файла
                    break;
                case "5":
                    exit = true;
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Неизвестная команда. Пожалуйста, выберите один из пунктов меню.");
                    break;
            }
        }
        scanner.close();
    }


    public static void clearSoftToysFile(Scanner scanner) {
        System.out.println("Выберите коллекцию для удаления:");
        System.out.println("1. Мягкие игрушки");
        int collectionChoice = scanner.nextInt();
        scanner.nextLine(); // Прочитаем оставшийся символ новой строки после числа
    
        if (collectionChoice == 1) {
            System.out.println("Вы уверены, что хотите безвозвратно очистить список мягких игрушек?");
            System.out.println("1. Да (очистить)");
            System.out.println("2. Нет (выйти)");
    
            int confirmChoice = scanner.nextInt();
            scanner.nextLine(); // Прочитаем оставшийся символ новой строки после числа
    
            if (confirmChoice == 1) {
                try (PrintWriter out = new PrintWriter(new FileWriter("softToys.csv"))) {
                    // Файл будет очищен
                    System.out.println("Список мягких игрушек успешно очищен.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (confirmChoice == 2) {
                System.out.println("Очистка файла отменена.");
            } else {
                System.out.println("Неверный выбор. Очистка файла не выполнена.");
            }
        } else {
            System.out.println("Неверный выбор коллекции. Операция отменена.");
        }
    }


    private static void performDraw(Scanner scanner) {
        // Здесь логика выбора коллекции и розыгрыша
        System.out.println("Выберите коллекцию для розыгрыша: \n1. Мягкие игрушки");
        String collectionInput = scanner.nextLine();
        if ("1".equals(collectionInput)) {
            drawToy(SoftToysCollection.softToys);
        }
    }

    private static void searchToy(Scanner scanner) {
        System.out.println("Выберите способ поиска:");
        System.out.println("1. Найти по названию");
        System.out.println("2. Найти по ID");
        int searchChoice = scanner.nextInt();
        scanner.nextLine(); // Прочитаем оставшийся символ новой строки после числа
    
        SoftToy foundToy = null; // Объявляем переменную здесь
    
        if (searchChoice == 1) {
            System.out.println("Введите название игрушки для поиска:");
            String name = scanner.nextLine().toLowerCase();
    
            for (SoftToy toy : SoftToysCollection.softToys) {
                if (toy.getName().equalsIgnoreCase(name)) {
                    System.out.println("Игрушка найдена: " + toy);
                    foundToy = toy;
                    break;
                }
            }
        } else if (searchChoice == 2) {
            System.out.println("Введите ID игрушки для поиска:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Прочитаем оставшийся символ новой строки после числа
    
            for (SoftToy toy : SoftToysCollection.softToys) {
                if (toy.getId() == id) {
                    System.out.println("Игрушка найдена: " + toy);
                    foundToy = toy;
                    break;
                }
            }
        } else {
            System.out.println("Неверный выбор. Поиск не выполнен.");
        }
    
        // Обработка найденной игрушки
        if (foundToy != null) {
            System.out.println("Что вы хотите сделать с этой игрушкой?");
            System.out.println("1. Удалить игрушку");
            System.out.println("2. Выйти");
            String option = scanner.nextLine();
    
            switch (option) {
                case "1":
                    SoftToysCollection.removeSoftToyById(foundToy.getId());
                    System.out.println("Игрушка удалена.");
                    break;
                case "2":
                    // Ничего не делаем, просто выходим
                    break;
                default:
                    System.out.println("Некорректный ввод. Действие отменено.");
                    break;
            }
        } else {
            System.out.println("Игрушка не найдена.");
        }
    }

    private static void addToy(Scanner scanner) {
        System.out.println("Выберите тип: \n1. Мягкие игрушки");
        String typeInput = scanner.nextLine();
    
        if ("1".equals(typeInput)) {
            System.out.println("Выберите размер игрушки: \n1. Keychain \n2. Small \n3. Medium \n4. Large \n5. Huge");
            int size = Integer.parseInt(scanner.nextLine());
            String type = "";
            
            switch (size) {
                case 1: type = "KeychainSoftToy"; break;
                case 2: type = "SmallSoftToy"; break;
                case 3: type = "AverageSoftToy"; break;
                case 4: type = "BigSoftToy"; break;
                case 5: type = "HugeSoftToy"; break;
                default: 
                    System.out.println("Неверный выбор размера.");
                    return;
            }
            
            System.out.println("Введите название:");
            String name = scanner.nextLine();
            
            // Добавление мягкой игрушки в список
            SoftToysCollection.addSoftToy(name, type, size);
            
            System.out.println("Игрушка добавлена: " + name + ", Type: " + type + ", Size: " + size);
        }
    }


    private static void drawToy(List<SoftToy> softToys) {
        Random random = new Random();
        List<Toy> possibleWinners = new ArrayList<>();
    
        for (Toy toy : softToys) {
            double chance = random.nextDouble() * 100;
            if (chance < toy.getWinningChance()) {
                possibleWinners.add(toy);
            }
        }
    
        if (!possibleWinners.isEmpty()) {
            Toy winner = possibleWinners.get(random.nextInt(possibleWinners.size()));
            System.out.println("Поздравляем! Вы выиграли игрушку: ");
            System.out.println("Название: " + winner.getName()+ " Тип: "+ winner.getType()+ " ID: " + winner.getId());
           
        } else {
            System.out.println("К сожалению, на этот раз вы не выиграли.");
        }
    }
}