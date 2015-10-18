package lightning;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LightningGUI {
	
	Lightning l;
	int width=500,height=500;
	JFrame jf;
	LightningParams lp;
	
	public static void main(String[] args) {
		new LightningGUI();
	}
	
	
	@SuppressWarnings("serial")
	public LightningGUI(){
		
		lp = new LightningParams();
		lp.deviation=3;
		lp.speed=5;
		lp.minlength=300;
		lp.thickness=4;
		lp.thetalim=1.5;
		lp.branchability=10;
		l = new Lightning(Color.yellow);
		jf = new JFrame("Lightning!");
		JPanel jp = new JPanel(){
			public void paintComponent(Graphics g){
				g.setColor(Color.yellow);
				g.fillRect(0, 0, width, height);
				g.setColor(Color.black);
				g.fillRect(0, 0, width, height);
				l.drawLightning(200,50,g,lp, new LightningShape(){
					public LightningParams makeBranch(LightningParams lp){
						LightningParams lp2=new LightningParams(lp);
						lp2.branchability+=4;
//						lp2.deviation/=2;
						lp2.maxlength*=0.3;
						lp2.minlength*=0.3;
						lp2.thetalim*=1.3;
						lp2.thickness*=0.7;
						
						return lp2;
					}
					
				});
			}
		};
		
		JButton butt = new JButton("Lightning!!");
		butt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jf.repaint();
			}
		});
		jp.add(butt);
		
		jp.setPreferredSize(new Dimension(width,height));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(jp);
		jf.pack();
		jf.setVisible(true);
	}
}
