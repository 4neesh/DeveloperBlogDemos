import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private static Frame frame;

    private Frame(){

        setLayout(new FlowLayout());

    }

    public static Frame getFrameInstance(){
        if(frame == null){
            frame = new Frame();
        }
        return frame;
    }
}
