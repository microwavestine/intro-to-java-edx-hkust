
public class Lab01Task2
{
    public GameRecord[] updateGameRecords(GameRecord[] oldRecords, GameRecord newRecord) {
       int k = 0;
       boolean existing = false;
       int samelevel = 0;
       
       //find number of records with same level
       for (int i = 0; i < oldRecords.length; i++)
       {
           if(oldRecords[i].getLevel() == newRecord.getLevel())
           {
               samelevel++;
            }
        }
      
        //is there existing record?
       for(k = 0; k < oldRecords.length; k++)
       {
           if(oldRecords[k].getName().equals(newRecord.getName()) && oldRecords[k].getLevel() == newRecord.getLevel())
           {
               existing = true;
               break;
           }
       }
       
       //if there is existing record...
       if(existing)
       {
           //and score of new record is higher...
           if(newRecord.getScore() > oldRecords[k].getScore())
           {
               oldRecords[k] = newRecord;
               Util.sort(oldRecords);
               return oldRecords;
            }
            //else just return old records array
            else
            {
                return oldRecords;
            }
       }
       
       //if there's no existing record and number of same level is less than 10
       if(existing == false && samelevel < 10)
       {
            GameRecord[] temp = oldRecords.clone();
            oldRecords = new GameRecord[oldRecords.length + 1];
            System.arraycopy(temp, 0, oldRecords, 0, temp.length);
            oldRecords[temp.length] = newRecord;
            Util.sort(oldRecords);
            return oldRecords;
           
        }
      
       //if there's no existing record and number of same level is 10
       if(existing == false && samelevel == 10)
       {
           for(k =0; k < oldRecords.length; k++)
           {
               if(oldRecords[k].getLevel() == newRecord.getLevel() && oldRecords[k].getScore() < newRecord.getScore())
               {
                    oldRecords[k] = newRecord;
                    Util.sort(oldRecords);
                    return oldRecords;
                }
            }
            return oldRecords;
        }
        
       return oldRecords;
     
    }
    // test case 1: updating an existing record, given that the new record has a better score.
    public static void testCase1() {
    
        GameRecord[] oldRecords = new GameRecord[2];
        oldRecords[0] = new GameRecord("A", 2, 10);
        oldRecords[1] = new GameRecord("B", 2, 8);
        
        GameRecord newRecord = new GameRecord("B", 2, 10);
        
        Lab01Task2 lab01Task2 = new Lab01Task2();
        GameRecord[] updatedRecords = lab01Task2.updateGameRecords(oldRecords, newRecord);
        
        System.out.println("Expected output:");
        System.out.println("============================");
        System.out.println("A, 2, 10");
        System.out.println("B, 2, 10");
        System.out.println("============================\n");
        
        System.out.println("Actual output:");
        System.out.println("============================");
        printHighscoreTable(updatedRecords);
        System.out.println("============================\n");
    }
    
    private void sort(GameRecord[] records) {
        
        Util.sort(records);
    }
    
    // test case 2: inserting a new record given that we have less than records for the new record's level.
    public static void testCase2() {
    
        GameRecord[] oldRecords = new GameRecord[2];
        oldRecords[0] = new GameRecord("A", 2, 10);
        oldRecords[1] = new GameRecord("B", 2, 8);
        
        GameRecord newRecord = new GameRecord("C", 2, 10);
        
        Lab01Task2 lab01Task2 = new Lab01Task2();
        GameRecord[] updatedRecords = lab01Task2.updateGameRecords(oldRecords, newRecord);
        
        System.out.println("Expected output:");
        System.out.println("============================");
        System.out.println("A, 2, 10");
        System.out.println("C, 2, 10");
        System.out.println("B, 2, 8");
        System.out.println("============================\n");
        
        System.out.println("Actual output:");
        System.out.println("============================");
        printHighscoreTable(updatedRecords);
        System.out.println("============================\n");
    }

    // test case 3: replacing a lower score record of the same level, given that we already have 10 records for that level.
    public static void testCase3() {
    
        GameRecord[] oldRecords = new GameRecord[10];
        oldRecords[0] = new GameRecord("A", 2, 10);
        oldRecords[1] = new GameRecord("B", 2, 10);
        oldRecords[2] = new GameRecord("C", 2, 10);
        oldRecords[3] = new GameRecord("D", 2, 10);
        oldRecords[4] = new GameRecord("E", 2, 10);
        oldRecords[5] = new GameRecord("F", 2, 10);
        oldRecords[6] = new GameRecord("G", 2, 10);
        oldRecords[7] = new GameRecord("H", 2, 10);
        oldRecords[8] = new GameRecord("I", 2, 10);
        oldRecords[9] = new GameRecord("J", 2, 8);
        
        GameRecord newRecord = new GameRecord("K", 2, 10);
        
        Lab01Task2 lab01Task2 = new Lab01Task2();
        GameRecord[] updatedRecords = lab01Task2.updateGameRecords(oldRecords, newRecord);
        
        System.out.println("Expected output:");
        System.out.println("============================");
        System.out.println("A, 2, 10");
        System.out.println("B, 2, 10");
        System.out.println("C, 2, 10");
        System.out.println("D, 2, 10");
        System.out.println("E, 2, 10");
        System.out.println("F, 2, 10");
        System.out.println("G, 2, 10");
        System.out.println("H, 2, 10");
        System.out.println("I, 2, 10");
        System.out.println("K, 2, 10");
        System.out.println("============================\n");
        
        System.out.println("Actual output:");
        System.out.println("============================");
        printHighscoreTable(updatedRecords);
        System.out.println("============================\n");
    }
    
    // You can add more test case to test your program prior to submitting your code to the online grader.
    
    private static void printHighscoreTable(GameRecord[] records) {
        
        if (records == null) {
            return;
        }
        
        for (int i = 0; i < records.length; i++) {
            if (records[i] != null) {
                System.out.println(records[i].getName() + ", " + records[i].getLevel() + ", " + records[i].getScore());
            } else {
                System.out.println();
            }
        }
    }
}
