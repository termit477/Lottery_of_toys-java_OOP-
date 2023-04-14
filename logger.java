import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import Object_toy.Toy;


public class logger {

    public static void toyLogger(ArrayList<Toy> toys, Toy ToyForPrice) {
        String toyInfo = ToyForPrice.getInfo();
        try (FileWriter writer = new FileWriter("Toys.txt", true)) {
            writer.append(toyInfo);
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    public static ArrayList<String> GetInfoFromFile(String name) throws IOException {
        Path path = Path.of(name);
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(path);
        return (ArrayList<String>) list;
    }
}