
package Data_File;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

abstract class FileReader {
    public abstract String readFile(String filePath) throws FileNotFoundException;
}