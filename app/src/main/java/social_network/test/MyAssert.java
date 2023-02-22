package social_network.test;

public class MyAssert {
    public static void asserto(boolean ceva) {
        if (!ceva) {
            throw new AssertionError();
        }
    }
}
