
package Homepage;

import java.io.*;
import java.util.Map;

public class EmployeeUtils {

    public static void loadEmployees(Map<String, String> employees, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    employees.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to load employees: " + e.getMessage());
        }
    }

    public static void saveEmployees(Map<String, String> employees, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<String, String> entry : employees.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Failed to save employees: " + e.getMessage());
        }
    }
}