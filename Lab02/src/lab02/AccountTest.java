public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account();
        Account account2 = new Account(200);
        System.out.println("account1: " + account1.dollars);
        System.out.println("account2: " + account2.dollars);
    }
}
