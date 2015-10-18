package lightning;

import java.awt.*;
import java.util.Random;

public class Lightning {
	
	Color c;
	
	public Lightning(Color col){
		c=col;
	}
	
	public void drawLightning(int x, int y, Graphics g, LightningParams lp, LightningShape ls){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(c);
		g2.setStroke(new BasicStroke((float) lp.thickness, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL));
		g2.translate(x, y);
		Random r = new Random();
		int gx=0,gy=0,rand=0;
		double theta=0;
		while(true){
			rand = r.nextInt((lp.deviation*2)+1)-lp.deviation;
			g2.drawLine(gx, gy, gx+rand, gy+lp.speed);
			//branching
			if((r.nextDouble()*100)<lp.branchability){
				theta = (r.nextDouble()*lp.thetalim*2)-lp.thetalim;
				g2.translate(gx, gy);
				g2.rotate(theta);
				drawLightning(0,0,g,ls.makeBranch(lp),ls);
				g2.rotate(-theta);
				g2.translate(-gx, -gy);
			}
			//branching end
			gx+=rand;gy+=lp.speed;
			if(((r.nextDouble()*100)>lp.length && gy>lp.minlength) || gy>lp.maxlength)break;
		}
		g.translate(-x, -y);
	}

}
