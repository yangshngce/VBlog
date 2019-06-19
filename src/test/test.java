import common.VideoFrameKit;

public class test {
    public static void main(String[] args)throws Exception{
        String videoPath="E:\\Bokee\\target\\Bokee\\video\\\\66391560961445629.mp4";
        String savePath= "E:\\Bokee\\target\\Bokee\\video\\\\66391560961445629.jpeg";
        VideoFrameKit.fetchFrame(videoPath,savePath);
    }
}
