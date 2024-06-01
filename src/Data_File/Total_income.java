
package Data_File;

import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Total_income extends JFrame {

    private JTextArea textArea;

    public Total_income() {
        setTitle("Total Income");
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
        String filePath = "totalsales.txt";
        try {
            String fileContent = fileReader.readFile(filePath);
            textArea.setText(fileContent);
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + ex.getMessage());
        }
    }

    public static void main(String[] args) 
    {
        Total_income fileReader = new Total_income();
        fileReader.setVisible(true);
    }
}