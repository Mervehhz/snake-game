import java.util.Random;

public class Apple{

    private int appleX;
    private int appleY;

    public int getAppleX(){ return appleX; }

    public int getAppleY(){ return appleY; }

    public Apple location(int frameSize, int weight){

        Random rand = new Random();
        appleX = rand.nextInt((frameSize-(int)(2*(3.14)*(weight/2)-2*weight))/weight);
        appleY = rand.nextInt((frameSize-(int)(2*(3.14)*(weight/2)))/weight);
        appleX *= weight;
        appleY *= weight;

        return this;
    }
}