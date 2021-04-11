package controlsueldo.github.io;

import java.sql.Date;
import java.sql.Time;

public class BDDEstructura {
    public static final String TABLE_NAME  = "fichaje";
    public static final String COLUMN_CODIGO = "codigo";
    public static final String COLUMN_FECHA_ENTRADA = "f_entrada";
    public static final String COLUMN_FECHA_SALIDA = "f_salida";
    public static final String COLUMN_HORA_ENTRADA = "h_entrada";
    public static final String COLUMN_HORA_SALIDA = "h_salida";
    public static final String COLUMN_OPCIONAL = "opcional";

    private BDDEstructura(){}
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE "+BDDEstructura.TABLE_NAME+ " (" +
                    BDDEstructura.COLUMN_CODIGO + " INTEGER PRIMARY KEY"+
                    BDDEstructura.COLUMN_FECHA_ENTRADA + " DATE NOT NULL, "+
                    BDDEstructura.COLUMN_FECHA_SALIDA + " DATE NOT NULL, "+
                    BDDEstructura.COLUMN_HORA_ENTRADA + "TIME NOT NULL, "+
                    BDDEstructura.COLUMN_HORA_SALIDA + "DATETIME NOT NULL, "+
                    BDDEstructura.COLUMN_OPCIONAL + " VARCHAR(20) )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + BDDEstructura.TABLE_NAME;
}
