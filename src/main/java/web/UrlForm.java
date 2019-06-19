package web;

public class UrlForm {
    private String videoPath;
    private String imgPath;

    public UrlForm(){};
    public UrlForm(String videoPath, String imgPath) {
        this.videoPath = videoPath;
        this.imgPath = imgPath;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "UrlForm{" +
                "videoPath='" + videoPath + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
