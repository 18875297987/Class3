import java.awt.*;
import java.util.Random;

public class Demo02 {
    public static void main(String[] args) throws AWTException, InterruptedException {
        // 控制鼠标
        // 在Java中，Robot类位于java.awt包中
        // 它用于生成与系统相关的本机输入事件
        // 主要用于自动化测试，模拟用户操作等场景
        // 这个类可以控制鼠标和键盘的操作
        // 例如移动鼠标、点击鼠标按键、按下和释放键盘等操作
        Robot rb = new Robot();
        // 要传进去两个参数：x坐标的值，y坐标的值
        rb.mouseMove(1900,1080);
        for (int i = 0; i < 10; i++) {
            // 创建随机数对象，用于生成随机数
            Random r = new Random();
            // 取出随机数
            int x = r.nextInt(1920);// 0-1919
            int y = r.nextInt(1080);// 0-1079
            rb.mouseMove(x,y);
            // 可以让程序睡眠1秒钟，单位是毫秒，给的值是1000也就是1000毫秒，等于1秒
            Thread.sleep(1000);
        }
        int a = 0;
        for (int i = 0; i < 500; i++) {
            rb.mouseMove(a,100);
            a++;
            Thread.sleep(200);
        }
    }
}
