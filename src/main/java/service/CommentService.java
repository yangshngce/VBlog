package service;

import bo.CommentBo;

import java.util.List;

public interface CommentService {
    List<CommentBo> getComment(Integer videoId);
}
