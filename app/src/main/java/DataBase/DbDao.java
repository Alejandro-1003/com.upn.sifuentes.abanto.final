package DataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import entidades.Carta;
import entidades.Duelista;

@Dao
public interface DbDao {
    @Query("Select * from Duelista")
    List<Duelista> getAllDuelistas();

    @Insert
    void createDuelista(Duelista duelista);

    @Query("SELECT * FROM Carta where idDuelista = :abc")
    List<Carta> findCartas(int abc);
}
