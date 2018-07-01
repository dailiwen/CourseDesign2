package version1;

import javax.swing.*;
import java.awt.*;

/**
 * create on 2018/04/14
 * <p>
 * 登录的UI页面
 */
public class LoginUI extends JFrame {
    public LoginUI() {
        // 登陆界面框架的基础设置
        setTitle("Login");
        setBounds(900, 400, 500, 400);
        Container container = getContentPane();//获取一个容器
        container.setLayout(new GridLayout(2, 1, 0, 0));

        // 登录页面的模块的面板设计
        JPanel containerTop = new JPanel();//登录页面的上半部分
        JPanel containerBottom = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));//登录页面的下半部分
        JPanel containerBottomLeft = new JPanel();//登录页面下半部分的左边部分
        JPanel containerBottomCenter = new JPanel(new GridLayout(4, 2, 10, 0));//登录页面下半部分的中间部分
        containerBottom.add(containerBottomLeft);
        containerBottom.add(containerBottomCenter);
        container.add(containerTop);
        container.add(containerBottom);

        // 登录页面上办部分的样式设计
        containerTop.setBackground(Color.BLUE);

        //登录页面的下半部分的左边部分的设计
        containerBottomLeft.setBackground(Color.GRAY);

        //登录页面的下半部分的中间部分的设计
        JTextField username = new JTextField();
        JTextField password = new JTextField();
        Checkbox rememberPassword = new Checkbox();
        Checkbox autoLogin = new Checkbox();
        Label registAccountText = new Label("注册账号");
        Label findPasswordText = new Label("找回密码");
        Label rememberPasswordText = new Label("记住密码");
        Label autoLoginText = new Label("自动登录");
        JButton btLogin = new JButton("登录");
        JPanel jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jpanel.add(rememberPassword);// 将这些节点放入容器中
        jpanel.add(rememberPasswordText);
        jpanel.add(autoLogin);
        jpanel.add(autoLoginText);
        containerBottomCenter.add(username);
        containerBottomCenter.add(registAccountText);
        containerBottomCenter.add(password);
        containerBottomCenter.add(findPasswordText);
        containerBottomCenter.add(jpanel);
        containerBottomCenter.add(new Label());
        containerBottomCenter.add(btLogin);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new LoginUI();
    }
}
