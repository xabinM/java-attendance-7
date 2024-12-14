package attendance.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {
    public static List<String> readFilePath(String path) throws IOException {
        return Files.readAllLines(Path.of(path));
    }
}
