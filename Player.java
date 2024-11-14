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
    private int worthNeeded(){
        return 21-handValue();
    }
    public double getOddsOfWin(){
        int count = 0;
        int needed = worthNeeded();
        if(needed == 1){
            for(int i = 0; i<deck.getLength();i++){
                if(deck.get(i).getWorth() == 11){
                    count++;
                }
            }
        }else{
            for(int i = 0; i<deck.getLength();i++){
                if(deck.get(i).getWorth() == needed){
                    count++;
                }
            }
        }
        System.out.println("Card needed for blackjack is " + (new Card(needed)).toString());
        return (double)count/(double)deck.getLength()*100.0;
    }
    public double getOddsOfBust(){
        int count = 0;
        int needed = worthNeeded();
        if(needed == 1){
            for(int i = 0; i<deck.getLength();i++){
                if(deck.get(i).getWorth() != 11){
                    count++;
                }
            }
        }else if(needed == 0){
            return 100.0;
        }
        else{
            for(int i = 0; i<deck.getLength();i++){
                if(deck.get(i).getWorth() > needed && deck.get(i).getWorth()!=11){
                    count++;
                }
            }
        }
        return (double)count/(double)deck.getLength()*100.0;
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