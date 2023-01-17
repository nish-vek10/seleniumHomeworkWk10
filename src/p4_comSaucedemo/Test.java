package p4_comSaucedemo;

public class Test {
    public static void main(String[] args) {
        String[] randUser = {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user"};
        String value = randUser[(int) Math.floor(Math.random() * randUser.length)];
        System.out.println(value);
    }
}
