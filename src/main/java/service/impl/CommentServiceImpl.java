package service.impl;

import bo.CommentBo;
import mapper.CommentMapper;
import mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.CommentPo;
import po.VideoPo;
import service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private List<CommentPo> commentPoList;

    @Autowired
    private List<VideoPo> videoPos;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private List<CommentBo> commentBoList;

    @Autowired
    private UsrServiceImpl usrService;

    @Autowired
    private VideoServiceImpl videoService;

    @Override
    public List<CommentBo> getComment(String videoName) {
        videoPos.clear();
        System.out.println("videoName"+videoName);
        videoPos=videoMapper.getOneByName(videoName);
        commentBoList.clear();
        System.out.println("videoId"+videoPos.get(0).getVIDEO_ID());
        commentPoList=commentMapper.getComment(videoPos.get(0).getVIDEO_ID());
        System.out.println("commentBoList:"+commentBoList);
        System.out.println("commentBoList.size():"+commentBoList.size());
        System.out.println("commentPoList.size():"+commentPoList.size());
        for (CommentPo commentPo:commentPoList) {
            CommentBo commentBo=new CommentBo();
            commentBo.setUsrName(usrService.getUsrNameById(commentPo.getUSR_ID()));
            commentBo.setCreateTime(commentPo.getCREATE_TIME());
            commentBo.setContent(commentPo.getCONTENT());
            System.out.println("添加commentBo:"+commentBo);
            commentBoList.add(commentBo);
        }
        System.out.println("commentBoList:"+commentBoList);
        return commentBoList;
    }
}
