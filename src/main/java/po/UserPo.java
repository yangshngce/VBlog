package po;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserPo {

    private Integer USR_ID;
    private String USR_NAME;
    private String USR_PWD;
    private String SEX;
    private Integer AGE;
    private String CREATE_TIME;
    private Integer SOCCER;
    private Integer USR_TYPE;
    private String EMAIL;

    public UserPo() {
        this.USR_ID = 0;
        this.USR_NAME = "";
        this.USR_PWD = "";
        this.SEX = "";
        this.AGE = 0;
        this.CREATE_TIME = "";
        this.SOCCER = 0;
        this.USR_TYPE = 0;
        this.EMAIL = "";
    }


    public Integer getUSR_ID() {
        return USR_ID;
    }

    public void setUSR_ID(Integer USR_ID) {
        this.USR_ID = USR_ID;
    }

    public String getUSR_NAME() {
        return USR_NAME;
    }

    public void setUSR_NAME(String USR_NAME) {
        this.USR_NAME = USR_NAME;
    }

    public String getUSR_PWD() {
        return USR_PWD;
    }

    public void setUSR_PWD(String USR_PWD) {
        this.USR_PWD = USR_PWD;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public Integer getAGE() {
        return AGE;
    }

    public void setAGE(Integer AGE) {
        this.AGE = AGE;
    }

    public String getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(String CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public Integer getSOCCER() {
        return SOCCER;
    }

    public void setSOCCER(Integer SOCCER) {
        this.SOCCER = SOCCER;
    }

    public Integer getUSR_TYPE() {
        return USR_TYPE;
    }

    public void setUSR_TYPE(Integer USR_TYPE) {
        this.USR_TYPE = USR_TYPE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    @Override
    public String toString() {
        return "UserPo{" +
                "USR_ID=" + USR_ID +
                ", USR_NAME='" + USR_NAME + '\'' +
                ", USR_PWD='" + USR_PWD + '\'' +
                ", SEX='" + SEX + '\'' +
                ", AGE=" + AGE +
                ", CREATE_TIME=" + CREATE_TIME +
                ", SOCCER=" + SOCCER +
                ", USR_TYPE=" + USR_TYPE +
                ", EMAIL='" + EMAIL + '\'' +
                '}';
    }
}
