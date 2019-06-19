package web;

public class VideoForm {
    private String VIDEO_NAME;
    private Integer UPLOAD_USR;
    private String TYPE;
    private Integer RANK;
    private String LABLE;
    private String URL;
    private String IMG_URL;

    public String getVIDEO_NAME() {
        return VIDEO_NAME;
    }

    public void setVIDEO_NAME(String VIDEO_NAME) {
        this.VIDEO_NAME = VIDEO_NAME;
    }

    public Integer getUPLOAD_USR() {
        return UPLOAD_USR;
    }

    public void setUPLOAD_USR(Integer UPLOAD_USR) {
        this.UPLOAD_USR = UPLOAD_USR;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public Integer getRANK() {
        return RANK;
    }

    public void setRANK(Integer RANK) {
        this.RANK = RANK;
    }

    public String getLABLE() {
        return LABLE;
    }

    public void setLABLE(String LABLE) {
        this.LABLE = LABLE;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getIMG_URL() {
        return IMG_URL;
    }

    public void setIMG_URL(String IMG_URL) {
        this.IMG_URL = IMG_URL;
    }

    @Override
    public String toString() {
        return "VideoForm{" +
                "VIDEO_NAME='" + VIDEO_NAME + '\'' +
                ", UPLOAD_USR=" + UPLOAD_USR +
                ", TYPE='" + TYPE + '\'' +
                ", RANK=" + RANK +
                ", LABLE='" + LABLE + '\'' +
                ", URL='" + URL + '\'' +
                ", IMG_URL='" + IMG_URL + '\'' +
                '}';
    }
}
