package fgecctv.com.module.database.table;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

import java.io.Serializable;

/**
 * 2016/9/29 18
 */
public class BaseModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    @Column("_id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
    }
}
