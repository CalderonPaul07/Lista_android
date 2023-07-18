package ec.edu.tecnologicoloja.lista.dataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Persona.class},version = 2)
public abstract class personaDataBase extends RoomDatabase {

    public abstract PersonaDao gePersonaDao();
}
