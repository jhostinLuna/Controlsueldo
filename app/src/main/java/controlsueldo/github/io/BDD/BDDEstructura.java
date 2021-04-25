package controlsueldo.github.io.BDD;

public class BDDEstructura {
    public static final String TABLE_NAME  = "fichaje";
    public static final String COLUMN_CODIGO = "codigo";
    public static final String COLUMN_REGISTRO_ENTRADA = "f_entrada";
    public static final String COLUMN_REGISTRO_SALIDA = "f_salida";
    public static final String COLUMN_OPCIONAL = "opcional";

    private BDDEstructura(){}
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE "+BDDEstructura.TABLE_NAME+ " (" +
                    BDDEstructura.COLUMN_CODIGO + " INTEGER PRIMARY KEY"+
                    BDDEstructura.COLUMN_REGISTRO_ENTRADA + " DATE NOT NULL, "+
                    BDDEstructura.COLUMN_REGISTRO_SALIDA + " DATE NOT NULL, "+
                    BDDEstructura.COLUMN_OPCIONAL + " VARCHAR(20) )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + BDDEstructura.TABLE_NAME;
}