package example;//����ʵ��
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class login_2 extends JFrame implements ActionListener{//���������Ϊ�¼�������
	public static void main(String s[]) {
		new login_2();
	}
	login_2(){
		setLayout(new BorderLayout());
		setBounds(300,200,250,130);
		
		JPanel jp1=new JPanel();
		add(jp1,BorderLayout.CENTER);
		jp1.setLayout(new GridLayout(2,2));
		jp1.add(new JLabel("�û���",JLabel.CENTER));
		jp1.add(new JTextField(10));
		jp1.add(new JLabel("��    ��",JLabel.CENTER));
		jp1.add(new JPasswordField(10));
		
		JPanel jp2=new JPanel();
		JButton b1=new JButton("��¼");
		b1.addActionListener(this);
		jp2.add(b1);
		jp2.add(new JButton("ȡ��"));
		add(jp2,"South");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		System.out.print("�û������������");
	}
}
