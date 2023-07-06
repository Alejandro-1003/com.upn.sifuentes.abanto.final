package entidades;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Carta {
    @ColumnInfo(name ="idDuelista")
    public int idDuelista;
    @ColumnInfo(name ="name")
    public String name;
    @ColumnInfo(name ="ataque")
    public int ataque;
    @ColumnInfo(name ="defensa")
    public int defensa;
    @ColumnInfo(name ="imagen")
    public String imagen;
    @ColumnInfo(name ="latitud")
    public String latitud;
    @ColumnInfo(name ="longitud")
    public int longitud;
    @PrimaryKey(autoGenerate = true)
    public int id;
}
