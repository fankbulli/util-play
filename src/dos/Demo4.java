package dos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo4 {
    public static void main(String[] args) {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("Login Example");
        // Setting the width and height of frame
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        // 创建 JLabel
        JLabel userLabel = new JLabel("原视频名:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        userLabel.setBounds(150,100,100,25);
        panel.add(userLabel);

        /*
         * 创建文本域用于用户输入
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(250,100,250,25);
        panel.add(userText);

        // 输入密码的文本域
        JLabel passwordLabel = new JLabel("新视频名:");
        passwordLabel.setBounds(150,200,100,25);
        panel.add(passwordLabel);

        /*
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        JTextField passwordText = new JTextField(20);
        passwordText.setBounds(250,200,250,25);
        panel.add(passwordText);

        JLabel fen=new JLabel ("分辨率:");
        fen.setBounds (150,300,100,25);
        panel.add (fen);

        JTextField field=new JTextField (20);
        field.setBounds (250,300,250,25);
        panel.add (field);

        // 创建登录按钮
        JButton loginButton = new JButton("确认");
        loginButton.setBounds(300, 400, 80, 25);
        panel.add(loginButton);
        loginButton.addActionListener (new AbstractAction () {
            @Override
            public void actionPerformed(ActionEvent e) {
                String old=userText.getText ();
                String news=passwordText.getText ();
                String fenb=field.getText ();
                System.out.println (old+"\n"+news+"\n"+fenb);
                if(old==null||news==null||fenb==null){
                    new TDialog ();
                    return;
                }
                //ffmpeg -i input.mp4 scale=1080:1920 output.mp4
                BufferedReader br=null;
                try {
                    Process p=Runtime.getRuntime ().exec ("ffmpeg -i C:\\Users\\zxd\\"+old+" scale="+fenb+" C:\\Users\\zxd\\"+news);
//                    Process p=Runtime.getRuntime ().exec ("ffmpeg -i C:\\Users\\zxd\\"+old+" -vframes 30 -y -f gif C:\\Users\\zxd\\"+news);
                    br=new BufferedReader (new InputStreamReader (p.getInputStream ()));
                    String line=null;
                    StringBuilder sb=new StringBuilder ();
                    while ((line=br.readLine ())!=null){
                        sb.append (line+"\n");
                    }
                    System.out.println (sb.toString ());
                } catch (IOException e1) {
                    e1.printStackTrace ();
                }finally {
                    if (br!=null){
                        try {
                            br.close ();
                        } catch (IOException e1) {
                            e1.printStackTrace ();
                        }
                    }
                }
            }
        });
    }
}
class TDialog extends JDialog {        // 继承JDialog类

    public TDialog() {
        super(new MyJFrame(), "Error", true); // 实例化一个JDialog类对象，指定其父窗体、窗口标题和类型
        Container container = this.getContentPane();
        container.add(new JLabel("请认真填写"));
        this.setSize(500, 350);
    }

}