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

        // ����������岢���ò��ֹ�����ΪCardLayout
        contentPane = new JPanel();
        cardLayout = new CardLayout();
        contentPane.setLayout(cardLayout);
        setContentPane(contentPane);

        // �����Ҫ�л������
        panel1 = new DoubleBufferedPanel();
        panel2 = new DoubleBufferedPanel();
        panel3 = new DoubleBufferedPanel();
        contentPane.add(panel1, "panel1");
        contentPane.add(panel2, "panel2");
        contentPane.add(panel3, "panel3");

        // ��������л��İ�ť
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
            setOpaque(false); // ����͸��
        }

        @Override
        public void paint(Graphics g) {
            // ����˫������
            Image offscreen = createImage(getWidth(), getHeight());
            Graphics bufferGraphics = offscreen.getGraphics();

            // ��˫�������л������
            super.paint(bufferGraphics);

            // ��˫������������һ���Ի��Ƶ���Ļ��
            g.drawImage(offscreen, 0, 0, null);
        }
    }

    public static void main(String[] args) {
        new DoubleBufferDemo();
    }
}