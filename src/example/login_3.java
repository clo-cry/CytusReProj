package example;
//�ڲ���ʵ��
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class login_3 extends JFrame {
	public static void main(String s[]) {
		new login_3();
	}

	login_3() {
		setLayout(new BorderLayout());
		setBounds(300, 200, 250, 130);

		JPanel jp1 = new JPanel();
		add(jp1, BorderLayout.CENTER);
		jp1.setLayout(new GridLayout(2, 2));
		jp1.add(new JLabel("�û���", JLabel.CENTER));
		jp1.add(new JTextField(10));
		jp1.add(new JLabel("��    ��", JLabel.CENTER));
		jp1.add(new JPasswordField(10));

		JPanel jp2 = new JPanel();
		JButton b1 = new JButton("��¼");
		b1.addActionListener(new work());
		jp2.add(b1);
		jp2.add(new JButton("ȡ��"));
		add(jp2, "South");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	class work implements ActionListener {//�ڲ���ʵ���¼��������ɼ�static��Ϊ��̬��
		int count = 1;

		public void actionPerformed(ActionEvent e) {
			if (count < 5) {
				System.out.println("�û������������");
				count++;
			} else
				JOptionPane.showMessageDialog(null, "���ִ�Ű�!!!");
		}
	}
}
