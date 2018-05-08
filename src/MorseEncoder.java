import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MorseEncoder{
    private static LookupTree<String, String> lookupTree;
    private static final File MORSE_DECODER_FILE = new File("morsecode.txt");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the file to read: ");
        String fileIn = in.nextLine();
        System.out.print("Please enter the file to print to: ");
        String fileOut = in.nextLine();

        loadDecoder(MORSE_DECODER_FILE);
        printMessage(new File(fileIn), new File(fileOut));
    }

    private static void loadDecoder(File fileIn){
        lookupTree = new LookupTree<>();
        try(Scanner in = new Scanner(fileIn)){
            while(in.hasNextLine()){
                String[] strings = in.nextLine().trim().split(" ");
                lookupTree.put(strings[0], strings[1]);
            }
        } catch (FileNotFoundException nF){
            System.err.println(nF.getMessage());
        }
    }

    private static void printMessage(File fileIn, File fileOut){

    }
}
