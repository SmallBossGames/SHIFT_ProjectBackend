package ftc.shift.sample.models;

public class TravelNote {
    String id;
    String title;
    String text;

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

    public TravelNote() {
    }

    public TravelNote(String id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }
}
