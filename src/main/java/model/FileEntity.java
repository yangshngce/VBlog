package model;

import java.sql.Timestamp;

public class FileEntity {
    private String type;
    private String size;
    private String path;
    private String titleOrig;
    private String titleAlter;
    private String imgPath;
    private String videoPath;

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

    private Timestamp uploadTime;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getTitleOrig() {
        return titleOrig;
    }
    public void setTitleOrig(String titleOrig) {
        this.titleOrig = titleOrig;
    }
    public String getTitleAlter() {
        return titleAlter;
    }
    public void setTitleAlter(String titleAlter) {
        this.titleAlter = titleAlter;
    }
    public Timestamp getUploadTime() {
        return uploadTime;
    }
    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", path='" + path + '\'' +
                ", titleOrig='" + titleOrig + '\'' +
                ", titleAlter='" + titleAlter + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", videoPath='" + videoPath + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
