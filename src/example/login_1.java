package example;//外部类实现
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class login_1 extends JFrame{
	public static void main(String s[]) {
		new login_1();
	}
	login_1(){
		setLayout(new BorderLayout());
		setBounds(300,200,250,130);
		
		JPanel jp1=new JPanel();
		add(jp1,BorderLayout.CENTER);
		jp1.setLayout(new GridLayout(2,2));
		jp1.add(new JLabel("用户名",JLabel.CENTER));
		jp1.add(new JTextField(10));
		jp1.add(new JLabel("密    码",JLabel.CENTER));
		jp1.add(new JPasswordField(10));
		
		JPanel jp2=new JPanel();
		JButton b1=new JButton("登录");
		b1.addActionListener(new work());
		jp2.add(b1);
		jp2.add(new JButton("取消"));
		add(jp2,"South");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
class work implements ActionListener{//外部类实现事件监听
	int count=1;
	public void actionPerformed(ActionEvent e) {
		if(count<5) {
			System.out.println("用户名彧密码错误！");
			count++;
		}else JOptionPane.showMessageDialog(null, "如此执着啊!!!");
	}
}