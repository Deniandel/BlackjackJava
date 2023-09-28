
public class Card {
    
	private Suit mySuit;
	
	private int myNumber;
	
	public Card(Suit aSuit, int aNumber) {
		
		this.mySuit = aSuit;
		
		if(aNumber >= 1 && aNumber <= 13) {
			this.myNumber = aNumber;
		}
		else {
			System.out.println("Error not a valid number!");
		}
	}
	
	public int getNumber() {
		return myNumber;
	}
	
	public String toString() {
		
		String numStr = "Error";
		
		switch(this.myNumber) {
			
		case 2:
			numStr = "2";
			break;
		
		case 3:
			numStr = "3";
			break;
			
		case 4:
			numStr = "4";
			break;
			
		case 5:
			numStr = "5";
			break;
			
		case 6:
			numStr = "6";
			break;
			
		case 7:
			numStr = "7";
			break;
			
		case 8:
			numStr = "8";
			break;
			
		case 9:
			numStr = "9";
			break;
		
		case 10:
			numStr = "10";
			break;
		
		case 11:
			numStr = "Jack";
			break;
		
		case 12:
			numStr = "Queen";
			break;
			
		case 13:
			numStr = "King";
			break;
			
		case 1:
			numStr = "Ace";
			break;
		}
		return numStr + " of " + mySuit.toString();
	}
}