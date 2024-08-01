package leo.servlet.persistence.dao.post;

import java.util.List;

import leo.servlet.persistence.entity.Post;

public interface PostDao {
    void dbInsertPost(Post post);

    List<Post> dbGetAllPosts();

    Post dbGetPostById(int id);

    void dbUpdatePost(Post post);

    void dbDeletePost(int id);
}
