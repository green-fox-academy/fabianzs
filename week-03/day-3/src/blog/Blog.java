package blog;

import java.util.ArrayList;
import java.util.List;

public class Blog {
    List<BlogPost> blogPosts;

    public Blog() {
        this.blogPosts = new ArrayList<>();
    }

    public void add(BlogPost blogPost){
        blogPosts.add(blogPost);
    }

    public void delete(int indexOfBlogPost) {
        blogPosts.remove(indexOfBlogPost);
    }

    public void update (int indexOfBlogPost, BlogPost blogPostToUpdate) {
        blogPosts.set(indexOfBlogPost, blogPostToUpdate);
    }
}
