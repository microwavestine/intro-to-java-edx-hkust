
public class Lab01Task1
{
    public int minPos(GameRecord[] records, int size) {
        
     int minLevel = records[0].getLevel();
     int minScore = 0;
     int position = 0;
     
     for (int i =1; i < size; i++) //get minimum level
     {
         if(records[i].getLevel() < minLevel)
         {
             minLevel = records[i].getLevel();
         }
     }
     
     for(int j =0; j<size; j++) //get score for minimum level
     {
         if(records[j].getLevel() == minLevel)
         {
             minScore = records[j].getScore();
             break;
         }
         
     }
     
     for(int k = 0; k < size; k++)
    {
         if(records[k].getLevel() == minLevel)
         {
             if(records[k].getScore() <= minScore)
             {
                 minScore = records[k].getScore();
                 position = k;
             }
         }
        
    }
    return position;
}

    public static void testCase1() {
    
        GameRecord[] records = new GameRecord[4];
        records[0] = new GameRecord("A", 2, 10);
        records[1] = new GameRecord("B", 3, 8);
        records[2] = new GameRecord("C", 2, 5);
        records[3] = new GameRecord("D", 1, 2);
        
        Lab01Task1 lab01Task1 = new Lab01Task1();
        int actualOutput = lab01Task1.minPos(records, 3); // only searching the first 3 elements
        
        System.out.println("Expected output: 2");
        System.out.println("Actual output: " + actualOutput);
    }
    
    // You can add more test cases to test your program prior to submitting your code to the online grader.
}
