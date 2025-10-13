import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        // 打开计算器
        Runtime.getRuntime().exec("calc");
        // 打印提示语
        System.out.println("成功打开计算器！");
    }
}
