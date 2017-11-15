package audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * Created by HoangTu on 20/07/2017.
 */
public class SoundManager {
    public static Clip getSound(String name){
        try {
            File file = new File("src/sounds/"+name);

            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();// mỏ nhạc
            clip.open(stream);// mở nhạc
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
