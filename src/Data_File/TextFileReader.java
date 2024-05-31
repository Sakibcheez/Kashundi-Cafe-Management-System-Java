
package Data_File;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class TextFileReader extends FileReader {
    @Override
    public String readFile(String filePath) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        try (Scanner input = new Scanner(new File(filePath))) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}