public class BankApp {
    private CreditCard card1;
    private CreditCard card2;
    private Bank bank;
    private BagelShop bagelShop;
    private String buyCard;
    private String returnCard;
    public BankApp(CreditCard card, Bank bank, BagelShop bagelShop)
    {
        this.card1 = card;
        this.bank = bank;
        this.bagelShop = bagelShop;
        buyCard = "";
        returnCard = "";
    }

    public void purchaseBagel(int quantity)
    {
        if (CreditCard.numOfCards == 1)
        {
            System.out.println("Purchase Successful: " + bagelShop.payForBagels(card1, quantity, card1.getPin()));
        }
        else if (buyCard.equalsIgnoreCase(""))
        {
            System.out.println("Please set a card for purchases and returns");
        }
        else {
            if (buyCard.equalsIgnoreCase("1")) {
                System.out.println("Purchase Successful: " + bagelShop.payForBagels(card1, quantity, card1.getPin()));
            }
            else
            {
                System.out.println("Purchase Successful: " + bagelShop.payForBagels(card2, quantity, card2.getPin()));
            }
        }
    }

    public void returnBagel(int quantity)
    {
        if (CreditCard.numOfCards == 1)
        {
            System.out.println("Return Successful: " + bagelShop.returnBagels(card1, quantity, card1.getPin()));
        }
        else if (returnCard.equalsIgnoreCase(""))
        {
            System.out.println("Please set a card for purchases and returns");
        }
        else {
            if (returnCard.equalsIgnoreCase("1")) {
                System.out.println("Return Successful: " + bagelShop.returnBagels(card1, quantity, card1.getPin()));
            }
            else
            {
                System.out.println("Return Successful: " + bagelShop.returnBagels(card2, quantity, card2.getPin()));
            }
        }
    }
    public void openCard(String pin)
    {
        card2 = new CreditCard(card1.getAccountHolder(), pin);
        buyCard = "";
        returnCard = "";
    }

    public CreditCard getCard1()
    {
        return card1;
    }

    public CreditCard getCard2()
    {
        return card2;
    }

    public void selectCards(String buyCard, String returnCard)
    {
        this.buyCard = buyCard;
        this.returnCard = returnCard;
    }

    public String compareCreditCards()
    {
        if (card1.getBalanceOwed() == card2.getBalanceOwed())
        {
            return "none";
        }
        if (card1.getBalanceOwed() < card2.getBalanceOwed())
        {
            return card1.getPin();
        }
        else
        {
            return card2.getPin();
        }
    }

    public void depositProfits()
    {
        bagelShop.depositProfits();
    }

    public String toString()
    {
        return """
                ------------------------------------------
                What would you like to do? (Return a num)
                Bagel Shop:
                1. Purchase a bagel
                2. Return a bagel
                3. Check business
                
                Bank:
                4. Check credit card info
                5. Open a new credit card
                6. Compare credit card balances
                7. Deposit profits
                8. Select purchase and return cards
                
                Type (l) to leave
                ------------------------------------------
                """;
    }
}
