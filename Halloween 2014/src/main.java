import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Struct;


public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath = "/res/hallowData";
		
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		candyBag bag = new candyBag();
		String line = null;
		while((line = reader.readLine()) != null){
			boolean newType = true;
			for (candy candy : bag.candyList) {
				if(candy.getCandyType() == line) {
					candy.inc();
					newType = !newType;
				}
			}
			if (newType) {
				bag.candyList.add(new candy(line));
			}
		}
		
		bag.printInv();
		
		reader.close();
	}

}