import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String username = scan.nextLine();
        System.out.print("Enter a pin: ");
        String pin = scan.nextLine();
        while(pin.length() != 4)
        {
            System.out.print("Enter a 4-digit pin: ");
            pin = scan.nextLine();
        }

        CreditCard card1 = new CreditCard(username, pin);
        Bank bank = new Bank();

        System.out.println("What would you like to name your shop?");
        String shopName = scan.nextLine();
        System.out.println("How many bagels does your store have in stock?");
        int inventory = Integer.parseInt(scan.nextLine());
        System.out.println("What would you like to sell your bagels for? (Enter an integer)");
        int price = Integer.parseInt(scan.nextLine());
        BagelShop bagelShop = new BagelShop(shopName, inventory, price, bank);
        BankApp app = new BankApp(card1, bank, bagelShop);

        System.out.print(app);
        String event = scan.nextLine();
        if (!event.equalsIgnoreCase("1") && !event.equalsIgnoreCase("2") && !event.equalsIgnoreCase("3") && !event.equalsIgnoreCase("4") && !event.equalsIgnoreCase("5") && !event.equalsIgnoreCase("6") && !event.equalsIgnoreCase("7") && !event.equalsIgnoreCase("8") && !event.equalsIgnoreCase("l"))
        {
            System.out.println("Nothing Happened!");
        }
        while (!event.equalsIgnoreCase("1") && !event.equalsIgnoreCase("2") && !event.equalsIgnoreCase("3") && !event.equalsIgnoreCase("4") && !event.equalsIgnoreCase("5") && !event.equalsIgnoreCase("6") && !event.equalsIgnoreCase("7") && !event.equalsIgnoreCase("8") && !event.equalsIgnoreCase("l")) {
            event = scan.nextLine();
            System.out.println("Nothing Happened!");
        }

        while (!event.equalsIgnoreCase("l")) {
            if (event.equalsIgnoreCase("1"))
            {
                System.out.println("How many bagels would you like to buy?");
                int quantity = Integer.parseInt(scan.nextLine());
                app.purchaseBagel(quantity);
            }
            if (event.equalsIgnoreCase("2"))
            {
                System.out.println("How many bagels would you like to return?");
                int quantity = Integer.parseInt(scan.nextLine());
                if (BagelShop.bagelBought < quantity)
                {
                    System.out.println("Please buy more bagels first");
                }
                else {
                    app.returnBagel(quantity);
                }
            }
            else if (event.equalsIgnoreCase("3"))
            {
                System.out.println(bagelShop);
            }
            else if (event.equals("4"))
            {
                if (CreditCard.numOfCards > 1)
                {
                    System.out.print("Enter the pin number of the card you want to view: ");
                    String whichCard = scan.nextLine();
                    while (app.getCard1().checkPIN(whichCard) && app.getCard2().checkPIN(whichCard))
                    {
                        System.out.println("A card does not exist with this pin: ");
                        whichCard = scan.nextLine();
                    }
                    System.out.println(app.getCard2().toString());
                }
                else {
                    System.out.println(app.getCard1().toString());
                }
            }
            else if (event.equals("5"))
            {
                System.out.print("Enter a new pin: ");
                pin = scan.nextLine();
                while(pin.length() != 4)
                {
                    System.out.print("Enter a 4-digit pin: ");
                    pin = scan.nextLine();
                }
                while (card1.checkPIN(pin)) {
                    System.out.print("Your new pin cannot be the same: ");
                    pin = scan.nextLine();
                    while(pin.length() != 4)
                    {
                        System.out.print("Enter a 4-digit pin: ");
                        pin = scan.nextLine();
                    }
                }
                app.openCard(pin);
                System.out.println("Successfully created a new card!");
            }
            else if (event.equalsIgnoreCase("6"))
            {
                if (CreditCard.numOfCards > 1)
                {
                    if (app.compareCreditCards().equalsIgnoreCase("none"))
                    {
                        System.out.println("Both cards have the same balance.");
                    }
                    else {
                        System.out.println("Card: " + app.compareCreditCards() + " has a higher balance.");
                    }
                }
                else
                {
                    System.out.println("You only have one card!");
                }
            }
            else if (event.equalsIgnoreCase("7"))
            {
                if (bagelShop.getProfit() == 0)
                {
                    System.out.println("Your shop has no profits!");
                }
                else {
                    app.depositProfits();
                }
            }
            else if (event.equalsIgnoreCase("8"))
            {
                if (CreditCard.numOfCards > 1) {
                    System.out.println("Which card would you like to use for payment? (Enter 1 or 2)");
                    String buyCard = scan.nextLine();
                    System.out.println("Which card would you like to use for returning? (Enter 1 or 2)");
                    String returnCard = scan.nextLine();

                    while ((!buyCard.equalsIgnoreCase("1") && !buyCard.equalsIgnoreCase("2")) || (!returnCard.equalsIgnoreCase("1") && !returnCard.equalsIgnoreCase("2"))) {
                        System.out.println("Which card would you like to use for payment? (Enter 1 or 2)");
                        buyCard = scan.nextLine();
                        System.out.println("Which card would you like to use for returning? (Enter 1 or 2)");
                        returnCard = scan.nextLine();
                    }
                    app.selectCards(buyCard, returnCard);
                    System.out.println("Selection complete!");
                }
                else
                {
                    System.out.println("You need to open up a second card!");
                }
            }
            event = scan.nextLine();
        }
        System.out.println("You left the app!");
    }
}
