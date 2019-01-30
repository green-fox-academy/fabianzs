package blog;

public class BlogTest {
    public static void main(String[] args) {
        Blog redBlog = new Blog();

        BlogPost blogpost1 = new BlogPost("John Doe", "Lorem Ipsum", "Lorem ipsum dolor sit amet.", "2000.05.04.");
        BlogPost blogpost2 = new BlogPost("Tim Urban", "Wait but why", "A popular long-form, stick-figure-illustrated blog about almost everything.", "2010.10.10.");
        BlogPost blogpost3 = new BlogPost("William Turton", "One Engineer Is Trying to Get IBM to Reckon With Trump", "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing.", "2017.03.28.");
        BlogPost blogpost4 = new BlogPost("Kevin Spacey", "What", "I have no idea what to write.", "2010.12.08.");

        redBlog.add(blogpost1);
        redBlog.add(blogpost2);
        redBlog.add(blogpost3);
        redBlog.add(blogpost4);

        redBlog.delete(3);

        System.out.println(redBlog.blogPosts.size());
        System.out.println(redBlog.blogPosts.get(1).authorName);

        redBlog.update(1,blogpost4);
        System.out.println(redBlog.blogPosts.get(1).authorName);



    }
}
