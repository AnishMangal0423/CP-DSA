package Java_in_Java.Oops.Inheritance;


class iphone13{

    private int cameraResolution;
    private String screenTouch;

    void setter(String sT , int cR){

        this.cameraResolution = cR;
        this.screenTouch = sT;

    }

    String screen_getter(){
        return this.screenTouch;
    }

    int camera_getter(){
        return this.cameraResolution;
    }

}


class iphone14 extends iphone13{


     private String audioSound;

    public void setAudio(String audioSound) {
        this.audioSound = audioSound;
    }

    public String getAudio() {
        return this.audioSound;
    }
}

public class Single_Inheritance{

    public static void main(String[] args) {

        iphone14 p1 = new iphone14();

        p1.setter("Smooth" , 1080);
        p1.setAudio("80% ");

        System.out.println("Screen type : " + p1.screen_getter());
        System.out.println("Camera type : " + p1.camera_getter());
        System.out.println("Audio Level : " + p1.getAudio());

    }

}
