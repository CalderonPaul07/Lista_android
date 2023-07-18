package ec.edu.tecnologicoloja.lista.dataBase;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PersonaDao_Impl implements PersonaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Persona> __insertionAdapterOfPersona;

  private final EntityDeletionOrUpdateAdapter<Persona> __deletionAdapterOfPersona;

  private final EntityDeletionOrUpdateAdapter<Persona> __updateAdapterOfPersona;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllPersona;

  public PersonaDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPersona = new EntityInsertionAdapter<Persona>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Persona` (`id`,`nombre`,`apellido`,`telefono`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Persona value) {
        stmt.bindLong(1, value.getId());
        if (value.getNombre() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNombre());
        }
        if (value.getApellido() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getApellido());
        }
        if (value.getTelefono() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTelefono());
        }
      }
    };
    this.__deletionAdapterOfPersona = new EntityDeletionOrUpdateAdapter<Persona>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Persona` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Persona value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfPersona = new EntityDeletionOrUpdateAdapter<Persona>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Persona` SET `id` = ?,`nombre` = ?,`apellido` = ?,`telefono` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Persona value) {
        stmt.bindLong(1, value.getId());
        if (value.getNombre() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNombre());
        }
        if (value.getApellido() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getApellido());
        }
        if (value.getTelefono() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTelefono());
        }
        stmt.bindLong(5, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAllPersona = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Persona";
        return _query;
      }
    };
  }

  @Override
  public void addPersona(final Persona p) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPersona.insert(p);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deletePersona(final Persona p) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPersona.handle(p);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updatePersona(final Persona p) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPersona.handle(p);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllPersona() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllPersona.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllPersona.release(_stmt);
    }
  }

  @Override
  public List<Persona> gePersona() {
    final String _sql = "SELECT *FROM Persona";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfApellido = CursorUtil.getColumnIndexOrThrow(_cursor, "apellido");
      final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
      final List<Persona> _result = new ArrayList<Persona>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Persona _item;
        _item = new Persona();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        _item.setNombre(_tmpNombre);
        final String _tmpApellido;
        if (_cursor.isNull(_cursorIndexOfApellido)) {
          _tmpApellido = null;
        } else {
          _tmpApellido = _cursor.getString(_cursorIndexOfApellido);
        }
        _item.setApellido(_tmpApellido);
        final String _tmpTelefono;
        if (_cursor.isNull(_cursorIndexOfTelefono)) {
          _tmpTelefono = null;
        } else {
          _tmpTelefono = _cursor.getString(_cursorIndexOfTelefono);
        }
        _item.setTelefono(_tmpTelefono);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Persona getPersona(final String uuide) {
    final String _sql = "SELECT * FROM Persona WHERE nombre like ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uuide == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uuide);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfApellido = CursorUtil.getColumnIndexOrThrow(_cursor, "apellido");
      final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
      final Persona _result;
      if(_cursor.moveToFirst()) {
        _result = new Persona();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        _result.setNombre(_tmpNombre);
        final String _tmpApellido;
        if (_cursor.isNull(_cursorIndexOfApellido)) {
          _tmpApellido = null;
        } else {
          _tmpApellido = _cursor.getString(_cursorIndexOfApellido);
        }
        _result.setApellido(_tmpApellido);
        final String _tmpTelefono;
        if (_cursor.isNull(_cursorIndexOfTelefono)) {
          _tmpTelefono = null;
        } else {
          _tmpTelefono = _cursor.getString(_cursorIndexOfTelefono);
        }
        _result.setTelefono(_tmpTelefono);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
