package DataBase;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import entidades.Duelista;

@Dao
public interface DbDao {
    @Query("Select * from Duelista")
    List<Duelista> getAllDuelistas();
}
