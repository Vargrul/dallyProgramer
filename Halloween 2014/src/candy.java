
public class candy {

	private String candyType;
	private int amount;

	public candy(String inS){
		setCandyType(inS); 
		setAmount(1);
	};
	
	public void inc(){
		setAmount(getAmount()+1);
	}

	public String getCandyType() {
		return candyType;
	}

	public void setCandyType(String candyType) {
		this.candyType = candyType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}	
}
