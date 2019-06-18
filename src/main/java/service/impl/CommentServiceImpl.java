package service.impl;

import bo.CommentBo;
import mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.CommentPo;
import service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private List<CommentPo> commentPoList;

    @Autowired
    private List<CommentBo> commentBoList;

    @Autowired
    private UsrServiceImpl usrService;

    @Autowired
    private VideoServiceImpl videoService;

    @Override
    public List<CommentBo> getComment(Integer videoId) {
        commentBoList.clear();
        commentPoList=commentMapper.getComment(videoId);
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
