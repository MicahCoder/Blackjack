import java.util.*;
public class Player {
    private final ArrayList<Card> cards = new ArrayList<>();
    private final Deck deck; 
    public Player(Deck deck){
        this.deck=deck;
    }
    public void hit(){
        cards.add(deck.remove(0));
    }
    public int handValue(){
        int out = 0;
        for(int i =0; i < cards.size();i++){
            out+= cards.get(i).getWorth();
        }
        
        for(int i = 0; i < cards.size() && out>21;i++){
                    out -= cards.get(i).getWorth();
                    out += cards.get(i).reevaluate();
        }
        return out;
    }
    @Override
    public String toString(){
        String out = "";
        for(int i =0; i < cards.size();i++){
            out+= cards.get(i).toString() + " ";
        }
        return out;
    }
    
}