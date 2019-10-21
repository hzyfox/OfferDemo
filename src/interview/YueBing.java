package interview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Random;

public class YueBing {
    public static void main(String[] args) {
        new Test();
    }
}

class Test extends JFrame implements ActionListener {
    private HashSet<Integer> rememberSet = new HashSet<>();
    private int selected = 0;
    private JTextArea text = new JTextArea("Welcome");
    private JButton start;
    private JButton stop;
    private boolean flag = false;
    private String[] str = {"强博", "郑博", "超博", "小花", "轩博", "冬博", "小冯", "明玉", "姜焰", "开希", "小马", "熊倩","代博","胡振宇","张一鹏","沈欢"};
    private int count = 0;

    Test() {
        setSize(400, 400);
        text.setFont(new Font("", Font.BOLD, 50));
        start = new JButton("start");
        stop = new JButton("stop");
        stop.setEnabled(false);
        text.setEnabled(false);
        JPanel panel = new JPanel();
        panel.add(start);
        panel.add(stop);
        start.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    count++;
                }
                System.out.println("KeyListener start: " + count);
                if (count % 2 == 0) {
                    start.setEnabled(true);
                    stop.setEnabled(false);
                    stop.setFocusable(false);
                    start.setFocusable(true);
                    start.requestFocus();
                    flag = false;
                } else if (count % 2 == 1) {
                    start.setEnabled(false);
                    stop.setEnabled(true);
                    start.setFocusable(false);
                    stop.setFocusable(true);
                    stop.requestFocus();
                    flag = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
            }

            @Override
            public void keyTyped(KeyEvent arg0) {
            }
        });
        stop.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    count++;
                }
                if (count % 2 == 0) {
                    start.setEnabled(true);
                    stop.setEnabled(false);
                    stop.setFocusable(false);
                    start.setFocusable(true);
                    start.requestFocus();
                    flag = false;
                } else if (count % 2 == 1) {
                    start.setEnabled(false);
                    stop.setEnabled(true);
                    start.setFocusable(false);
                    stop.setFocusable(true);
                    stop.requestFocus();
                    flag = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
            }

            @Override
            public void keyTyped(KeyEvent arg0) {
            }
        });
        start.addActionListener(this);
        stop.addActionListener(this);
        Container c = getContentPane();
        c.add(text, BorderLayout.NORTH);
        c.add(panel, BorderLayout.SOUTH);
        this.setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(300, 300);
        run();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        if (obj == start) {
            count += 1;
            start.setEnabled(false);
            stop.setEnabled(true);
            text.setEnabled(false);
            start.setFocusable(false);
            stop.setFocusable(true);
            stop.requestFocus();
            flag = true;
        } else if (obj == stop) {
            count += 1;
            rememberSet.add(selected);
            System.out.println(rememberSet);
            start.setEnabled(true);
            stop.setEnabled(false);
            text.setEnabled(false);
            stop.setFocusable(false);
            start.setFocusable(true);
            start.requestFocus();
            flag = false;
        }
    }

    private void run() {
        while (true) {
            if (flag) {
                Random ran = new Random();
                int index = Math.abs(ran.nextInt()) % str.length;
                String ss = str[index];
                text.setText(ss);
                text.setFont(new Font("", Font.BOLD, 50));
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
