import java.time.LocalDate;

public class Document implements DocumentInterface {
    private final String id;
    private final String creationDate;
    private final String content;

    public Document(String id, String content) {
        this.id = id;
        this.creationDate = LocalDate.now().toString();
        this.content = content;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
}
