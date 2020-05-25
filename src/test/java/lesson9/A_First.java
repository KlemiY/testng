package test.java.lesson9;

public class A_First {
    public static void main(String[] args) {
        String tel = "+38(050) asdasd1-135-45 45";
        String res = tel
                .replace("+", "")
                .replace("(", "")
                .replace(")", "")
                .replace(" ", "")
                .replace("-", "");
        String res2 = tel.replaceAll("[^0-9]", "");
        System.out.println(res);
        System.out.println(res2);
    }
}
