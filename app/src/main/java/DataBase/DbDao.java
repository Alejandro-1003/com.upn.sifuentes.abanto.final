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

    @Query("Select * from Carta")
    List<Carta> getAllCartas();

    @Insert
    void createDuelista(Duelista duelista);

    @Insert
    void createCarta(Carta carta);

    @Query("SELECT * FROM Carta where idDuelista = :abc")
    List<Carta> findCartas(int abc);

    @Query("SELECT * FROM Carta where id = :abc")
    List<Carta> findCarta(int abc);
}
