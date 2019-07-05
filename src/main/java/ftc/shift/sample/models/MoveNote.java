package ftc.shift.sample.models;

public class MoveNote {
    String id;
    String title;

    public MoveNote(String id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    String text;

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
