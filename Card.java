public class Card {
    //hearts, diamonds, clubs, spades
    private final int value;
    private final int suit;
    private final int id;
    private final String[] suitStrings = new String[] {"♥","♦","♣","♠"};
    private final String[] cardStrings = new String[] {"K","A","2","3","4","5","6","7","8","9","10","J","Q"};
    private int worth;
    public Card(int suit, int value){
        this.suit=suit;
        this.value=value;
        id = 13*suit + value+1;
        worth = getWorth();
    }
    public Card(int id){
        this.id = id;
        this.value = id%13;
        this.suit=id/13;
    }
    public int getValue(){
        return value;
    }
    public int getSuit(){
        return suit;
    }
    public int getID(){
        return id;
    }
    public final int getWorth(){
        if(value==0 || value > 9){
            worth=10;
        }else if(value ==1){
            worth = 11;
        }else{
            worth = value;
        }
        return worth;
    }
    public int reevaluate(){
        if(value == 1){
            worth = 1;
        }
        return worth;
    }

    @Override
    public String toString(){
        String out = (suit<2?"\033[0;31m\033[47m":"\033[0;30m\033[47m");
        out += cardStrings[value]+suitStrings[suit]+"\033[0m";
        return out;
    }
}