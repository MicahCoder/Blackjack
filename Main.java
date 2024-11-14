import java.util.Scanner;
public class Main{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        play(input);
        System.out.println("Quit(q) or play again?");
        while(!input.nextLine().equals("q")){
            play(input);
            System.out.println("Quit(q) or play again?");
        }
    }
    public static void play(Scanner input){
        Deck deck = new Deck();
        Player player1 = new Player(deck);
        Player dealer = new Player(deck);
        deck.shuffle();
        player1.hit();
        player1.hit();
        dealer.hit();
        dealer.hit();
        while(true){
            boolean playerHit = false;
            boolean dealerHit = false;
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Dealer: " +dealer+" ");
            System.out.println("Hit(h) or Stay(s)?");
            System.out.println("Player: " +player1+" ");
            if(input.nextLine().equals("h")){
                player1.hit();
                playerHit = true;
            }
            if(player1.handValue()>21){
                break;
            }
            if(dealer.handValue()<17){
                dealer.hit();
                dealerHit = true;
            }
            if(dealer.handValue()>21){
                break;
            }
            if(!dealerHit && !playerHit){
                break;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Dealer: " +dealer);
        System.out.println("Player: " +player1);
        if(player1.handValue()>21){
            System.out.println("Player busted, Dealer wins!");
        }else if(dealer.handValue()>21){
            System.out.println("Dealer busted, Player wins!");
        }else if(player1.handValue()>dealer.handValue()){
            System.out.println("Player wins!");
        }else if(player1.handValue()<dealer.handValue()){
            System.out.println("Dealer wins!");
        }else{
            System.out.println("Tie");
        }
    }
}