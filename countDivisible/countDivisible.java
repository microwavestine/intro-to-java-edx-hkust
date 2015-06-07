public class countDivisible
{
  
  public static void main(String args[])
  {
   int k = countDivisible(39,50);
   System.out.println("returns" + k);
  }
  
    public static int countDivisible(int lowerBound, int upperBound)
  {
    int result = 0;
    
    for(int i = lowerBound; i < upperBound; i++)
    {
      if((i%3 == 0) && (i%9 != 0))
      {
        result++;
      }
    }
    
    return result;
    
  }
}