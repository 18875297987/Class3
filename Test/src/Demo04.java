import java.awt.*;

public class Demo04 {
    public static void main(String[] args) throws InterruptedException {
        Color[] colors = {
                Color.GREEN,
                Color.BLACK,
                Color.GRAY,
                Color.BLUE,
                Color.RED,
                Color.WHITE,
                Color.PINK,
                Color.ORANGE
        };

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < colors.length; j++) {
                Frame frame = new Frame();
                frame.setSize(1920, 1080); // 设置窗口的大小
                frame.setUndecorated(true); // 移除窗口的装饰
                frame.setBackground(colors[j]); // 设置窗口的背景颜色
                frame.setVisible(true); // 设置窗口的可见性
//                Thread.sleep(200); // 让程序休眠0.2秒
            }
        }

    }
}
