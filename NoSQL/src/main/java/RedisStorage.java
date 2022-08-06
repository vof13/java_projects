import org.redisson.Redisson;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;

import java.util.Random;

public class RedisStorage {

    private RedissonClient redisson;
    private RList<String> onlineUsers;
    private final static String KEY = "ONLINE_USERS";
    Boolean isCountTen = true;

    void init() {
        try {
            redisson = Redisson.create();
        } catch (Exception e) {
            System.out.println("Cannot connect to Redis");
            e.printStackTrace();
        }
        onlineUsers = redisson.getList(KEY);
        onlineUsers.delete();
    }

    public void addUsers(int i) {
        onlineUsers.add(String.valueOf(i));
    }

    public void printAllUsers() {
        for (int i = 0; i < onlineUsers.size(); i++) {
            System.out.println("On main page show user: " + onlineUsers.get(i));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (isCountTen && isUserBuyingPremium()) {
                int premiumUserPosition = new Random().nextInt(20);
                String premiumUser = onlineUsers.get(premiumUserPosition);
                onlineUsers.remove(premiumUserPosition);
                System.out.println("User " + premiumUser + " buy premium.");
                onlineUsers.addAfter(onlineUsers.get(i), premiumUser);
            }

            if (i%10 == 0 && i !=0) {
                isCountTen = true;
            }
        }
    }

    private boolean isUserBuyingPremium() {
        if (Math.random() > 0.5) {
            isCountTen = false;
            return true;
        }
        return false;
    }


    void shutDown() {
        redisson.shutdown();
    }


}
