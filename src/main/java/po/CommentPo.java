package po;

import org.springframework.stereotype.Component;

@Component
public class CommentPo {
    private Integer VIDEO_ID;
    private Integer USR_ID;
    private String CONTENT;
    private String CREATE_TIME;

    public CommentPo() {
        this.VIDEO_ID = VIDEO_ID;
        this.USR_ID = USR_ID;
        this.CONTENT = CONTENT;
        this.CREATE_TIME = CREATE_TIME;
    }

    public Integer getVIDEO_ID() {
        return VIDEO_ID;
    }

    public void setVIDEO_ID(Integer VIDEO_ID) {
        this.VIDEO_ID = VIDEO_ID;
    }

    public Integer getUSR_ID() {
        return USR_ID;
    }

    public void setUSR_ID(Integer USR_ID) {
        this.USR_ID = USR_ID;
    }

    public String getCONTENT() {
        return CONTENT;
    }

    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
    }

    public String getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(String CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    @Override
    public String toString() {
        return "CommentPo{" +
                "VIDEO_ID=" + VIDEO_ID +
                ", USR_ID=" + USR_ID +
                ", CONTENT='" + CONTENT + '\'' +
                ", CREATE_TIME='" + CREATE_TIME + '\'' +
                '}';
    }
}
