package fiuba.algo3.controlador;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ReproductorSonidos {

    private MediaPlayer musica;
    private AudioClip golpe;

    public ReproductorSonidos() {
        this.musica = new MediaPlayer(new Media(getClass().getResource("../../../res/sonidos/musica.mp3").toExternalForm()));
        this.golpe = new AudioClip(getClass().getResource("../../../res/sonidos/golpe.mp3").toString());
        this.musica.setVolume(0.3);
        this.golpe.setVolume(0.5);
    }

    public void reproducirMusica() {
        this.musica.play();
        this.musica.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public void pausarMusica() {
        this.musica.pause();
    }

    public void reproducirGolpear() {
        this.golpe.play();
    }

    public boolean musicaPausada() {
        return (this.musica.getStatus() != MediaPlayer.Status.PLAYING);
    }

}
