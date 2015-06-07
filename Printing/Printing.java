public class Printing
{
  
  public static void printNumberLine(int seqCenter, int length)
  {
   if(seqCenter == 0)
   {
     int spaces = (length-1)/2;
     for(int i=0; i < spaces; i++)
     {
       System.out.print(" ");
     }
     
     System.out.print("0");
     
      for(int i=0; i < spaces; i++)
     {
       System.out.print(" ");
     }
     
    System.out.println("");
   }
   
   else if (seqCenter > 0)
   {
     int spacers = ((length-(2*seqCenter))-1)/2;
     
     if(spacers == 0)
     {
        int dir = 1;
        for(int i=0; i>-1; i+=dir){
        if(i == seqCenter) 
            dir = -1;
        System.out.print(i);
     }
        System.out.println("");
     }
     
     else
     {
       for(int j = 0; j < spacers; j++)
       {
         System.out.print(" ");
       }
       
       int dir = 1;
        for(int i=0; i>-1; i+=dir){
        if(i == seqCenter) 
            dir = -1;
        System.out.print(i);
     }
     
        for(int j = 0; j < spacers; j++)
       {
         System.out.print(" ");
       }  
       System.out.println("");
     }
   }
        
  }
  
  public static void printNumberDiamond(int diaCenter)
  {
    for(int i =0; i <= diaCenter; i++)
    {
      printNumberLine(i,((2*diaCenter)+1));
    }
    
    for(int j = diaCenter-1; j > -1; j--)
    {
      printNumberLine(j,((2*diaCenter)+1));
    }
    
  }
  
    public static void main (String args[])
  {
    printNumberDiamond(1);
        
  }
    
   
}