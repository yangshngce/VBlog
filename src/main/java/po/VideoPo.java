package po;

import org.springframework.stereotype.Component;

@Component
public class VideoPo {
    private Integer VIDEO_ID;
    private String VIDEO_NAME;
    private String CREATE_TIME;
    private Integer UPLOAD_USR;
    private String TYPE;
    private Integer RANK;
    private String LABLE;
    private String URL;

    public VideoPo() {
        this.VIDEO_ID = 0;
        this.VIDEO_NAME = "";
        this.CREATE_TIME = "";
        this.UPLOAD_USR = 0;
        this.TYPE = "";
        this.RANK = 0;
        this.LABLE = "";
        this.URL = "";
    }

    public Integer getVIDEO_ID() {
        return VIDEO_ID;
    }

    public void setVIDEO_ID(Integer VIDEO_ID) {
        this.VIDEO_ID = VIDEO_ID;
    }

    public String getVIDEO_NAME() {
        return VIDEO_NAME;
    }

    public void setVIDEO_NAME(String VIDEO_NAME) {
        this.VIDEO_NAME = VIDEO_NAME;
    }

    public String getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(String CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
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

    @Override
    public String toString() {
        return "VideoPo{" +
                "VIDEO_ID=" + VIDEO_ID +
                ", VIDEO_NAME='" + VIDEO_NAME + '\'' +
                ", CREATE_TIME='" + CREATE_TIME + '\'' +
                ", UPLOAD_USR=" + UPLOAD_USR +
                ", TYPE='" + TYPE + '\'' +
                ", RANK=" + RANK +
                ", LABLE='" + LABLE + '\'' +
                ", URL='" + URL + '\'' +
                '}';
    }
}
