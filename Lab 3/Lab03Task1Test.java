
import comp102x.ColorImage;
import comp102x.Canvas;

public class Lab03Task1Test
{
   public static void test() {
    
       System.out.println("Transition effect starts.");
       
       int width = 400;
       int height = 400;
       int stripeSize = 10;
       
       ColorImage image = new ColorImage(width, height);
       Canvas canvas = new Canvas(width, height);
       canvas.add(image);
       
       Lab03Task1 lab03Task1 = new Lab03Task1();
       lab03Task1.changeScreen(image, 0, 0, width, height, stripeSize);
       
       System.out.println("Transition effect ends.");
   }
}
