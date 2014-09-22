import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		String out, tempOut;
		int inN, counter;
		char lastChar = ' ';
		
		//input handling
		Scanner in = new Scanner(System.in);
		
		System.out.print("Seed: ");
		out = in.nextLine();
		
		System.out.print("N: ");
		inN = in.nextInt();
		in.close();
		
		for( int i = 0 ; i < inN ; i++ ){
			counter = 0;
			tempOut = "";
			
			for( int j = 0 ; j < out.length() ; j++ ){
				if( out.charAt(j) != lastChar){
					if(j > 0){
						tempOut += counter;
						tempOut += lastChar;
					}
					lastChar = out.charAt(j);
					counter = 1;
				}else{
					counter++;
				}
			}
			tempOut += counter;
			tempOut += lastChar;
			
			out = tempOut;
			System.out.println(out);
		}
	}

}
