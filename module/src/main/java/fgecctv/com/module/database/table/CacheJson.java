package fgecctv.com.module.database.table;

import com.litesuits.orm.db.annotation.Table;

/**
 * 2016/9/30 10
 */
@Table("cache")
public class CacheJson extends BaseModel{
    private long time;
    private String type;
    private String jsondata;

}
