package example;//将自制组件作为界面组件
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class compButton {
	public static void main(String args[]){
		new compButton();
	}
	
	compButton(){
		JFrame f=new JFrame();
		f.setLayout(new GridLayout(1,5));

		btTest[] b=new btTest[5];
		for(int i=0;i<5;i++){
			b[i]=new btTest();
			f.add(b[i]);
		}
		
		b[2].addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showConfirmDialog(null, "Don't Click me!");

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});

		f.setSize(400,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}

class btTest extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.red);
		g.fillOval(0, 0, 30, 30);
	}
	
}