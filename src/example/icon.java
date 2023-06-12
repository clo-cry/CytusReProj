package example;//界面上加载图片
import javax.swing.*;
import java.io.File;

public class icon extends JPanel{

	public static void main(String args[]){
		icon p=new icon();
	}

	icon(){
		JFrame f=new JFrame();
		ImageIcon image=new ImageIcon("img/wildcat.png");
		JLabel label=new JLabel("Reloaded",image,JLabel.CENTER);
		f.add(label);

		f.setSize(700,700);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}