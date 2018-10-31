package com.example.peterson.llamar.Constantes;

public class Constantes {

    //Constantes campos tabla llamadas
    public static final String TABLA_LLAMADAS = "llamadas";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NUMERO = "numero";

    public static final String CREAR_TABLA_LLAMADA = "CREATE TABLE " + TABLA_LLAMADAS + " (" +
            CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            CAMPO_NUMERO + " TEXT NOT NULL)";

    public static final String BORRAR_TABLA_LLAMADA = "DROP TABLE IF EXISTS " + TABLA_LLAMADAS;
}
