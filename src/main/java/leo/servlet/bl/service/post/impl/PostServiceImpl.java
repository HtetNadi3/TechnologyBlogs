package leo.servlet.bl.service.post.impl;

import java.util.List;
import java.util.stream.Collectors;

import leo.servlet.bl.dto.PostDTO;
import leo.servlet.bl.service.post.PostService;
import leo.servlet.persistence.dao.post.PostDao;
import leo.servlet.persistence.dao.post.impl.PostDaoImpl;
import leo.servlet.persistence.entity.Post;

public class PostServiceImpl implements PostService {
    private PostDao postDao = new PostDaoImpl();

    @Override
    public void doInsertPost(PostDTO postDto) {
        postDao.dbInsertPost(new Post(postDto));
    }

    @Override
    public List<PostDTO> doGetAllPosts() {
        return postDao.dbGetAllPosts().stream().map(post -> {
            return new PostDTO(post);
        }).collect(Collectors.toList());
    }

    @Override
    public PostDTO doGetPostById(int id) {
        return new PostDTO(postDao.dbGetPostById(id));
    }

    @Override
    public void doUpdatePost(PostDTO postDto) {
        postDao.dbUpdatePost(new Post(postDto));
    }

    @Override
    public void doDeletePost(int id) {
        postDao.dbDeletePost(id);
    }
}
