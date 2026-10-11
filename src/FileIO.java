import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileIO {
    public static void main() {
        // everything that has to do with files may fail due to OS abnormalities or anything else that can go wrong
        // we should therefore always try to cath IOException when working with IO functions
        try {
            ancientFileWrite();
            modernFileWrite();
            modernFileRead();
            ancientFileRead();

        } catch (IOException ioException) {
            System.err.println("Something went wrong: " + ioException.getMessage());
        }
    }

    private static void modernFileWrite() throws IOException {
        Path output = Paths.get("./scores.txt");

        if (!Files.exists(output)) {
            // file does not exist yet
            Files.createFile(output);
        }

        // overwrite file
        String fileContents = "This is the first line of our documen!";
        Files.writeString(output, fileContents + "\n");

        // append to file
        String lineToAppend = "This is a cool line!";
        Files.writeString(output, lineToAppend + "\n", StandardOpenOption.APPEND);

        // delete the file
        Files.deleteIfExists(output);
    }

    private static void modernFileRead() throws IOException {
        Path input = Paths.get("./names.txt");

        // create a file with some lines so we have something to read
        Files.writeString(input, "Alice\nBob\nCharlie\n");

        // read every line of the file into a list (line breaks are removed)
        List<String> lines = Files.readAllLines(input);

        // print each line
        for (String line : lines) {
            System.out.println(line);
        }

        // delete the file
        Files.deleteIfExists(input);
    }

    private static void ancientFileRead() throws IOException {
        File inputFile = new File("./names.txt");

        // create a file with some lines so we have something to read
        try (FileWriter writer = new FileWriter(inputFile)) {
            writer.write("Alice\nBob\nCharlie\n");
        }

        // read the file line by line; readLine() returns null once the end of the file is reached
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
            }
        }

        // delete the file
        inputFile.delete();
    }

    private static void ancientFileWrite() throws IOException {
        File outputFile = new File("./lines.txt");

        if (!outputFile.exists()) {
            // file does not exist yet
            outputFile.createNewFile();
        }

        // overwrite file
        // try-with-resources closes the writer automatically, even if an exception is thrown
        String fileContents = "This is the first line of our documen!";
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(fileContents + "\n");
        }

        // append to file (second constructor argument enables append mode)
        String lineToAppend = "This is a cool line!";
        try (FileWriter writer = new FileWriter(outputFile, true)) {
            writer.write(lineToAppend + "\n");
        }

        // delete the file
        outputFile.delete();
    }
}
