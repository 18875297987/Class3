import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Demo05 extends Frame {
    // 启动方法，能够创建窗口
    public void start(){
        setSize(1920,1080); // 设置窗口大小
        setUndecorated(true); // 移除装饰
        setVisible(true); // 设置为可见
    }
    BufferedImage img; // 图片对象，用来存放读取的图片
    public void read(){
        try {
            // 通过IO流去读取图片
            img = ImageIO.read(Demo05.class.getResourceAsStream("resource/background.png"));
        } catch (IOException e) {
            System.out.println("路径不存在，请重新输入");
            e.printStackTrace();
        }
    }
    // 创建画笔，将图片填充进窗口中
    @Override
    public void paint(Graphics g) {
        read();
        //      图片对象 x坐标 y坐标    图片宽度     图片高度       观察者（忽略，直接给null）
        g.drawImage(img,0,0,1920,1080,null);
    }

    public static void main(String[] args) {
        Demo05 demo05 = new Demo05();
        demo05.start();
    }
}
