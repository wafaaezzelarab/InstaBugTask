package tests;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CustomDataProvider {
    public static Object[][] loadTestData(String filePath) {
        Object[][] data = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/TestData.csv"))) {
            String line;
            int rowCount = 0;
            int columnCount = 0;
            // First pass to count rows and columns
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (rowCount == 0) {
                    columnCount = values.length;  // Get number of columns from the header
                }
                rowCount++;
            }
            data = new Object[rowCount - 1][columnCount]; // Exclude header row
            // Reset BufferedReader to first line using a new instance
            try (BufferedReader br2 = new BufferedReader(new FileReader(filePath))) {
                br2.readLine(); // Skip header
                int index = 0;
                // Second pass to read data
                while ((line = br2.readLine()) != null) {
                    String[] values = line.split(",");
                    for (int j = 0; j < values.length; j++) {
                        data[index][j] = values[j];
                    }
                    index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    public static Object[][] loadTestData1(String filePath) {
        Object[][] data = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/LoginData.csv"))) {
            String line;
            int rowCount = 0;
            int columnCount = 0;
            // First pass to count rows and columns
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (rowCount == 0) {
                    columnCount = values.length;  // Get number of columns from the header
                }
                rowCount++;
            }
            data = new Object[rowCount - 1][columnCount]; // Exclude header row
            // Reset BufferedReader to first line using a new instance
            try (BufferedReader br2 = new BufferedReader(new FileReader(filePath))) {
                br2.readLine(); // Skip header
                int index = 0;
                // Second pass to read data
                while ((line = br2.readLine()) != null) {
                    String[] values = line.split(",");
                    for (int j = 0; j < values.length; j++) {
                        data[index][j] = values[j];
                    }
                    index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}