import common.VideoFrameKit;

public class test {
    public static void main(String[] args)throws Exception{
        String videoPath="E:\\t2.mp4";
        String savePath= "E:\\Bokee\\src\\main\\webapp\\WEB-INF\\statics\\videos\\videoImages";
        VideoFrameKit.fetchFrame(videoPath,savePath);
    }
}
