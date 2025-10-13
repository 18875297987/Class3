import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// 电子钢琴
public class piano extends Frame {
    public void start(){
        setTitle("电子钢琴");// 设置窗口标题
        setBackground(Color.BLACK); // 设置背景颜色为黑色
        setSize(1100,500); // 设置窗口的宽高
        setVisible(true);

        // 主要用于将一个 KeyListener 接口的实现类对象注册到一个组件上，以便监听该组件发生的键盘事件
        addKeyListener(new key());
    }
    @Override
    public void paint(Graphics g) {
        // 将画笔颜色修改为白色
        g.setColor(Color.WHITE);
        g.fillRect(0,0,70,350);
        g.fillRect(71,0,70,350);
        g.fillRect(142,0,70,350);
        g.fillRect(213,0,70,350);
        g.fillRect(284,0,70,350);
        g.fillRect(355,0,70,350);
        g.fillRect(426,0,70,350);
        g.fillRect(497,0,70,350);
        g.fillRect(568,0,70,350);
        g.fillRect(639,0,70,350);
        g.fillRect(710,0,70,350);
        g.fillRect(781,0,70,350);
        g.fillRect(852,0,70,350);
        g.fillRect(923,0,70,350);

        // 将画笔颜色修改色
        g.setColor(Color.BLACK);
        g.fillRect(50,0,40,300);
        g.fillRect(120,0,40,300);
        g.fillRect(265,0,40,300);
        g.fillRect(335,0,40,300);
        g.fillRect(406,0,40,300);
        g.fillRect(546,0,40,300);
        g.fillRect(616,0,40,300);
        g.fillRect(756,0,40,300);
        g.fillRect(827,0,40,300);
        g.fillRect(898,0,40,300);

    }
    public static void main(String[] args) {
        piano p = new piano();
        p.start();
    }

}
// KeyAdapter 是java中用于接受键盘事件的抽象适配器类
// 它实现了 KeyListener接口，为该接口中的所有方法提供了默认的空实现
// 通过继承 KeyAdapter类，只需要重写感兴趣的键盘事件处理方法
// 而不必实现 KeyListener接口中所有的方法了，简化了事件处理类的编写
class key extends KeyAdapter {

    // 用于处理键盘按下事件，当用户按下键盘上的某个键，该方法会自动调用
    // 参数列表中的 KeyEvent 表示键盘事件
    // 当键盘上的键按下、释放或敲击时都会生成一个KeyEvent对象，它包含了键盘事件的信息
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("用户按下了：" + e.getKeyChar() + "按键");
        if (e.getKeyChar() == 'a') new music("Music/d1.mp3").start();
        if (e.getKeyChar() == 's') new music("Music/d2.mp3").start();
        if (e.getKeyChar() == 'd') new music("Music/d3.mp3").start();
        if (e.getKeyChar() == 'f') new music("Music/d4.mp3").start();
        if (e.getKeyChar() == 'g') new music("Music/d5.mp3").start();
        if (e.getKeyChar() == 'h') new music("Music/d6.mp3").start();
        if (e.getKeyChar() == 'j') new music("Music/d7.mp3").start();
        if (e.getKeyChar() == 'q') new music("Music/h1.mp3").start();
        if (e.getKeyChar() == 'w') new music("Music/h2.mp3").start();
        if (e.getKeyChar() == 'e') new music("Music/h3.mp3").start();
        if (e.getKeyChar() == 'r') new music("Music/h4.mp3").start();
        if (e.getKeyChar() == 't') new music("Music/h5.mp3").start();
        if (e.getKeyChar() == 'y') new music("Music/h6.mp3").start();
        if (e.getKeyChar() == 'u') new music("Music/h7.mp3").start();
        if (e.getKeyChar() == '1') new music("Music/p1.mp3").start();
        if (e.getKeyChar() == '2') new music("Music/p2.mp3").start();
        if (e.getKeyChar() == '3') new music("Music/p3.mp3").start();
        if (e.getKeyChar() == '4') new music("Music/p4.mp3").start();
        if (e.getKeyChar() == '5') new music("Music/p5.mp3").start();
        if (e.getKeyChar() == '6') new music("Music/p6.mp3").start();
        if (e.getKeyChar() == '7') new music("Music/p7.mp3").start();
    }
}
