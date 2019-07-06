package ftc.shift.sample.models;

import java.util.List;

public class Travel {
    String id;
    String name;

    public Travel() {}

    public Travel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
