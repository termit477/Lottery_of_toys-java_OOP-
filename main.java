import Object_toy.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static ArrayList<Toy> toys = new ArrayList<>();

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        System.out.print("Нажмите 'Enter' для старта.");
        user_input.nextLine();
        createListToys(toys);

        boolean process = true;
        while (process) {
            view.chooseMode();
            switch (user_input.nextLine()) {
                case "1":
                    if (toys.isEmpty() == true) {
                        System.out.println("Игрушек на розыгрыш нету :(");
                    } else {
                        getAllInfo(toys);
                    }
                    break;
                case "2":
                    if (toys.isEmpty() == true) {
                        System.out.println("Игрушки кончились :(");
                    } else {
                        Toy randomToy = ChooseRandomToy(toys);
                        System.out.println(String.format("Игрушка на розыгрыш: %10s", randomToy.getInfo()));
                        logger.toyLogger(toys, randomToy);
                        removeToy(toys, randomToy);
                    }
                    break;
                case "3":
                    ToyForAdd(toys, user_input);
                    break;
                case "4":
                    process = false;
                    break;
                default:
                    break;
            }
        }

    }

    static void createListToys(ArrayList<Toy> a) {
        for (int i = 0; i <= 5; i++) {
            switch (i) {
                case 0:
                    Toy toy0 = new Constructor(0);
                    for (int j = 0; j < toy0.getLot(); j++) {
                        if (a.isEmpty() == true) {
                            addToy(a, new Constructor(0));
                        } else {
                            addToy(a, new Constructor(getId(a)));
                        }
                    }
                    break;
                case 1:
                    Toy toy1 = new Doll(1);
                    for (int j = 0; j < toy1.getLot(); j++) {
                        addToy(a, new Doll(getId(a)));
                    }
                    break;
                case 2:
                    Toy toy2 = new Lego(2);
                    for (int j = 0; j < toy2.getLot(); j++) {
                        addToy(a, new Lego(getId(a)));
                    }
                    break;
                case 3:
                    Toy toy3 = new RadioСontrolledСar(3);
                    for (int j = 0; j < toy3.getLot(); j++) {
                        addToy(a, new RadioСontrolledСar(getId(a)));
                    }
                    break;
                case 4:
                    Toy toy4 = new SoftToys(4);
                    for (int j = 0; j < toy4.getLot(); j++) {
                        addToy(a, new SoftToys(getId(a)));
                    }
                    break;
                case 5:
                    Toy toy5 = new TableGame(5);
                    for (int j = 0; j < toy5.getLot(); j++) {
                        addToy(a, new TableGame(getId(a)));
                    }
                    break;
                default:
                    break;
            }
        }
    }

    static int getId(ArrayList<Toy> game) {
        if (game.isEmpty() == true) {
            return 0;
        } else {
            return game.get(toys.size() - 1).getId() + 1;
        }
    }

    static void getAllInfo(ArrayList<Toy> a) {
        a.forEach(n -> System.out.println(n.getInfo()));
    }

    static Toy ChooseRandomToy(ArrayList<Toy> toys) {
        double weightAllToys = 0;
        double countWeight = 0;
        Toy result = null;
        for (Toy toy : toys)
            weightAllToys += toy.getWeight();
        double random = Math.random() * weightAllToys;
        for (Toy toy : toys) {
            countWeight += toy.getWeight();
            if (countWeight >= random) {
                result = toy;
                break;
            }
        }
        return result;
    }

    static void addToy(ArrayList<Toy> toys, Toy toy) {
        toys.add(toy);
    }

    static void ToyForAdd(ArrayList<Toy> games, Scanner input) {
        view.chooseToy();
        switch (input.nextLine()) {
            case "1":
                addToy(games, new Constructor(getId(games)));
                break;
            case "2":
                addToy(games, new Doll(getId(games)));
                break;
            case "3":
                addToy(games, new Lego(getId(games)));
                break;
            case "4":
                addToy(games, new RadioСontrolledСar(getId(games)));
                break;
            case "5":
                addToy(games, new SoftToys(getId(games)));
                break;
            case "6":
                addToy(games, new TableGame(getId(games)));
                break;
            default:
                break;
        }
    }

    static void removeToy(ArrayList<Toy> toys, Toy toy) {
        toys.remove(toy);
    }
}
