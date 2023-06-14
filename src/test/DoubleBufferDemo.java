package test;

import java.awt.*;
import javax.swing.*;

public class DoubleBufferDemo extends JFrame {

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private CardLayout cardLayout;
    private JPanel contentPane;
    public DoubleBufferDemo() {
        setTitle("Double Buffer Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建内容面板并设置布局管理器为CardLayout
        contentPane = new JPanel();
        cardLayout = new CardLayout();
        contentPane.setLayout(cardLayout);
        setContentPane(contentPane);

        // 添加需要切换的面板
        panel1 = new DoubleBufferedPanel();
        panel2 = new DoubleBufferedPanel();
        panel3 = new DoubleBufferedPanel();
        contentPane.add(panel1, "panel1");
        contentPane.add(panel2, "panel2");
        contentPane.add(panel3, "panel3");

        // 设置面板切换的按钮
        JPanel buttonPanel = new JPanel();
        JButton prevButton = new JButton("Prev");
        JButton nextButton = new JButton("Next");
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        prevButton.addActionListener(e -> cardLayout.previous(contentPane));
        nextButton.addActionListener(e -> cardLayout.next(contentPane));
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setSize(400, 300);
        setVisible(true);
    }

    private class DoubleBufferedPanel extends JPanel {
        public DoubleBufferedPanel() {
            setOpaque(false); // 设置透明
        }

        @Override
        public void paint(Graphics g) {
            // 创建双缓冲区
            Image offscreen = createImage(getWidth(), getHeight());
            Graphics bufferGraphics = offscreen.getGraphics();

            // 在双缓冲区中绘制组件
            super.paint(bufferGraphics);

            // 将双缓冲区的内容一次性绘制到屏幕上
            g.drawImage(offscreen, 0, 0, null);
        }
    }

    public static void main(String[] args) {
        new DoubleBufferDemo();
    }
}