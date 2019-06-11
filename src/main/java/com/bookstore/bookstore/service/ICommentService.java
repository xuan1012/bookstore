package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dao.model.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bookstore.bookstore.service.info.CommentInfo;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author xuan
 * @since 2019-06-10
 */
public interface ICommentService extends IService<Comment> {
    List<CommentInfo> getComment(Long bookId, ModelMap map);
}
