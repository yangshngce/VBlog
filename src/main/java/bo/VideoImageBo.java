package bo;

import org.springframework.stereotype.Component;

@Component
public class VideoImageBo {
    private String imageUrl;
    private String videoName;
    private String uploadUsr;
    private String createTime;


    public VideoImageBo() {
    }

    public VideoImageBo(String imageUrl, String videoName, String uploadUsr, String createTime) {
        this.imageUrl = imageUrl;
        this.videoName = videoName;
        this.uploadUsr = uploadUsr;
        this.createTime = createTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getUploadUsr() {
        return uploadUsr;
    }

    public void setUploadUsr(String uploadUsr) {
        this.uploadUsr = uploadUsr;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "VideoImageBo{" +
                "imageUrl='" + imageUrl + '\'' +
                ", videoName='" + videoName + '\'' +
                ", uploadUsr='" + uploadUsr + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
