import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Struct;


public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath = "src/res/hallowData";
		
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = null;
		candyBag bag;
		
		if ((line = reader.readLine()) != null) {
			bag = new candyBag(line);
		}else bag = new candyBag();
		
		
		while((line = reader.readLine()) != null){
			boolean newType = true;
			for (candy candy : bag.candyList) {
				if(candy.getCandyType().equalsIgnoreCase(line)) {
					candy.inc();
					newType = false;
				}
			}
			if (newType) {
				bag.candyList.add(new candy(line));
			}
		}
		
		System.out.println(bag.numCandy());
		bag.printInv();
		
		reader.close();
	}

}