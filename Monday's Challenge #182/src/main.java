import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class main {

	public static void main(String[] args){
		
		File file = new File("src/Files/input.txt");
		try {
			Scanner in = new Scanner(file);
			String tempIn = "";
			
			while(in.hasNext()){
				tempIn += in.nextLine() + " ";
			}
			
			int nrChar = tempIn.length();
			String[] input = tempIn.split("\r\n|\r|\n|\\s");
			
			int nrCol = Integer.parseInt(input[0]);
			int widthCol = Integer.parseInt(input[1]);
			int sWidth = Integer.parseInt(input[2]);
			
			int wordColAmout = (input.length - (input.length % nrCol)) / nrCol;
			int wordExtPrCol = (int)Math.ceil((input.length % nrCol) / (nrCol - 1.0));
			
			int widthCount = 0;
			int nrCount = 1;
			
			int wCo = 0;
			int[] colWCo = new int[nrCol];
			while(wCo < input.length){
				//Write each column of each line
				for (int i : colWCo) {
					
				}
				
			}
			/*
			for ( int i = 0 ; i < input.size() ; i++) {
				//Which word, end of row?	
				
				//Are there space for the next word?
				if(input.get(i).length() + widthCount < widthCol){
					widthCount += input.get(i).length();
					System.out.print(input.get(i));
				}
			}*/
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
