package test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class FibonacciCalculator extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextArea textArea;
    private JButton startButton, cancelButton;
    private FibonacciWorker worker;

    public FibonacciCalculator() {
        super("Fibonacci Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        add(textArea, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                cancelButton.setEnabled(true);
                worker = new FibonacciWorker();
                worker.execute();
            }
        });
        buttonPanel.add(startButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                worker.cancel(true);
            }
        });
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private class FibonacciWorker extends SwingWorker<String, Integer> {
        @Override
        protected String doInBackground() throws Exception {
            int n = 0;
            while (!isCancelled()) {
                int fib = fibonacci(n++);
                publish(fib);
            }
            return null;
        }

        @Override
        protected void process(List<Integer> chunks) {
            for (int i : chunks) {
                textArea.append(i + "\n");
            }
        }

        @Override
        protected void done() {
            startButton.setEnabled(true);
            cancelButton.setEnabled(false);
        }

        private int fibonacci(int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else {
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FibonacciCalculator().setVisible(true);
            }
        });
    }
}
