import java.util.Random;


public class Deck {
   
	private Card[] myCards;
	
	private int numCards;
	
	
	public Deck() {
		this(1 , false);
	}
	
	public Deck(int numDecks, boolean shuffle) {

		this.numCards = numDecks * 52;
		this.myCards = new Card[this.numCards];
		
		int index = 0;
		
		for(int x = 0; x <numDecks; x++) {
			for(int y = 0; y < 4; y++) {
				for(int z = 1; z <=13; z++) {
					this.myCards[index] = new Card(Suit.values()[y], z);
					index++;
				}
			}
		}
		
		if(shuffle) {
			this.shuffle();
		}
	}
	public void shuffle() {
		
		Random rng = new Random();
		
		Card temp;
		
		int j;
		for(int i = 0; i < this.numCards; i++) {
			
			j = rng.nextInt(this.numCards);
			
			temp = this.myCards[i];
			this.myCards[i] = this.myCards[j];
			this.myCards[j] = temp;
		}
	}
	public Card dealNextCard() {
		
		Card top = this.myCards[0];
		
		for(int i = 1; i < this.numCards; i++) {
			this.myCards[i-1] = this.myCards[i];
		}
		this.myCards[this.numCards-1] = null;
		
		this.numCards--;
		
		
		return top;
	}
	
	public void printDeck(int numToPrint) {
		
		for(int i = 0; i < numToPrint; i++) {
			System.out.printf("% 3d/%d %s\n", i+1, this.numCards, this.myCards[i].toString());
		}
		System.out.printf("\t\t[%d other]\n", this.numCards - numToPrint);
	}
	
}
