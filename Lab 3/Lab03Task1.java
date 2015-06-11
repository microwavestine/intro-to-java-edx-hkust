 
import comp102x.ColorImage;

public class Lab03Task1 {
     
    /**
     * This recursive method draws stripe images from left to right, top to bottom, right to left and bottom to top repeatedly.
     * The drawing repeats until the remaining area is too small for drawing two horizontal stripes or two vertical stripes without overlapping.
     * All the remaining area that are too small for drawing should be covered by a single stripe drawn from left to right at the end.
     * 
     * @param image the ColorImage of which the stripes should be drawn on.
     * @param x the x position of the remaining area.
     * @param y the y position of the remaining area.
     * @param width the width of the remaining area.
     * @param height the height of the remaining area.
     * @param stripeSize the thickness of the stripe to be drawn.
     */
    public void changeScreen(ColorImage image, int x, int y, int width, int height, int stripeSize) {
    
        // Please write your code after this line 
        
        if(height < 2 * stripeSize)
        {
            animateStripe(image, x, y, width, stripeSize, "toRight");
        }
        if(width < 2*stripeSize)
        {
            animateStripe(image, x, y, width, height, "toRight");
        }
        else
        {
            animateStripe(image, x, y, width, stripeSize, "toRight");
            animateStripe(image, x+width-stripeSize, y+stripeSize, height-1, stripeSize, "toBottom");
            animateStripe(image, x-stripeSize, y+height-stripeSize, width, stripeSize, "toLeft");
            animateStripe(image, x, y+stripeSize, height-2*stripeSize, stripeSize, "toTop");
            changeScreen(image, x+stripeSize, y+stripeSize, width - 2* stripeSize, height - 2*stripeSize, stripeSize);
        }
        
    }
    
    private void animateStripe(ColorImage image, int left, int top, int length, int stripeSize, String direction) {

        long delay = (long) Math.pow(15, 5.5);
        
        switch (direction) {

            case "toRight":
                for (int i = 0; i < length; i++) {
                    image.drawRectangle(left + i, top, 1, stripeSize, 1, 0, 0);
                    pauseByTicks(delay);
                }
                break;
    
            case "toBottom":
                for (int i = 0; i < length; i++) {
                    image.drawRectangle(left, top + i, stripeSize, 1, 0, 0, 1);
                    pauseByTicks(delay);
                }
                break;
    
            case "toLeft":
                for (int i = length - 1; i >= 0; i--) {
                    image.drawRectangle(left + i, top, 1, stripeSize, 0, 1, 0);
                    pauseByTicks(delay);
                }
                break;
    
            case "toTop":
                for (int i = length - 1; i >= 0; i--) {
                    image.drawRectangle(left, top + i, stripeSize, 1);
                    pauseByTicks(delay);
                }
                break;
    
            default:
                System.err.println("Invalid direction: " + direction);
                System.err.println("Only \"toRight\", \"toBottom\", \"toLeft\", \"toTop\" are allowed!");
        }
    }

    private void pauseByTicks(long ticks) {
        while (ticks != 0) {
            ticks--;
        }
    }

}
