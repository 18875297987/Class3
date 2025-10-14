import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class YouLing extends Frame {
    // 图片对象
    BufferedImage img;
    // 图片的路径
    String path;
    // 构造方法，用来给图片路径赋值
    public YouLing(String path){
        this.path = path;
    }
    // 启动方法，能够创建窗口
    public void start(){
        setSize(1920,1080); // 设置窗口大小
        setUndecorated(true); // 移除装饰
        setVisible(true); // 窗口设置为可见
    }
    public void read(){
        try {
            img = ImageIO.read(YouLing.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 创建画笔，将图片填入窗口
    @Override
    public void paint(Graphics g) {
        read();
        g.drawImage(img,0,0,1920,1080,null);
    }

    public static void main(String[] args) throws InterruptedException, AWTException {
        new music("resource/BBQ.mp3").start();
        Robot rb = new Robot();
        for (int i = 0; i < 50; i++) {
            // 让程序休眠0.5秒
            Thread.sleep(500);
            YouLing y1 = new YouLing("resource/BBQ.png");
            y1.start();

            Thread.sleep(500);// 让程序休眠0.5秒
            YouLing y2 = new YouLing("resource/BBQ2.png");
            y2.start();

            Random r  = new Random();// 创建随机数对象
            // 取出随机数
            int x = r.nextInt(1920);
            int y = r.nextInt(1080);
            rb.mouseMove(x,y);

        }
    }
}

class music extends Thread {
    // 音频的路径
    String path;
    public music(String path) {
        this.path = path;
    }
    @Override
    public void run() {
        try {
            // 读取音频文件，获取音频对象
            AdvancedPlayer adv = new AdvancedPlayer(music.class.getResourceAsStream(path));
            // 播放音乐
            adv.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }

    }
}
