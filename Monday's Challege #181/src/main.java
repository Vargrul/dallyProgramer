import java.util.Scanner;

class eqParts{
	float coef;
	String vari;
	char ope;
	
	public eqParts(){
		coef = 0;
		vari = "";
		ope = ' ';
	}
}

public class main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String eq1, eq2;
		
		System.out.print("Input first equation: ");
		eq1 = in.nextLine();
		System.out.print("Input secodn equation: ");
		eq2 = in.nextLine();
		
		float[] intersection = lineIntersect(eq1, eq2);
		
		System.out.println("Intersectiosn at: x" + intersection[0] + " y" + intersection[1]);
		in.close();
	}
	
	public static float[] lineIntersect(String eq1, String eq2){
		
		eqParts[] eq1Phars = equationPhaser(eq1);
		eqParts[] eq1Org = eq1Phars;
		eqParts[] eq2Phars = equationPhaser(eq2);
		
		float[] out = new float[eq2Phars.length];
		
		int constLoc = 0;
		
		for(int i = 0 ; i < eq1Phars.length ; i++){
			if(eq1Phars[i].vari == null) constLoc = i;
			for(int j = 0 ; j < eq2Phars.length ; j++){
				if(eq1Phars[i].vari == eq2Phars[j].vari){
					eq1Phars[i].coef -= eq2Phars[j].coef;
				}
			}
		}
		
		eq1Phars[constLoc].coef = eq1Phars[constLoc].coef * (-1);
		
		for(int i = 0 ; i < eq1Phars.length ; i++){
			if(eq1Phars[i].vari != null){
				if(eq1Phars[i].vari == "x")eq1Phars[constLoc].coef = eq1Phars[constLoc].coef / eq1Phars[i].coef;
			}
		}
		
		out[0] = eq1Phars[constLoc].coef;
		out[1] = eq1Org[1].coef*out[0];
		switch(eq1Org[0].ope){
		case '+': out[1] = eq1Org[0].coef + out[1]; break;
		case '-': out[1] = eq1Org[0].coef - out[1]; break;		
		}
		
		return out;
	}
	
	public static String[] compSplit(String comp){
		String[] out = new String[comp.length()];
		Boolean found = false;
		
		for(int i = 0 ; i < comp.length() ; i++){
			if( comp.charAt(i) != 'x' && !found) out[0] += comp.charAt(i);
			else{
				found = !found; 
				out[1] += comp.charAt(i);
			}
		}
		
		return out;
	}
	
	public static eqParts[] equationPhaser(String eq){
		eqParts[] out;
		int count = 0;
		
		for(int i = 0 ; i < eq.length() ; i++){
			if(eq.charAt(i) == '+' || eq.charAt(i) == '-') count++;
		}
		out = new eqParts[count+1];
		for(int i = 0 ; i < out.length ; i++){
			out[i] = new eqParts();
		}
		
		count = 0;
		String temp = new String();
		String[] t = new String[2];
		for(int i = 0 ; i < eq.length() ; i++){
			if(eq.charAt(i) != '+' && eq.charAt(i) != '-'){
				temp += eq.charAt(i);
			}else{
				out[i].ope = eq.charAt(i);
				if(temp.contains("x")){
					t = compSplit(temp);
					out[i].coef = Float.parseFloat(t[0]);
					out[i].vari = t[1];
				}else out[i].coef = Float.parseFloat(temp);
				
				count += 2;
			}
		}
		return out;		
	}
}