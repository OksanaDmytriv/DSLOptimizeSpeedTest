package core.conditions.collection;

public class MinimumSize extends Size {


    public MinimumSize(int expectedSize) {
        super(expectedSize);
    }

    public boolean checkList() {
        return listSize >= expectedSize;
    }
}
