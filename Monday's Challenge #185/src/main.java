import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class main {

	public static void main(String[] args) throws IOException {
		String filePath = "src/res/WordList";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = null;
		List<String> twitterWordList = new ArrayList<String>();
		
		while((line = reader.readLine()) != null){
			if(line.startsWith("at")){
				twitterWordList.add(line);
			}
		}
		
		Collections.sort(twitterWordList, new Comparator<String>(){
			@Override
		    public int compare(String o1, String o2) {
		        return Integer.valueOf(o1.length()).compareTo(o2.length());
		    }
		});
		
		while(twitterWordList.size() > 20){
			twitterWordList.remove(10);
		}
		
		for (String string : twitterWordList) {
			System.out.printf("%" + twitterWordList.get(twitterWordList.size()-1).length() + "s  :  %s\n", string.replace("at", "@"), string);
		}
	}

}

