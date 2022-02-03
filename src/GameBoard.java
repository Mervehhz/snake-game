import java.awt.*;
import javax.swing.*;

public class GameBoard extends JPanel{

    private Snake snake;
    private Apple apple;

    public GameBoard(Snake snke, Apple appl, JLabel score, JLabel gameOver){
        snake = snke;
        apple = appl;

        this.add(gameOver);
        this.add(score);
    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        super.setBackground(Color.black);

        for(int i=0;i<snake.getSize();i++) {
            g.setColor(Color.green);
            g.fillOval(snake.getX()[i], snake.getY()[i], snake.getWEIGHT(), snake.getHEIGHT());

            if (i == snake.getSize() - 1) {
                g.setColor(Color.red);
                g.fillOval(apple.getAppleX(), apple.getAppleY(), snake.getWEIGHT(), snake.getHEIGHT());
            }
        }
    }
}