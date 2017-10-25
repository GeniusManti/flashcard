package flashcard.application.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Kacper Kuźniarski on 23.06.2017.
 */
public class FileReader {

    public static List<String> read(String fileName) {
        List<String> list = new ArrayList<>();
        try(Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(list::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
