import java.util.Scanner;

class eqParts{
	float coef;
	String vari;
	char ope;
	
	public eqParts(){
		coef = 0;
		vari = "";
	}
	public void setAll(eqParts in){
		this.coef = in.coef;
		this.vari = in.vari;
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
		eqParts[] eq1Org = new eqParts[eq1Phars.length];
		eqParts[] eq2Phars = equationPhaser(eq2);
		
		for(int i = 0 ; i < eq1Org.length ; i++){
			eq1Org[i] = new eqParts();
			eq1Org[i].setAll(eq1Phars[i]);
		}
		
		float[] out = new float[eq2Phars.length];
		
		int constLoc = 0;
		
		for(int i = 0 ; i < eq1Phars.length ; i++){
			if(eq1Phars[i].vari == "") constLoc = i;
			for(int j = 0 ; j < eq2Phars.length ; j++){
				if(eq1Phars[i].vari.equals(eq2Phars[j].vari)){
					eq1Phars[i].coef -= eq2Phars[j].coef;
				}
			}
		}
		
		eq1Phars[constLoc].coef = eq1Phars[constLoc].coef * (-1.0f);
		
		for(int i = 0 ; i < eq1Phars.length ; i++){
			if(eq1Phars[i].vari != ""){
				if(eq1Phars[i].vari.indexOf('x') != -1)eq1Phars[constLoc].coef = eq1Phars[constLoc].coef / eq1Phars[i].coef;
			}
		}
		
		out[0] = eq1Phars[constLoc].coef;
		out[1] = eq1Org[1].coef*out[0];
		out[1] = eq1Org[0].coef + out[1];
		
		return out;
	}
	
	public static String[] compSplit(String comp){
		String[] out = new String[comp.length()];
		for(int i = 0 ; i < out.length ; i++){
			out[i] = "";
		}
		
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
		
		for(int i = 1 ; i < eq.length() ; i++){
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
			if(eq.charAt(i) != '+' && eq.charAt(i) != '-'  && i < eq.length()-1){
				temp += eq.charAt(i);
			}else{
				if( i == eq.length()-1) temp += eq.charAt(i);
				if(temp.indexOf('x') != -1){
					t = compSplit(temp);
					out[count].coef = Float.parseFloat(t[0]);
					out[count].vari = t[1];
				}else{
					out[count].coef = Float.parseFloat(temp); 
				}
				
				count ++;
				temp = "";
				temp += eq.charAt(i);
			}
		}
		return out;		
	}
}