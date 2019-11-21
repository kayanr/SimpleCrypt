import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SonnetCypher {
    public static String readFile() {
        StringBuilder output = new StringBuilder();
        try { // getting the file
            File file = new File("/Users/val/Dev/zipcode_Labs/Week5/SimpleCrypt/sonnet18.txt");
            BufferedReader br = new BufferedReader(new FileReader(file)); // read the file
            while ((br.readLine()) != null)
                output.append(br.readLine());
        } catch(Exception e) {}
        return output.toString();
    }

}
