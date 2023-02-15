package com.gtc.ui;

import com.gtc.controller.AccountController;
import com.gtc.entity.Account;
import com.mysql.cj.util.StringUtils;

import javax.swing.*;

import java.awt.*;

public class SYSUI {

   static boolean flag = true;
   static boolean flag1 = true;
   static boolean flag2 = true;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SYSUI::BaseUI);
    }

    public static void BaseUI() {
        JFrame jFrame = new JFrame("GTC 用户管理系统");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        LoginUI(jFrame,jPanel);
        jFrame.add(jPanel);

    }

    public static void LoginUI(JFrame jFrame,JPanel jPanel) {
        jFrame.setBounds(600,400,400,250);
        JLabel jLabel = new JLabel("用户名：");
        jLabel.setBounds(100,60,50,20);
        JTextField field = new JTextField(15);
        field.setBounds(160,60,150,20);
        JLabel jLabel1 = new JLabel("密   码：");
        jLabel1.setBounds(100,120,50,20);
        JPasswordField passfield = new JPasswordField(15);
        passfield.setBounds(160,120,150,20);
        JButton button1 = new JButton("登录");
        button1.setBounds(120,180,70,30);
        JButton button2 = new JButton("注册");
        button2.setBounds(220,180,70,30);
        ImageIcon icon = new ImageIcon("src/main/resources/img/logo.png");
        icon.setImage(icon.getImage().getScaledInstance(151,42, Image.SCALE_DEFAULT));
        JLabel jLabel2 = new JLabel();
        jLabel2.setIcon(icon);
//        System.out.println(icon.getImage().getScaledInstance(151,42, Image.SCALE_DEFAULT));
        jLabel2.setBounds(110,0,170,50);

        jPanel.add(jLabel);
        jPanel.add(jLabel1);
        jPanel.add(jLabel2);
        jPanel.add(field);
        jPanel.add(passfield);
        jPanel.add(button1);
        jPanel.add(button2);

        button1.addActionListener(e -> {
             String name = field.getText();
             String pass = new String(passfield.getPassword());
            System.err.println(name);
            System.err.println(pass);
            final AccountController controller = new AccountController();
            if (flag1) {
                if (StringUtils.isNullOrEmpty(name) || StringUtils.isNullOrEmpty(pass)) {
                    System.out.println("ERROR...");
                    info_UI(jFrame,"请输入账号或密码！");
                } else if (controller.login(name,pass)) {
                    System.out.println("SUCCESS...");
                    flag1 = false;
                    HomeUI(name);
                }else {
                    System.out.println("Failed...");
                    info_UI(jFrame,"账号或密码错误！");
                }
            }
        });
        button2.addActionListener(e-> register_UI());
    }

    public static void HomeUI(String username) {
         JFrame frame = new JFrame("欢迎您 " + username);
         frame.setBounds(600,300,600,400);
         frame.setVisible(true);
         frame.setResizable(false);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon("src/main/resources/img/banner1.jpg");
         JLabel jab = new JLabel(imageIcon);
         jab.setBounds(20,10,imageIcon.getIconWidth(),imageIcon.getIconHeight());
        JButton butn = new JButton("转账");
        butn.setBounds(50,300,120,20);
         frame.getLayeredPane().add(jab, Integer.valueOf(Integer.MIN_VALUE));
         JPanel p = (JPanel) frame.getContentPane();
         p.setOpaque(false);
         p.setLayout(null);
         p.add(butn);
         butn.addActionListener(e -> trans_UI());
    }

    public static void info_UI(JFrame frame,String info){

        JDialog dialog = new JDialog(frame, "友情提示", true);
        dialog.setBounds(650,300,300,200);
        dialog.setDefaultCloseOperation(dialog.HIDE_ON_CLOSE);


        JLabel msg_lab = new JLabel(info);
         Font font = new Font("楷体", Font.BOLD, 20);
         msg_lab.setFont(font);

        JPanel p2 = new JPanel();

        p2.add(msg_lab);
        dialog.add(p2);
        dialog.setVisible(true);
    }

    public static void register_UI() {
         JFrame jfd = new JFrame("新用户注册");
         jfd.setVisible(true);
         jfd.setResizable(false);
         jfd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         jfd.setBounds(600,300,400,400);

        final JLabel na = new JLabel("用户名： ");
        final JTextField na_f = new JTextField(15);

        final JLabel pa = new JLabel("密码： ");
        final JPasswordField pa_f = new JPasswordField(15);

        final JLabel n = new JLabel("姓名： ");
        final JTextField n_f = new JTextField(15);

        final JLabel sn = new JLabel("性别： ");
        final JRadioButton mb = new JRadioButton("男");
        final JRadioButton wb = new JRadioButton("女");
        mb.setSelected(true);
        final ButtonGroup group = new ButtonGroup();

        final JLabel ia = new JLabel("身份证号：");
        final JTextField ia_f = new JTextField(15);

        final JLabel ea = new JLabel("电子邮箱：");
        final JTextField ea_f = new JTextField(15);

        final JLabel ta = new JLabel("手机号： ");
        final JTextField ta_f = new JTextField(15);

        final JButton rbu = new JButton("注册");
        final JButton cbu = new JButton("重置");

        final JPanel cpl = new JPanel();
        cpl.setLayout(null);

        na.setBounds(50,20,60,20);
        pa.setBounds(50,60,60,20);
        n.setBounds(50,100,60,20);
        sn.setBounds(50,140,60,20);
        ia.setBounds(50,180,60,20);
        ea.setBounds(50,220,60,20);
        ta.setBounds(50,260,60,20);

        na_f.setBounds(120,20,120,20);
        pa_f.setBounds(120,60,120,20);
        n_f.setBounds(120,100,120,20);
        mb.setBounds(120,140,100,20);
        wb.setBounds(220,140,120,20);
        ia_f.setBounds(120,180,120,20);
        ea_f.setBounds(120,220,120,20);
        ta_f.setBounds(120,260,120,20);
        rbu.setBounds(50,300,120,20);
        cbu.setBounds(220,300,120,20);


        group.add(mb);
        group.add(wb);

        cpl.add(na);
        cpl.add(na_f);
        cpl.add(pa);
        cpl.add(pa_f);
        cpl.add(n);
        cpl.add(n_f);
        cpl.add(sn);
        cpl.add(wb);
        cpl.add(mb);
        cpl.add(ia);
        cpl.add(ia_f);
        cpl.add(ea);
        cpl.add(ea_f);
        cpl.add(ta_f);
        cpl.add(ta);
        cpl.add(rbu);
        cpl.add(cbu);

        jfd.add(cpl);


        rbu.addActionListener(e -> {
            final String na_fText = na_f.getText();
            final String pass = new String(pa_f.getPassword());
            final String n_fText = n_f.getText();
            final String ia_fText = ia_f.getText();
            final String ea_fText = ea_f.getText();
            final String ta_fText = ta_f.getText();
            String sex = "";
            if (mb.isSelected()){
                sex = "男";
            } else {
                sex = "女";
            }

            if (flag) {
                if (StringUtils.isNullOrEmpty(na_fText) || StringUtils.isNullOrEmpty(pass)) {
                    info_UI(jfd,"请输入账号或密码！");
                } else {
                    final boolean register = new AccountController().register(new Account(null, na_fText, pass, n_fText, sex, ia_fText, ea_fText, ta_fText, null, null, null, null, null));
                    if (register) {
                        info_UI(jfd,"注册成功！");
                        flag = false;
                    }else {
                        info_UI(jfd,"注册失败！");
                    }
                }
            }
        });

    }

    public static void trans_UI() {
        JFrame jfd = new JFrame("转账");
        jfd.setVisible(true);
        jfd.setResizable(false);
        jfd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfd.setBounds(600,300,400,400);

        final JLabel h = new JLabel("用户ID(发送)： ");
        final JTextField id_1 = new JTextField(15);

        final JLabel h1 = new JLabel("用户ID(接收)： ");
        final JTextField id_2 = new JTextField(15);

        final JLabel h3 = new JLabel("金额： ");
        final JTextField money = new JTextField(15);

        final JButton rbu = new JButton("转账");
        final JButton cbu = new JButton("重置");

        final JPanel cpl = new JPanel();
        cpl.setLayout(null);

        h.setBounds(50,20,60,20);
        h1.setBounds(50,60,60,20);
        h3.setBounds(50,100,60,20);

        id_1.setBounds(120,20,120,20);
        id_2.setBounds(120,60,120,20);
        money.setBounds(120,100,120,20);
        rbu.setBounds(50,300,120,20);
        cbu.setBounds(220,300,120,20);




        cpl.add(h);
        cpl.add(id_1);
        cpl.add(h3);
        cpl.add(id_2);
        cpl.add(h1);
        cpl.add(money);
        cpl.add(rbu);
        cpl.add(cbu);

        jfd.add(cpl);


        rbu.addActionListener(e -> {
            final Integer id1 = Integer.parseInt(id_1.getText());
            final Integer id2 = Integer.parseInt(id_2.getText());
            final Double moneyText = Double.parseDouble(money.getText());

            if (flag2){
                if (new AccountController().transBalance(id1,id2,moneyText)) {
                    info_UI(jfd,"转账成功！");
                    flag2 = false;
                } else {
                        info_UI(jfd,"转账失败！");
                    }
                }

        });

    }
}
