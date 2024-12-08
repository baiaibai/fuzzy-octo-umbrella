import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class Dlcs extends JFrame  implements ActionListener{
    lqbz img;
    ImageIcon icon;
    JButton button;
    JButton button1;
    JButton button2;
    JLabel label;
    JLabel label1;
    JLabel a;
    JLabel b;
    JLabel c;
    JLabel d;
    JLabel e;
    JTextField t;
    JPasswordField p;
    JPanel panel;
    JPanel buttonPanel;
    JPanel j;
    JPanel j1;
    JPanel j2;
    JPanel j4;
    JPanel j5;
    ButtonGroup group;
    JRadioButton g;
    JRadioButton u;
    String image="C:\\Users\\TT\\IdeaProjects\\untitled\\ClassDevise\\src\\8875fee4821dc4b44334ccdeaa7b582.jpg";
    String sql;
    String zhh;
    String mmm;
    String yzz;
    String pp;





    public  Dlcs(){
        Zhmm.getConnection();
        Zhmm.openStatement();
        this.setTitle("我就是你的宝");

        icon=new ImageIcon(image);
        label=new JLabel(icon);
        this.getLayeredPane().add(label,Integer.valueOf(Integer.MIN_VALUE));

        panel=(JPanel) this.getContentPane();
        panel.setOpaque(false);

        label1=new JLabel("还没有账号？点击注册->");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,500);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        label.setBounds(0,0,this.getWidth(),this.getHeight());

        a=new JLabel("请登陆或注册");
        panel.setLayout(new GridLayout(6,1));
        button=new JButton("确认");
        button.addActionListener(this);
        button1=new JButton("重置");
        button1.addActionListener(this);
        button2=new JButton("注册");
        button2.addActionListener(this);
        b=new JLabel("用户名：");
        b.setFocusable(true);
        b.requestFocusInWindow();
        c=new JLabel("密  码：");
        t=new JTextField("请输入帐号",20);
        t.setForeground(Color.gray);
        t.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (t.getText().equals("请输入帐号")){
                    t.setText("");
                    t.setForeground(Color.black);
                }
            }
            public void focusLost(FocusEvent e) {
                if (t.getText().equals("")){
                    t.setForeground(Color.gray);
                    t.setText("请输入帐号");
                }
            }
        });
        p=new JPasswordField("请输入密码",20);
        p.setEchoChar((char) 0);
        p.setForeground(Color.gray);
        p.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (p.getText().equals("请输入密码")){
                    p.setText("");
                    p.setForeground(Color.black);
                    p.setEchoChar('*');
                }
            }
            public void focusLost(FocusEvent e) {
                if (p.getText().equals("")){
                    p.setForeground(Color.gray);
                    p.setText("请输入密码");
                    p.setEchoChar((char) 0);
                }
            }
        });
        e=new JLabel("您是");
        group=new ButtonGroup();
        g=new JRadioButton("管理员", false);
        g.setOpaque(false);
        g.setFont(new Font("宋体", Font.ITALIC, 30));
        u=new JRadioButton("用户", true);
        u.setOpaque(false);
        u.setFont(new Font("宋体", Font.ITALIC, 30));
        group.add(g);
        group.add(u);



        buttonPanel=new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(button);
        buttonPanel.add(button1);

        j=new JPanel();
        j.setOpaque(false);
        j.add(a);

        j1=new JPanel();
        j1.setOpaque(false);
        j1.add(b);
        j1.add(t);

        j2=new JPanel();
        j2.setOpaque(false);
        j2.add(c);
        j2.add(p);

        j4=new JPanel();
        j4.setOpaque(false);
        j4.add(label1);
        j4.add(button2);

        j5=new JPanel();
        j5.setOpaque(false);
        j5.add(e);
        j5.add(g);
        j5.add(u);

        panel.add(j);
        panel.add(j1);
        panel.add(j2);
        panel.add(j5);
        panel.add(buttonPanel);
        panel.add(j4);
        this.setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            if (e.getActionCommand().equals("重置")) {
                t.setText("请输入帐号");
                p.setText("请输入密码");
                p.setEchoChar((char) 0);
                d.setText("");
            }
            if (e.getActionCommand().equals("确认")) {
                sql="select zh,mm,yz from zhmmyz where zh='"+t.getText()+"'";
                ResultSet rs=Zhmm.query(sql);

                try{
                    while (rs.next()){
                         zhh=rs.getString("zh");
                         mmm=rs.getString("mm");
                         yzz=rs.getString("yz");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                char[] password=p.getPassword();
                pp=new String(password);
                System.out.println(mmm);
                System.out.println(pp);
                if (mmm.equals(pp)){
                    new dlcg();
                }else new cw();
                //this.setVisible(false);
            }

            if (e.getActionCommand().equals("注册")){
                new Zccs();
            }
        }
    }


}