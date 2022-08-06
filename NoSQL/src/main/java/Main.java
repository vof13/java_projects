public class Main {

    public static void main(String[] args)  {

        RedisStorage redis = new RedisStorage();
        redis.init();
        for (int i = 1; i <= 20; i++) {
            redis.addUsers(i);
        }

        while (true) {
            redis.printAllUsers();
        }
    }
}
