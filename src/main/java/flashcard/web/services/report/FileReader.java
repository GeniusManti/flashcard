package flashcard.web.services.report;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Kacper Kuźniarski on 23.06.2017.
 */
public class FileReader {

    public static List<String> read(File file) throws IOException {
        return FileUtils.readLines(file, "utf-8");
    }
}
