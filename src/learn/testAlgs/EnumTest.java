package learn.testAlgs;

public class EnumTest {
    public static void main(String[] args) {
        Size size = Enum.valueOf(Size.class, "MEDIUM");
        Size size1 = Size.MEDIUM;
        System.out.println(size1.getStr());
    }
}
enum Size{
    SMALL("S"), MEDIUM("M");

    private Size(String str){this.str = str;}
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}