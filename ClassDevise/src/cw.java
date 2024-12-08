import javax.swing.*;

public class cw extends JFrame{
    cw(){
        JFrame jFrame=new JFrame("账号或密码错误");
        JLabel jLabel=new JLabel("账号或密码错误");
        JPanel jPanel=new JPanel();
        jPanel.add(jLabel);
        jFrame.add(jPanel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(200,100);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args) {
        new cw();
    }
}
