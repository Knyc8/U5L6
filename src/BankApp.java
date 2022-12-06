public class BankApp {
    private CreditCard card1;
    private CreditCard card2;
    private Bank bank;
    private BagelShop bagelShop;
    private int numOfCards;
    public BankApp(CreditCard card, Bank bank, BagelShop bagelShop)
    {
        this.card1 = card;
        this.bank = bank;
        this.bagelShop = bagelShop;
        numOfCards = 1;
    }

    public void openCard()
    {
        numOfCards++;
        card2 = new CreditCard(card1.getAccountHolder(), Main.generatePin());
    }

    public String action(String event)
    {
        if (event.equals("4"))
        {
            if (numOfCards > 1) return card1.toString() + "\n\n" + card2.toString();
            return card1.toString();
        }
        if (event.equals("5"))
        {
            openCard();
            return "Successfully created a new card!";
        }
        if (event.equalsIgnoreCase("l"))
        {
            return "You left the app!";
        }
        return "Nothing Happened!";
    }

    public String toString()
    {
        return """
                ------------------------------------------
                What would you like to do? (Return a num)
                Bagel Shop:
                1. Purchase a bagel
                2. Return a bagel
                3. Check inventory
                
                Bank:
                4. Check credit card info
                5. Open a new credit card
                6. Compare credit card balances
                7. Deposit profits
                
                Type (l) to leave
                ------------------------------------------
                """;
    }
}
