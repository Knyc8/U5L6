import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String username = scan.nextLine();

        CreditCard card1 = new CreditCard(username, generatePin());
        Bank bank = new Bank();
        BagelShop bagelShop = new BagelShop(username + "'s Bagel Shop", 1000, 11, bank);
        BankApp app = new BankApp(card1, bank, bagelShop);

        System.out.print(app);
        String event = scan.nextLine();
        while (!event.equalsIgnoreCase("4") && !event.equalsIgnoreCase("5") && !event.equalsIgnoreCase("l")) {
            event = scan.nextLine();
        }
        while (!event.equalsIgnoreCase("l")) {
            System.out.println(app.action(event));
            event = scan.nextLine();
        }
    }

    public static String generatePin(){
        String pinNum = "";
        for (int i = 0; i < 4; i++)
        {
            pinNum += Integer.toString((int)(Math.random()*10));
        }
        return pinNum;
    }
}
