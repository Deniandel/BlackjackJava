
public class Player {

	private String name;
	
	private Card[] hand = new Card[10];
	
	private int numCards;
	
	public Player(String aName) {
		
		this.name = aName;
		
		this.emptyHand();
		
	}
	
	public void emptyHand() {
		for(int i = 0; i < 10; i++) {
			this.hand[i] = null;
		}
		this.numCards = 0;
	}
	
	public boolean addCard(Card aCard) {
		
		this.hand[this.numCards] = aCard;
		this.numCards++;
		
		return (this.getHandSum() <= 21);
		
	}
	
	public int getHandSum(){
		
		int handSum = 0;
		int cardNum;
		int numAces = 0;
		
		for(int i = 0; i < this.numCards; i++) {
			
			cardNum = this.hand[i].getNumber();
			
			if(cardNum == 1) {
				numAces++;
				handSum += 11;
			}
			else if(cardNum > 10 ) {
				handSum += 10;
			}
			else {
				handSum += cardNum;
			}
		}
		
		while(handSum > 21 && numAces > 0) {
			//11-10 = 1 if you are over 21
			handSum -= 10;
			numAces--;
		}
		
		return handSum;
	}
	
	public void printHand(boolean showFirstCard) {
		
		System.out.printf("%s's cards: \n", this.name);
		for(int i = 0; i < this.numCards; i++) {
			if(i == 0 && !showFirstCard) {
				System.out.println("  [hidden card]");
			}
			else {
				System.out.printf("  %s\n", this.hand[i].toString());
			}
		}
	}
	
}
