// DO NOT:
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Handler {
    public static Posts fetchAndParse(String keyword) {
        try {
            String endpoint = "https://dummyjson.com/posts/search?q=" + keyword.trim().replace(" ", "%20");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .header("User-Agent", "Mozilla/5.0")
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            if (json.contains("\"total\":0") || !json.contains("\"posts\":[")) {
                return null;
            }

            Posts posts = new Posts();
            posts.posts = new ArrayList<>();

            Matcher postMatcher = Pattern.compile("\\{(?:[^{}]|\\{[^{}]*\\})*\\}")
                    .matcher(json.substring(json.indexOf("\"posts\":[") + 8));

            while (postMatcher.find()) {
                String block = postMatcher.group();
                Post post = new Post();
                post.id = extractIntField(block, "id");
                post.title = extractJsonField(block, "title");
                post.body = extractJsonField(block, "body");
                post.tags = extractTags(block);
                post.reactions = extractReactions(block);
                post.views = extractIntField(block, "views");
                post.userId = extractIntField(block, "userId");
                posts.posts.add(post);
            }

            return posts.posts.isEmpty() ? null : posts;
        } catch (Exception e) {
            return null;
        }
    }

    public static Posts fetch(String keyword) {
        return fetchAndParse(keyword);
    }

    private static String extractJsonField(String json, String field) {
        Matcher matcher = Pattern.compile("\"" + field + "\"\\s*:\\s*\"([^\"]+)\"").matcher(json);
        return matcher.find() ? matcher.group(1) : null;
    }

    private static int extractIntField(String json, String field) {
        Matcher matcher = Pattern.compile("\"" + field + "\"\\s*:\\s*(\\d+)").matcher(json);
        return matcher.find() ? Integer.parseInt(matcher.group(1)) : 0;
    }

    private static Reactions extractReactions(String json) {
        Matcher matcher = Pattern.compile("\"reactions\"\\s*:\\s*\\{\\s*\"likes\"\\s*:\\s*(\\d+)\\s*,\\s*\"dislikes\"\\s*:\\s*(\\d+)").matcher(json);
        if (matcher.find()) {
            Reactions r = new Reactions();
            r.likes = Integer.parseInt(matcher.group(1));
            r.dislikes = Integer.parseInt(matcher.group(2));
            return r;
        }
        return null;
    }

    private static ArrayList<String> extractTags(String json) {
        ArrayList<String> tags = new ArrayList<>();
        Matcher arrayMatcher = Pattern.compile("\"tags\"\\s*:\\s*\\[([^\\]]*)\\]").matcher(json);
        if (arrayMatcher.find()) {
            Matcher tagMatcher = Pattern.compile("\"([^\"]+)\"").matcher(arrayMatcher.group(1));
            while (tagMatcher.find()) {
                tags.add(tagMatcher.group(1));
            }
        }
        return tags;
    }
}