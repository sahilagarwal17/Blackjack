import java.util.Scanner;
public class Blackjack {

    // Methods for the game
    // Method for creating the menu of the game
    public static void menu() {
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");
        System.out.println("Choose an option: ");
    }

    // Method for converting random numbers to card values
    public static int cardValue(int randomcard) {
        int temp = 0;
        switch(randomcard) {
            case 11 :
                temp = 10;
                break;
            case 12:
                temp = 10;
                break;
            case 13 :
                temp = 10;
                break;
            default:
                temp = randomcard;
                break;
        }
        return temp;

    }

    // Method for converting random numbers to card names
    public static String cardType(int randomcard) {
        String temp = "0" ;
        switch(randomcard) {
            case 1 :
                temp = "ACE";
                break;
            case 11 :
                temp = "JACK";
                break;
            case 12:
                temp = "QUEEN";
                break;
            case 13 :
                temp = "KING";
                break;
            default:
                temp = String.valueOf(randomcard);
                break;
        }
        return temp;
    }


    // Main game code
    public static void main(String[] args){

       // objects for the game play
        int gameNumber = 0;
        int wins = 0;
        int ties = 0;
        int dwins = 0;
        String menuSelection = "1";
        int randomCard = 0;
        int hand = 0;
        P1Random rng = new P1Random();
        Scanner scnr = new Scanner(System.in);


        // Main game loop
        while (!(menuSelection.equals("4"))) {
            gameNumber += 1;
            System.out.println("START GAME #" + gameNumber);  // Game counter plus telling you what game it is
            hand = 0;
            while (!(menuSelection.equals("4"))) {

                if (menuSelection.equals("1")) {  // when menu selection is 1
                    randomCard = rng.nextInt(13) + 1;
                    System.out.println("Your card is a " + cardType(randomCard) + "!");
                    hand = hand + cardValue(randomCard);
                    System.out.println("Your hand is: " + hand);
                    if (hand > 21) {
                        System.out.println("You exceeded 21! You lose.");
                        dwins += 1;
                        hand = 0;
                        menuSelection = "1";
                        break;
                    }
                    else if (hand == 21) {
                        System.out.println("BLACKJACK! You win!");
                        wins += 1;
                        hand = 0;
                        menuSelection = "1";
                        break;
                    }
                    menu();
                    menuSelection = scnr.next();
                }

                if (menuSelection.equals("2")) { // when menu selection is 2, each if block is a different win/lose/tie situation
                    int dealerHand = rng.nextInt(11) + 16;
                    if (dealerHand > 21) {
                        System.out.println("Dealer's hand: " + dealerHand);
                        System.out.println("Your hand is: " + hand);
                        System.out.println("You win!");
                        wins += 1;
                        menuSelection = "1";
                        break;
                    } else if (dealerHand > hand) {
                        System.out.println("Dealer's hand: " + dealerHand);
                        System.out.println("Your hand is: " + hand);
                        System.out.println("Dealer wins!");
                        dwins += 1;
                        menuSelection = "1";
                        break;
                    } else if (hand > dealerHand) {
                        System.out.println("Dealer's hand: " + dealerHand);
                        System.out.println("Your hand is: " + hand);
                        System.out.println("You win!");
                        wins += 1;
                        menuSelection = "1";
                        break;
                    } else {
                        System.out.println("Dealer's hand: " + dealerHand);
                        System.out.println("Your hand is: " + hand);
                        System.out.println("It's a tie! No one wins!");
                        ties += 1;
                        menuSelection = "1";
                        break;
                    }


                } else if (menuSelection.equals("3")) { // when selection is 3
                    System.out.println("Number of Player wins:" + wins);
                    System.out.println("Number of Dealer wins:" + dwins);
                    System.out.println("Number of tie games: " + ties);
                    System.out.println("Total # of games played is: " + (gameNumber - 1) );
                    System.out.println("Percentage of Player wins: " + (((float)wins / ((float)gameNumber - 1.0))*100.0) + "%");
                    menu();
                    menuSelection = scnr.next();

                } else if (!(menuSelection.equals("4"))) {
                    while (!(menuSelection.equals("3") || menuSelection.equals("1") || menuSelection.equals("2") || menuSelection.equals("4"))) {
                        System.out.println("Invalid input!");
                        System.out.println("Please enter an integer value between 1 and 4.");
                        menu();
                        menuSelection = scnr.next();
                    }
                }


            }
        }





    }

}
