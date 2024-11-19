package Engine;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BackgroundMusic {
    private Clip mainBackgroundClip;
    private Map<String,Clip>locationClips= new HashMap<>();
    private String currentLocation ="";


    public BackgroundMusic(String mainMusicPath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(mainMusicPath));
            mainBackgroundClip = AudioSystem.getClip();
            mainBackgroundClip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }

        //location music
        loadLocationMusic("house","Resources/HouseMusic.wav");
        loadLocationMusic("town","Resources/GameSong.wav");
        loadLocationMusic("butcher","Resources/ButcherMusic.wav");

    }
    private void loadLocationMusic(String location, String filePath){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            locationClips.put(location,clip);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }

    }

    public void PlayMainMusic(){
        stopCurrentLocationMusic();

        if (mainBackgroundClip!= null && !mainBackgroundClip.isRunning()){
            mainBackgroundClip.setFramePosition(0);
            mainBackgroundClip.start();
            mainBackgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        currentLocation= "";
    }

    public void playLocationMusic(String location){
        //If we are in the same location, don't do anything
        if (location.equals(currentLocation)){
            return;
        }
        // stop main music 
        if (mainBackgroundClip!= null && mainBackgroundClip.isRunning()){
            mainBackgroundClip.stop();
        }

        stopCurrentLocationMusic();

        //begin new location music 
        Clip newClip = locationClips.get(location);
        if (newClip!= null){
            newClip.setFramePosition(0);
            newClip.start();
            newClip.loop(Clip.LOOP_CONTINUOUSLY);
            currentLocation = location;
        }
    }

    public void exitLocation(){
        //stop location music 
        stopCurrentLocationMusic();
        currentLocation = "";

        //begin again main music 
        if (mainBackgroundClip != null){
            mainBackgroundClip.setFramePosition(0);
            mainBackgroundClip.start();
            mainBackgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
    private void stopCurrentLocationMusic(){
        Clip currentClip = locationClips.get(currentLocation);
        if (currentClip != null && currentClip.isRunning() ){
            currentClip.stop();
        }
    }
    private void stopAll(){
        if (mainBackgroundClip != null && mainBackgroundClip.isRunning()){
            mainBackgroundClip.stop();
        }
        for(Clip clip : locationClips.values()){
            if (clip.isRunning()){
                clip.stop();
            }
        }
        currentLocation= "";
    }
    public void pause(){
        if (mainBackgroundClip != null && mainBackgroundClip.isRunning()){
            mainBackgroundClip.stop();
        }

        Clip currentClip = locationClips.get(currentLocation);

        if(currentClip != null && currentClip.isRunning()){
            currentClip.stop();
        }
    }
    public void resume(){
        // if we in the some location this will be open the location music 
        if (! currentLocation.isEmpty()){
            Clip currentClip = locationClips.get(currentLocation);
            if (currentClip != null && !currentClip.isRunning()){
                currentClip.start();
            }else{
                // if we not in location it will be open main music 
                if (mainBackgroundClip != null && mainBackgroundClip.isRunning()){
                    mainBackgroundClip.start();
                }
            }
        }
    }
    public boolean isPlaying() {
        if (!currentLocation.isEmpty()){
            Clip currentClip = locationClips.get(currentLocation);
            return currentClip != null && currentClip.isRunning();
        }
        return mainBackgroundClip != null && mainBackgroundClip.isRunning();
    }
}