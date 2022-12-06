public class BankApp {
    private CreditCard card;
    private Bank bank;
    private BagelShop bagelShop;
    public BankApp(CreditCard card, Bank bank, BagelShop bagelShop)
    {
        this.card = card;
        this.bank = bank;
        this.bagelShop = bagelShop;
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
                ------------------------------------------
                """;
    }
}
