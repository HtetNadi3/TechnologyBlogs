package leo.servlet.bl.service.post;

import java.util.List;

import leo.servlet.bl.dto.PostDTO;

public interface PostService {
    void doInsertPost(PostDTO postDto);

    List<PostDTO> doGetAllPosts();

    PostDTO doGetPostById(int id);

    void doUpdatePost(PostDTO postDto);

    void doDeletePost(int id);
}