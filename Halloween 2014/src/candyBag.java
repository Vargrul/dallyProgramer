import java.util.ArrayList;


public class candyBag {
	public ArrayList<candy> candyList;

	public int numCandy(){
		int out = 0;

		for (candy candy : candyList) {
			out += candy.getAmount();
		}

		return out;
	}

	public void printInv(){
		for (candy candy : candyList) {
			System.out.println(candy.getCandyType() + ": Amount: " +candy.getAmount() + " This is %" + (candy.getAmount()/numCandy())*100 + " of the total.");
		}
	}

}
