import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Demo03 {
    public static void main(String[] args) {
        // Frame框架是一个带有标题栏和边框的顶层窗口，主要用于创建传统的桌面应用程序中的窗口页面
        Frame frame = new Frame("我的第一个Frame");

        // 设置背景颜色
        frame.setBackground(Color.blue); // 背景颜色设置为蓝色
        // 设置窗口的大小
        frame.setSize(1920,1080);
        // 给窗口关闭按钮添加关闭事件
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); // 添加关闭事件
            }
        });

        // 移除窗口的装饰(如：标题栏、边框、关闭按钮等)
        frame.setUndecorated(true);

        // 窗口是否显示，默认为false不显示
        frame.setVisible(true);

    }
}
