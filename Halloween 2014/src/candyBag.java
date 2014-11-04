import java.util.ArrayList;


public class candyBag {
	public ArrayList<candy> candyList;
	
	public candyBag(){
		candyList = new ArrayList();
	}
	public candyBag(String inS){
		candyList = new ArrayList();
		candyList.add(new candy(inS));
	}

	public int numCandy(){
		int out = 0;

		for (candy candy : candyList) {
			out += candy.getAmount();
		}

		return out;
	}

	public void printInv(){
		for (candy candy : candyList) {
			System.out.printf("%-20s %-15s %s%.1f%s", candy.getCandyType(), "Amount: " +candy.getAmount(), "This is ",  ((float)candy.getAmount()/(float)numCandy())*100.0f, "% of the total.\n");
		}
	}

}
