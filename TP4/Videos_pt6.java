package TP4;

public class Videos_pt6 {
    int video_ID;
    String video_Title;
    String video_Author;
    int video_Duration;


    public Videos_pt6() {
    }

    public Videos_pt6(int video_ID, String video_Title, String video_Creator, int video_Duration) {
        this.video_ID = video_ID;
        this.video_Title = video_Title;
        this.video_Author = video_Creator;
        this.video_Duration = video_Duration;
    }


    public int getVideo_ID() {
        return video_ID;
    }
    public void setVideo_ID(int video_ID) {
        this.video_ID = video_ID;
    }

    public String getVideo_Title() {
        return video_Title;
    }
    public void setVideo_Title(String video_Title) {
        this.video_Title = video_Title;
    }

    public String getvideo_Author() {
        return video_Author;
    }
    public void setvideo_Author(String video_Author) {
        this.video_Author = video_Author;
    }

    public int getVideo_Duration() {
        return video_Duration;
    }
    public void setVideo_Duration(int video_Duration) {
        this.video_Duration = video_Duration;
    }

    
    @Override
    public String toString() {
        return "ID:" + video_ID + ", Titulo:" + video_Title + ", Creador=" + video_Author
                + ", Duracion en minutos:" + video_Duration + "\n";
    }
}
