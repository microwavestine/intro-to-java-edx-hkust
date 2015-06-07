package comp102x.project.task;

import java.util.Random;

import comp102x.project.model.Target;

public class TargetUpdater {
    
    public void updateTarget(Target[] targets, int level) {
        
        // Please write your code after this line
        
          if(level == 2){
            for (int i = 0; i < 4; i++)
            {
                Random r = new Random();
                int randomnumber1 = r.nextInt(targets.length);
                int randomnumber2 = r.nextInt(targets.length);
                int tempX, tempY, tempZ;
                Target rtarget1 = targets[randomnumber1];
                Target rtarget2 = targets[randomnumber2];
                if(targets[randomnumber1].isHit() && targets[randomnumber2].isHit() || targets[randomnumber1].isHit() == false && targets[randomnumber2].isHit()==false)
                {
                    continue;
                }
                else{
                tempX = rtarget1.getX();
                tempY = rtarget1.getY();
                tempZ = rtarget1.getZ();
                rtarget1 = rtarget2;
                rtarget2.setX(tempX);
                rtarget2.setY(tempY);
                rtarget2.setZ(tempZ);
            }
           }
      }
      
        if(level == 3)
        {
           for (int i = 0; i < 10; i++)
            {
                 Random r = new Random();
                int randomnumber1 = r.nextInt(targets.length);
                int randomnumber2 = r.nextInt(targets.length);
                int tempX, tempY, tempZ;
                Target rtarget1 = targets[randomnumber1];
                Target rtarget2 = targets[randomnumber2];
                if(targets[randomnumber1].isHit() && targets[randomnumber2].isHit() || targets[randomnumber1].isHit() == false && targets[randomnumber2].isHit()==false)
                {
                    continue;
                }
                else{
                tempX = rtarget1.getX();
                tempY = rtarget1.getY();
                tempZ = rtarget1.getZ();
                rtarget1 = rtarget2;
                rtarget2.setX(tempX);
                rtarget2.setY(tempY);
                rtarget2.setZ(tempZ);
            }
           }
        }
    }

}
