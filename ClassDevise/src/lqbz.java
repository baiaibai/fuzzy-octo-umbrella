import javax.swing.*;
import java.awt.*;

public class lqbz extends JPanel {
    private int w=0;
    private int h=0;
    private String image="";

    lqbz(int _w,int _h,String _i){
        w=_w;
        h=_h;
        image=_i;
        setSize(w,h);
        setVisible(true);
    }
    lqbz(double _w,double _h,String _i){
        w=(int) _w;
        h=(int) _h;
        image=_i;
        setSize(w,h);
        setVisible(true);
    }

    public void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D) gs;
        super.paintComponent(g);
        Image image1=Toolkit.getDefaultToolkit().getImage(getClass().getResource(image));
        g.drawImage(image1,0,0,w,h,this);
    }
}
