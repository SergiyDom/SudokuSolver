package dom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Cell {
    int id;
    boolean status;
    int value;
    public HashSet<Integer> maybeUsedValueList = new HashSet<>();
    public HashSet<Integer> defVelue = new HashSet<>();
    int F, R, C;

    public Cell() {
    }

    Cell(int id) {
        this.id = id;
        this.value = 0;
        this.status = false;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return value == cell.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
