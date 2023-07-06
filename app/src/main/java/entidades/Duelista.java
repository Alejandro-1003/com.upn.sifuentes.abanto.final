package entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Duelista")
public class Duelista {
    @ColumnInfo(name ="name")
    public String name;
    @PrimaryKey(autoGenerate = true)
    public int id;
}
