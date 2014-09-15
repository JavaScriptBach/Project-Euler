import java.util.*;
public class PokerHand implements Comparable<PokerHand> {
	public String[] hand;
	public PokerHand(String[] hand){
		this.hand = new String[5];
		int current = 0;
		for (int i = 2; i <= 9; i++){
			for (int j = 0; j < hand.length; j++){
				if (hand[j].charAt(0) == Character.forDigit(i, 10)){
					this.hand[current] = hand[j];
					current++;
				}
			}
		}
		for (int j = 0; j < hand.length; j++){
			if (hand[j].charAt(0) == 'T'){
				this.hand[current] = hand[j];
				current++;
			}
		}
		for (int j = 0; j < hand.length; j++){
			if (hand[j].charAt(0) == 'J'){
				this.hand[current] = hand[j];
				current++;
			}
		}
		for (int j = 0; j < hand.length; j++){
			if (hand[j].charAt(0) == 'Q'){
				this.hand[current] = hand[j];
				current++;
			}
		}
		for (int j = 0; j < hand.length; j++){
			if (hand[j].charAt(0) == 'K'){
				this.hand[current] = hand[j];
				current++;
			}
		}
		for (int j = 0; j < hand.length; j++){
			if (hand[j].charAt(0) == 'A'){
				this.hand[current] = hand[j];
				current++;
			}
		}
	}
	
	public int score(){
		if (isFlush()){
			if (isStraight()){
				if (hand[0].charAt(0) == 'T')
					return 10;
				return 9;
			}
			return 6;
		}
		if (isStraight())
			return 5;
		if (isPair()){
			if (isThree()){
				if (isFour())
					return 8;
				if (isFullHouse())
					return 7;
				return 4;
			}
			
			if (isTwoPair())
				return 3;
			return 2;
			
		}
		return 1;
	}
	
	public boolean isFlush(){
		char suit = hand[0].charAt(1);
		for (int i = 1; i < 5; i++)
			if (hand[i].charAt(1) != suit)
				return false;
		return true;
	}
	
	public boolean isStraight(){
		char[] cards = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
		int current = 0;
		while (hand[0].charAt(0) != cards[current])
			current++;
		if (current > 8)
			return false;
		for (int i = 0; i < 5; i++){
			if (hand[i].charAt(0) != cards[current])
				return false;
			current++;
		}
		return true;
	}
	
	public boolean isPair(){
		for (int i = 0; i <= 3; i++){
			char first = hand[i].charAt(0);
			char second = hand[i+1].charAt(0);
			if (first == second)
				return true;
		}
		return false;
	}
	public boolean isThree(){
		for (int i = 0; i <= 2; i++){
			char first = hand[i].charAt(0);
			char second = hand[i+1].charAt(0);
			char third = hand[i+2].charAt(0);
			if (first == second && first == third)
				return true;
		}
		return false;
	}
	
	public boolean isFullHouse(){
		char first = hand[0].charAt(0);
		char second = hand[1].charAt(0);
		char third = hand[2].charAt(0);
		char fourth = hand[3].charAt(0);
		char fifth = hand[4].charAt(0);
		return (first == second && third == fourth && third == fifth) || (first == second && first == third && fourth == fifth);
	}
	public boolean isTwoPair(){
		char first = hand[0].charAt(0);
		char second = hand[1].charAt(0);
		char third = hand[2].charAt(0);
		char fourth = hand[3].charAt(0);
		char fifth = hand[4].charAt(0);
		return (first == second && third == fourth) || (second == third && fourth == fifth) || (first == second && fourth == fifth); 
	}
	public boolean isFour(){
		for (int i = 0; i <= 1; i++){
			char first = hand[i].charAt(0);
			char second = hand[i+1].charAt(0);
			char third = hand[i+2].charAt(0);
			char fourth = hand[i+3].charAt(0);
			if (first == second && first == third && first == fourth)
				return true;
		}
		return false;
	}
	public int compareTo(PokerHand other){
		if (this.score() != other.score())
			return this.score() - other.score();
		int score = this.score();
		if (score == 8){
			//solve four of a kind tie
			char charOne = this.hand[0].charAt(0);
			if (this.hand[1].charAt(0) != charOne)
				charOne = this.hand[1].charAt(0);
			char charTwo = other.hand[0].charAt(0);
			if (other.hand[1].charAt(0) != charOne)
				charOne = other.hand[1].charAt(0);
			return greaterThan(charOne, charTwo);
		}
		if (score == 7 || score == 4){
			//solve full house tie and 3 of a kind tie
			char charOne = this.hand[0].charAt(0);
			if (this.hand[1].charAt(0) != charOne)
				charOne = this.hand[1].charAt(0);
			if (this.hand[2].charAt(1) != charOne)
				charOne = this.hand[2].charAt(0);
			char charTwo = other.hand[0].charAt(0);
			if (other.hand[1].charAt(0) != charOne)
				charOne = other.hand[1].charAt(0);
			if (other.hand[2].charAt(1) != charOne)
				charOne = other.hand[2].charAt(0);
			return greaterThan(charOne, charTwo);
		}
		if (score == 5)
			//solve straight tie
			return greaterThan(this.hand[0].charAt(0), other.hand[0].charAt(0));
		if (score == 3){
			//solve 2 pairs tie
			char firstPairOne = this.hand[0].charAt(0);
			char secondPairOne = this.hand[2].charAt(0);
			char lastOne = this.hand[4].charAt(0);
			if (this.hand[1].charAt(0) != firstPairOne){
				firstPairOne = this.hand[1].charAt(0);
				secondPairOne = this.hand[3].charAt(0);
				lastOne = this.hand[0].charAt(0);
			} else if (this.hand[2].charAt(0) != this.hand[3].charAt(0)){
				secondPairOne = this.hand[3].charAt(0);
				lastOne = this.hand[2].charAt(0);
			}
			
			char firstPairTwo = other.hand[0].charAt(0);
			char secondPairTwo = other.hand[2].charAt(0);
			char lastTwo = other.hand[4].charAt(0);
			if (other.hand[1].charAt(0) != firstPairOne){
				firstPairTwo = other.hand[1].charAt(0);
				secondPairTwo = other.hand[3].charAt(0);
				lastTwo = other.hand[0].charAt(0);
			} else if (other.hand[2].charAt(0) != other.hand[3].charAt(0)){
				secondPairTwo = other.hand[3].charAt(0);
				lastTwo = other.hand[2].charAt(0);
			}
			
			if (secondPairOne != secondPairTwo)
				return greaterThan(secondPairOne, secondPairTwo);
			if (firstPairOne != firstPairTwo)
				return greaterThan(firstPairOne, firstPairTwo);
			return greaterThan(lastOne, lastTwo);
			
		}
		if (score == 2){
			//solve 1 pair tie
			int next = 1;
			char firstPair = this.hand[0].charAt(0);
			while (firstPair != this.hand[next].charAt(0)){
				firstPair = this.hand[next].charAt(0);
				next++;
			}
			char secondPair = other.hand[0].charAt(0);
			next = 1;
			while (secondPair != other.hand[next].charAt(0)){
				secondPair = other.hand[next].charAt(0);
				next++;
			}
			if (firstPair != secondPair)
				return greaterThan(firstPair, secondPair);
			
		}
		//solve high card tie
		for (int i = 4; i >= 0; i++)
			if (this.hand[i].charAt(0) != other.hand[i].charAt(0))
				return greaterThan(this.hand[i].charAt(0), other.hand[i].charAt(0));
		return 0;
	}
	
	public int greaterThan(char one, char two){
		char[] cards = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
		int indexOne = 0;
		while (one != cards[indexOne])
			indexOne++;
		int indexTwo = 0;
		while (two != cards[indexTwo])
			indexTwo++;
		return indexOne - indexTwo;
	}
}
