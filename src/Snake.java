public class Snake{

    private final int CELL_SIZE = 25;
    private static int snakeSize = 5;
    private int x [];
    private int y [];
    private final int WEIGHT = 25;
    private final int HEIGHT = 25;
    private int lastX, lastY;

    public int [] getX(){ return x; }

    public int [] getY(){ return y; }

    public int getSize(){ return snakeSize; }

    public int getWEIGHT() { return WEIGHT; }

    public int getHEIGHT() { return HEIGHT; }

    public Snake(){
        x = new int[snakeSize];
        y = new int[snakeSize];

        for(int i=0;i<snakeSize;i++){
            x[i] = 250 + i*25;
            y[i] = 250;
        }
    }

    public Snake move(char direction, Snake snake){

        int [] temp = new int[snakeSize];
        int [] temp1 = new int[snakeSize];
        int i;

        for(i=0;i<snakeSize;i++){
            temp[i] = x[i];
            temp1[i] = y[i];
        }

        lastX = x[i-1];
        lastY = y[i-1];

        for (i = 1; i < snakeSize; i++) {
            snake.x[i] = temp[i - 1];
            snake.y[i] = temp1[i - 1];
        }

        if(direction == 'L')
            snake.x[0] -= CELL_SIZE;

        if(direction == 'R')
            snake.x[0] += CELL_SIZE;

        if(direction == 'U')
            snake.y[0] -= CELL_SIZE;

        if(direction == 'D')
            snake.y[0] += CELL_SIZE;

        return snake;
    }

    public void incSize(){

        Snake temp = new Snake();

        for(int i=0;i<snakeSize;i++) {
            temp.x[i] = this.x[i];
            temp.y[i] = this.y[i];
        }

        snakeSize++;

        this.x = new int[snakeSize];
        this.y = new int[snakeSize];

        for(int i=0;i<snakeSize-1;i++) {
            this.x[i] = temp.x[i];
            this.y[i] = temp.y[i];
        }

        this.x[snakeSize-1] = lastX;
        this.y[snakeSize-1] = lastY;
    }
}