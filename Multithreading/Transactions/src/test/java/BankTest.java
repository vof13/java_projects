import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

public class BankTest extends TestCase {
    Bank bank = new Bank();

    @Override
    protected void setUp() {
        Account account1 = new Account("09BY123456", 1000);
        bank.add(account1);
        Account account2 = new Account("11BY654321", 0);
        bank.add(account2);
        Account account3 = new Account("13BY654321", 500);
        bank.add(account3);

    }

    @DisplayName("Тест перевода денег")
    public void testTransfer () throws InterruptedException {
        bank.transfer("09BY123456", "11BY654321" , 500);
        long expected =500;
        long actual = bank.getBalance("11BY654321");
        assertEquals(expected, actual);
        actual = bank.getBalance("09BY123456");
        assertEquals(expected, actual);
    }

    @DisplayName("Тест блокировки аккаунта")
    public void testBlockAccount () throws InterruptedException {
        bank.getAccounts().get("11BY654321").setBlock(true);
        bank.transfer("09BY123456", "11BY654321" , 500);
    }

    @DisplayName("Тест получения суммы всех балансов")
    public void testSumAllAccounts() {
        long expected = 1500;
        long actual = bank.getSumAllAccounts();
        assertEquals(expected, actual);
    }

    @DisplayName("Запуск многопоточности")
    public void testMultiThread (){
        ArrayList <Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(() -> {
                try {
                    bank.transfer("13BY654321", "11BY654321", 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }
        threads.forEach(Thread::run);

        long expectedFromAccount = 400;
        long expectedToAccount = 100;
        long actualFromAccount = bank.getBalance("13BY654321");
        long actualToAccount = bank.getBalance("11BY654321");
        assertEquals(expectedFromAccount, actualFromAccount);
        assertEquals(expectedToAccount, actualToAccount);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
