import javax.swing.*;

public class dlcg extends JFrame{
    dlcg(){
        JFrame jFrame=new JFrame("登录成功");
        JLabel jLabel=new JLabel("登录成功");
        JPanel jPanel=new JPanel();
        jPanel.add(jLabel);
        jFrame.add(jPanel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(200,100);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args) {
        new dlcg();
    }
}
