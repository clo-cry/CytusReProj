package example;//本类实现
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class login_2 extends JFrame implements ActionListener{//本类对象作为事件监听器
	public static void main(String s[]) {
		new login_2();
	}
	login_2(){
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
		b1.addActionListener(this);
		jp2.add(b1);
		jp2.add(new JButton("取消"));
		add(jp2,"South");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		System.out.print("用户名彧密码错误！");
	}
}
