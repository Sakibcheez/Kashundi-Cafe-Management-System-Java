
package Data_File;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Sales_History extends JFrame {

    private JTextArea textArea;

    public Sales_History() {
        setTitle("Sells History");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        displayFileContent();
    }

    private void displayFileContent() {
        FileReader fileReader = new TextFileReader();
        String filePath = "sales.txt";
        try {
            String fileContent = fileReader.readFile(filePath);
            textArea.setText(fileContent);
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Sales_History fileReader = new Sales_History();
        fileReader.setVisible(true);
    }
}

