package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Music {
	AudioStream audios;

	public Music() {
		playBackgroundSong();
	}

	public void stopBackgroundSong() {
		if (audios != null) {
			AudioPlayer.player.stop(audios);
		}
	}

	public void playBackgroundSong() {
		InputStream in;
		try {
			in = new FileInputStream(new File("music.wav"));
			audios = new AudioStream(in);
			AudioPlayer.player.start(audios);
		} catch (Exception e) {
			System.out.print("music file not found");
		}
	}
}
