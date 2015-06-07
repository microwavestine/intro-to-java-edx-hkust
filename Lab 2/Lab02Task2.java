import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class Lab02Task2
{
    /**
     * Loads the game records from a text file.
     * A GameRecord array is constructed to store all the game records.
     * The size of the GameRecord array should be the same as the number of non-empty records in the text file.
     * The GameRecord array contains no null/empty entries.
     * 
     * @param reader    The java.io.Reader object that points to the text file to be read.
     * @return  A GameRecord array containing all the game records read from the text file.
     */
    public GameRecord[] loadGameRecord(java.io.Reader reader) {
          Scanner scanner  =new Scanner(reader);
          String []records = new String [30]; //max 30 records
          
          int i = 0;
          while(scanner.hasNextLine()) //get num of lines
          {  
              records[i++] = scanner.nextLine();
          }

          GameRecord []gamearray=new GameRecord[i];
          String []eachrecord;
            for(int k = 0; k < i;++k)
            {
                eachrecord = records[k].split("\t");

                gamearray[k] = new GameRecord(eachrecord[0], Integer.parseInt(eachrecord[1]), Integer.parseInt(eachrecord[2]));
    }
    return gamearray;

}
    
    public static void testCase1() throws IOException {
           
        Lab02Task2 lab02Task2 = new Lab02Task2();
        
        FileReader reader = new FileReader("records.txt");
        GameRecord[] actualArray = lab02Task2.loadGameRecord(reader );
           
        System.out.println("Expceted: ");
        System.out.println("====================");
        int size = 9;
        for (int i = 0; i < size; i++) {
            System.out.println("" + (char)(i + 97) + "\t" + (3 - i / 3) + "\t " + (size - 3 * (i % 3) - i / 3));
        }
        System.out.println("====================");
           
        System.out.println();
        System.out.println("Actual: ");
        System.out.println("====================");
        for (int i = 0; actualArray != null && i < actualArray.length; i++) {
            if (actualArray[i] != null) {
                System.out.println(actualArray[i].getName() + "\t" + actualArray[i].getLevel() + "\t" + actualArray[i].getScore());
            } else {
                System.out.println(); // For visualizing null entries
            }
        }
        System.out.println("====================");
    }
}
