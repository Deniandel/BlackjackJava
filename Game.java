import java.util.Scanner;

public class Game{
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Deck myDeck = new Deck(1, true);
		
		
		System.out.println("What is your name?");
		String name = sc.nextLine();
		
		Player me = new Player(name);
		Player dealer = new Player("Dealer");
		
		me.addCard(myDeck.dealNextCard());
		dealer.addCard(myDeck.dealNextCard());
		me.addCard(myDeck.dealNextCard());
		dealer.addCard(myDeck.dealNextCard());
		
		System.out.println("First 2 Cards are given\n");
		me.printHand(true);
		dealer.printHand(false);
		System.out.println("\n");
		
		boolean meDone = false;
		boolean dealerDone = false;
		String ans;
		
		while(!meDone || !dealerDone) {
			
			if(!meDone) {
				
				System.out.print("Hit or stay? (Enter either Hit or Stay): ");
				ans = sc.next();
				System.out.println();
				
				if(ans.equalsIgnoreCase("Hit")) {
					meDone = !me.addCard(myDeck.dealNextCard());
				}
				else {
					meDone = true;
				}
			}
			
			if(!dealerDone) {
				if(dealer.getHandSum() < 17) {
					System.out.println("The dealer hits\n");
					dealerDone = !dealer.addCard(myDeck.dealNextCard());
					dealer.printHand(false);
				}
				else {
					System.out.println("The Dealer stayed\n");
					dealerDone = true;
				}
			}
			System.out.println();
		}
		sc.close();
		
		me.printHand(true);
		dealer.printHand(true);
		
		int mySum = me.getHandSum();
		int dealerSum = dealer.getHandSum();
		
		if(mySum > dealerSum && mySum <= 21 || dealerSum > 21) {
			System.out.println("You win " + name + "!");
		}
		else {
			System.out.println("Dealer wins!");
		}
		
	}
}