import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Zccs extends JFrame implements ActionListener {
    JFrame frame;
    ImageIcon icon;
    JButton button;
    JButton button1;
    JLabel label;
    JLabel a;
    JLabel b;
    JLabel c;
    JLabel d;
    JLabel e;
    JTextField t;
    JTextField t1;
    JPasswordField p;
    JPanel panel;
    JPanel buttonPanel;
    JPanel j;
    JPanel j1;
    JPanel j2;
    JPanel j3;
    JPanel j4;
    String sql;
    String sql1;
    String zhh;
    String mmm;
    String yzz;
    String pp;
    Boolean bl=false;

     Zccs() {
         Zhmm.getConnection();
         Zhmm.openStatement();
        frame = new JFrame("我就是你的宝");

        icon = new ImageIcon("C:\\Users\\TT\\IdeaProjects\\untitled\\ClassDevise\\src\\8875fee4821dc4b44334ccdeaa7b582.jpg");
        label = new JLabel(icon);

        frame.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
        panel = (JPanel) frame.getContentPane();
        panel.setOpaque(false);

        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);

        label.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        a = new JLabel("注册");
        panel.setLayout(new GridLayout(6, 1));
        button = new JButton("确认");
        button.addActionListener(this);
        button1 = new JButton("重置");
        button1.addActionListener(this);
        b = new JLabel("用户名：");
        b.setFocusable(true);
        b.requestFocusInWindow();
        c = new JLabel("密  码：");
        t = new JTextField("请输入帐号", 20);
        t.setForeground(Color.gray);
        t.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (t.getText().equals("请输入帐号")) {
                    t.setText("");
                    t.setForeground(Color.black);
                    d.setText("<html>1.账号必须为数字或英文<br>2.账号必须大于6位小于15位</html>");
                }
            }

            public void focusLost(FocusEvent e) {
                if (t.getText().equals("")) {
                    t.setForeground(Color.gray);
                    t.setText("请输入帐号");
                }
            }
        });
        t.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c2 = e.getKeyChar();
                if (!((c2>='a'&&c2<='z')||(c2>='A'&&c2<='Z')||(c2>='0'&&c2<='9'))){
                    d.setText("不是英文或数字");
                    e.consume();
                }
            }
        });
        p = new JPasswordField("请输入密码", 20);
        p.setEchoChar((char) 0);
        p.setForeground(Color.gray);
        p.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (p.getText().equals("请输入密码")) {
                    p.setText("");
                    p.setForeground(Color.black);
                    p.setEchoChar('*');
                    d.setText("<html>1.密码必须为数字、英文或常见字符<br>2.密码必须大于8位<br>3.密码不能与帐号相同</html>");
                }
            }

            public void focusLost(FocusEvent e) {
                if (p.getText().equals("")) {
                    p.setForeground(Color.gray);
                    p.setText("请输入密码");
                    p.setEchoChar((char) 0);
                    d.setText("");
                }
            }
        });
         p.addKeyListener(new KeyAdapter() {
             @Override
             public void keyTyped(KeyEvent e) {
                 char c1=e.getKeyChar();
                 if (!(Character.isLetterOrDigit(c1) || "\b~!@#$%^&*()-_=+[]{}\\|;:'\",<.>/?".indexOf(c1) >= 0)){
                     d.setText("不是英文数字或常见字符");
                     e.consume();
                 }
             }
         });
        d = new JLabel();
        d.setForeground(Color.red);
        d.setFont(new Font("宋体", Font.ITALIC, 15));
        d.setOpaque(false);

        e=new JLabel("密保:" +
                "" +
                "" +
                "");
        t1=new JTextField("请输入密保",20);
        t1.setForeground(Color.gray);
        t1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (t1.getText().equals("请输入密保")){
                    t1.setText("");
                    t1.setForeground(Color.black);
                    d.setText("<html>1.密保可以在您忘记密码时帮助您找回密码<br>2.在您修改密码和注销账号时需要验证密保<br>3.请务必记住您的密保</html>");
                }
            }

            public void focusLost(FocusEvent e) {
                if (t1.getText().equals("")){
                    t1.setForeground(Color.gray);
                    t1.setText("请输入密保");
                    d.setText("");
                }
            }
        });

        buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(button);
        buttonPanel.add(button1);

        j = new JPanel();
        j.setOpaque(false);
        j.add(a);

        j1 = new JPanel();
        j1.setOpaque(false);
        j1.add(b);
        j1.add(t);

        j2 = new JPanel();
        j2.setOpaque(false);
        j2.add(c);
        j2.add(p);

        j3 = new JPanel();
        j3.setOpaque(false);
        j3.add(d);

        j4=new JPanel();
        j4.setOpaque(false);
        j4.add(e);
        j4.add(t1);

        panel.add(j);
        panel.add(j1);
        panel.add(j2);
        panel.add(j4);
        panel.add(j3);
        panel.add(buttonPanel);
        frame.setVisible(true);
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
                char[] password=p.getPassword();
                pp=new String(password);
                if (pp.length()<8){
                    d.setText("密码不能小于8位");
                }else {
                sql="select * from zhmmyz";
                ResultSet rs=Zhmm.query(sql);
                try{
                    while (rs.next()){
                        zhh=rs.getString("zh");
                        mmm=rs.getString("mm");
                        yzz=rs.getString("yz");
                        if (zhh.equals(t.getText())){
                            d.setText("该账号已注册");
                            System.out.println(t.getText());
                        }else bl=true;
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                }

                if (bl){
                    if (t.getText().equals(pp)){
                        new cw();
                    }
                    else {
                        sql1="insert into zhmmyz ( zh , mm ,yz)"+
                                "values('"+t.getText()+"','"+pp+"','"+t1.getText()+"')";
                        Zhmm.update(sql1);
                        new dlcg();
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        new Zccs();
    }

}
