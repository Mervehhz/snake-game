import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Math.abs;

public class MyFrame extends JFrame implements KeyListener, ActionListener{

    private final int frameSize = 750;
    private Snake snake;
    private Apple apple;
    private char direction = 'L';
    private int appleEaten = 0;
    private JLabel score = new JLabel();
    private JLabel gameOver = new JLabel();
    private boolean inGame = true;
    private static int DELAY = 150;
    Timer timer;

    public MyFrame(){
        snake = new Snake();
        apple = new Apple();

        do {
            apple.location(frameSize, snake.getWEIGHT());
        }while (checkCollision());

        scoreLabel();

        this.setTitle("Snake Game");
        this.setSize(frameSize, frameSize+50);
        this.addKeyListener(this);
        this.add(new GameBoard(snake, apple, score, gameOver));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void scoreLabel(){

        score.setForeground(Color.red);
        score.setText("Score: "+appleEaten);
        score.setFont(new Font("Score: "+appleEaten, Font.BOLD, 30));
    }

    public void drawApple() {
        snake.incSize();
        do {
            apple = apple.location(frameSize, snake.getWEIGHT());
        }while(checkCollision());
        appleEaten++;
        scoreLabel();
    }

    public boolean checkCollision(){

        for(int i=0;i<snake.getSize();i++)
            if(abs(apple.getAppleX()-snake.getX()[i]) <= snake.getWEIGHT() || abs(apple.getAppleY()-snake.getY()[i]) <= snake.getHEIGHT())
                return true;
        return false;
    }

    public void isGameOver(){

        for(int i=1;i<snake.getSize();i++)
            if ((snake.getX()[0] == snake.getX()[i] && snake.getY()[0] == snake.getY()[i])
                 || snake.getX()[0] == 0 || snake.getY()[0] == 0 || snake.getX()[0]+snake.getWEIGHT() == frameSize || snake.getY()[0]+snake.getHEIGHT() == frameSize){

                gameOver.setForeground(Color.red);
                gameOver.setText("Game Over");
                gameOver.setFont(new Font("Game Over", Font.ITALIC, 75));

                inGame = false;
            }
    }

    @Override
    public void keyTyped(KeyEvent e) {

        if(inGame) {
            char key = e.getKeyChar();

            if (key == 'a' && direction != 'R')
                direction = 'L';

            else if (key == 'd' && direction != 'L')
                direction = 'R';

            else if (key == 'w' && direction != 'D')
                direction = 'U';

            else if (key == 's' && direction != 'U')
                direction = 'D';
        }
    }

    @Override
    public void keyPressed(KeyEvent e){

        if(inGame) {
            int key = e.getKeyCode();

            if (key == 37 && direction != 'R')
                direction = 'L';

            else if (key == 39 && direction != 'L')
                direction = 'R';

            else if (key == 38 && direction != 'D')
                direction = 'U';

            else if (key == 40 && direction != 'U')
                direction = 'D';
        }
    }

    @Override
    public void keyReleased(KeyEvent e){ }

    @Override
    public void actionPerformed(ActionEvent event){

        if (inGame) {
            snake = snake.move(direction, snake);

            if (snake.getX()[0] == apple.getAppleX() && snake.getY()[0] == apple.getAppleY())
                drawApple();

            isGameOver();
            repaint();
        }
    }
}