package Model;

/**
 * Created by caron on 12/11/15.
 */
public class SeatID {
    private Integer row;
    private Character column;

    public SeatID(Integer row,Character column)
    {
        this.column=column;
        this.row=row;
    }

    public Integer getRow() {
        return row;
    }

    public Character getColumn() {
        return column;
    }
}
