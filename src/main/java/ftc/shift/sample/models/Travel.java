package ftc.shift.sample.models;

import java.util.List;

public class Travel {
    String id;
    String name;
    List<Move> moves;

    public Travel() {}

    public Travel(String id, String name, List<Move> moves) {
        this.id = id;
        this.name = name;
        this.moves = moves;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Move> getMoves() {
        return moves;
    }
}
