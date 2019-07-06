package ftc.shift.sample.models;

public class MoveNote {
    private String id;
    private String title;
    private String text;

    public MoveNote(){}

    public MoveNote(String id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
