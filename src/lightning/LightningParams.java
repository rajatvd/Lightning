package lightning;

public class LightningParams {
	int minlength=50, maxlength=400, deviation=5, speed=5;
	double length=95, branchability=2, thetalim=0,thickness=1;
	public LightningParams(int ml, int maxl, int d, int s, double l, double ba, double t, double th){
		minlength=ml;
		maxlength=maxl;
		deviation=d;
		speed=s;
		length=l;
		branchability=ba;
		thetalim=t;
		thickness=th;
	}
	public LightningParams(LightningParams lp2){
		minlength=	   lp2.minlength;
		maxlength=     lp2.maxlength;
		deviation=     lp2.deviation;
		speed=         lp2.speed;
		length=        lp2.length;
		branchability= lp2.branchability;
		thetalim=      lp2.thetalim;
		thickness=     lp2.thickness;
	}
	public LightningParams(){}
}
