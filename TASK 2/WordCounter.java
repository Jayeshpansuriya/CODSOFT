import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCounter {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Please choose an option:");
        System.out.println("1. Enter text manually");
        System.out.println("2. Provide a file");
        int option = inputScanner.nextInt();

        String text = "";

        if (option == 1) {
            inputScanner.nextLine(); 
            System.out.println("Enter the text:");
            text = inputScanner.nextLine();
        } else if (option == 2) {
            System.out.println("Enter the file path:");
            String filePath = inputScanner.next();
            try {
                text = readFile(filePath);
            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found.");
                inputScanner.close();
                return;
            }
        } else {
            System.out.println("Invalid option.");
            inputScanner.close();
            return;
        }

        int wordCount = countWords(text);
        System.out.println("Total number of words: " + wordCount);

        inputScanner.close();
    }


    public static String readFile(String filePath) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            content.append(fileScanner.nextLine()).append("\n");
        }
        fileScanner.close();
        return content.toString();
    }

    // Function to count the number of words in the input text
    public static int countWords(String text) {
        String[] words = text.split("\\s+|\\p{Punct}+");
        return words.length;
    }
}
