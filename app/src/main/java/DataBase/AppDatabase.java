package DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import entidades.Carta;
import entidades.Duelista;

@Database(entities = {Carta.class, Duelista.class}, version = 8)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DbDao dbDao();

    public static AppDatabase getInstance(Context context){
        return Room.databaseBuilder(context, AppDatabase.class, "DBYuGiOh")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
}
