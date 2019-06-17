package po;

public class UserPo {
    private Integer USER_ID;
    private String NAME;
    private String PASSWORD;
    private Integer HOME_ID;

    public UserPo() {
    }

    public UserPo(String NAME, String PASSWORD) {
        this.NAME = NAME;
        this.PASSWORD = PASSWORD;
    }

    public Integer getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Integer USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public Integer getHOME_ID() {
        return HOME_ID;
    }

    public void setHOME_ID(Integer HOME_ID) {
        this.HOME_ID = HOME_ID;
    }

    @Override
    public String toString() {
        return "UserPo{" +
                "USER_ID=" + USER_ID +
                ", NAME='" + NAME + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", HOME_ID=" + HOME_ID +
                '}';
    }
}
