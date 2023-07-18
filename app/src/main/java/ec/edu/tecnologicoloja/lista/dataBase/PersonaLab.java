package ec.edu.tecnologicoloja.lista.dataBase;


import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import java.util.List;

public class PersonaLab {

    @SuppressLint("StaticFieldLeak")
    private static PersonaLab sPersonaLab;

    private PersonaDao mPersonaDao;

    public PersonaLab(Context context) {
        Context appContext = context.getApplicationContext();
        personaDataBase database = Room.databaseBuilder(appContext, personaDataBase.class, "lugares")
                .allowMainThreadQueries().build();
        mPersonaDao = database.gePersonaDao();
    }

    public static PersonaLab get(Context context) {
        if (sPersonaLab == null) {
            sPersonaLab = new PersonaLab(context);
        }
        return sPersonaLab;
    }

    public List<Persona> getPersonas() {
        return mPersonaDao.gePersona();
    }

    public Persona getPersona(String id) {
        return mPersonaDao.getPersona(id);
    }

    public void addPersona(Persona persona) {
        mPersonaDao.addPersona(persona);
    }

    public void updatePersona(Persona persona) {
        mPersonaDao.updatePersona(persona);
    }

    public void deletePersona(Persona persona) {
        mPersonaDao.deletePersona(persona);
    }

    public void deleteAllPersona() {
        mPersonaDao.deleteAllPersona();
    }
}
