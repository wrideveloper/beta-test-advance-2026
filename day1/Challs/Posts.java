import java.util.ArrayList;

class Post{
    public int id;
    public String title;
    public String body;
    public ArrayList<String> tags;
    public Reactions reactions;
    public int views;
    public int userId;
}

class Reactions{
    public int likes;
    public int dislikes;
}

public class Posts{
    public ArrayList<Post> posts;
    public int total;
    public int skip;
    public int limit;
}
