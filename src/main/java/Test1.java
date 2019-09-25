public class Test1 {
    private static int i = 2;
    public static int a = 3;
    public Test1(int i) {
        this.i = i;
    }

    public static class Test3 {
        public static int j = 4;
    }

    public static void test(){
        System.out.println("j");
    }
}
