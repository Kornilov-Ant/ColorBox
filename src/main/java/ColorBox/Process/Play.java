package ColorBox.Process;

import ColorBox.Box.*;
import ColorBox.DevelopCartoon.*;

public class Play {

    public void Play(BoxCap box, int number, boolean now){
        DevelopCap cap = new DevelopCap();
        cap.DevelopCap(box, number, now);
    }

    public void Play(BoxMagic box, int number, int dir, boolean now){
        if (dir == 0){
            DevelopMagicG magicG = new DevelopMagicG();
            magicG.DevelopMagicG(box, number, now);
        } else if (dir == 1) {
            DevelopMagicV magicV = new DevelopMagicV();
            magicV.DevelopMagicV(box, number, now);
        }
    }

    public void Play(BoxTwoCapLite box, int number){

    }

    public void Play(BoxTwoCap box, int number){

    }

}
