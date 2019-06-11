package com.bookstore.bookstore.web;


import com.bookstore.bookstore.dao.model.Comment;
import com.bookstore.bookstore.service.ICommentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.DateUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author xuan
 * @since 2019-06-10
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    ICommentService commentService;

    @RequestMapping("add")
    public Map<String, Object> addComment(Comment comment) {
        Date now = DateUtils.createNow().getTime();
        comment.setCommentDate(now);
        commentService.save(comment);
        return new HashMap<>(1);
    }
}
