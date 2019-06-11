package com.bookstore.bookstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bookstore.bookstore.dao.CommentMapper;
import com.bookstore.bookstore.dao.StoreMapper;
import com.bookstore.bookstore.dao.UserMapper;
import com.bookstore.bookstore.dao.model.Comment;
import com.bookstore.bookstore.service.ICommentService;
import com.bookstore.bookstore.service.info.CommentInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author xuan
 * @since 2019-06-10
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {
    @Resource
    CommentMapper commentMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    StoreMapper storeMapper;

    @Override
    public List<CommentInfo> getComment(Long bookId, ModelMap map) {
        Page<Comment> page = new Page<>(1, 100);

        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("book_id", bookId);
        IPage<Comment> commentIPage = commentMapper.selectPage(page, queryWrapper);
        List<Comment> records = commentIPage.getRecords();
        List<CommentInfo> commentInfoList = new ArrayList<>();
        for (Comment record : records) {
            CommentInfo contentInfo = new CommentInfo();
            BeanUtils.copyProperties(record, contentInfo);
            contentInfo.setUser(userMapper.selectById(record.getUserId()));
            commentInfoList.add(contentInfo);
        }
        map.addAttribute("sizes", commentIPage.getTotal());
        return commentInfoList;
    }
}
