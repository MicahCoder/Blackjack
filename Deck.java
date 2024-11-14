import java.util.*; 
public class Deck {
    private final ArrayList<Card> deck = new ArrayList<>();
    public Deck(){
        for(int id = 0; id<52;id++){
            deck.add(new Card(id));
        }
    }
    public Card get(int number){
        return deck.get(number);
    }
    public void shuffle(){
        Collections.shuffle(deck);
    }
    public int getLength(){
        return deck.size();
    }
    public Card remove(int number){
        Card out = deck.get(number);
        deck.remove(number);
        return out;
    }
}