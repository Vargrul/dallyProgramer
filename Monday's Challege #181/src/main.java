import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String eq1, eq2;
		
		System.out.print("Input first equation: ");
		eq1 = in.nextLine();
		System.out.print("Input secodn equation: ");
		eq2 = in.nextLine();
		
		String[] eq1Elements = equationPhaser(eq1);
		String[] eq2Elements = equationPhaser(eq2);
		
		float[] intersection = lineIntersect(eq1Elements, eq2Elements);
		
		System.out.println("Intersectiosn at: x" + intersection[0] + " y" + intersection[1]);
		in.close();
	}
	
	public static float[] lineIntersect(String[] eq1, String[] eq2){
		float[] out = new float[2];
		
		String[] holder = new String[eq1.length];
		
		for(int i = 0 ; i < eq1.length ; i += 2){
			String[] e1 = compSplit(eq1[i]);
			String[] e2 = compSplit(eq2[i]);
			
			holder[i] = (e1[0] + e2[0]) + e1[1];
		}
		
		return out;
	}
	
	public static String[] compSplit(String comp){
		String[] out = new String[2];
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
	
	public static String[] equationPhaser(String eq){
		String[] out;
		int count = 0;
		
		for(int i = 0 ; i < eq.length() ; i++){
			if(eq.charAt(i) == '+' || eq.charAt(i) == '-') count++;
		}
		out = new String[count*2+1];
		
		count = 0;
		for(int i = 0 ; i < eq.length() ; i++){
			if(eq.charAt(i) != '+' && eq.charAt(i) != '-'){
				out[count] += eq.charAt(i);
			}else{
				out[count + 1] += eq.charAt(i);				
				count += 2;
			}
		}
		return out;		
	}
}