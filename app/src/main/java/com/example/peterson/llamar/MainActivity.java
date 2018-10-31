package com.example.peterson.llamar;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.peterson.llamar.Constantes.Constantes;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView telefono;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    ImageButton btnLlamar, btnBuscar,btnBorrar;
    String mostrar,numeroTelefono;
    private Intent intentLlamar;
    private final int PHONE_CALL_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btnLlamar = findViewById(R.id.imageButtonLlamar);
        btnBuscar = findViewById(R.id.imageButtonBuscar);
        btnBorrar = findViewById(R.id.imageButtonBorrar);
        telefono = findViewById(R.id.textView);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = telefono.getText().toString();
                mostrar += 0;
                telefono.setText(mostrar);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = telefono.getText().toString();
                mostrar += 1;
                telefono.setText(mostrar);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = telefono.getText().toString();
                mostrar += 2;
                telefono.setText(mostrar);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = telefono.getText().toString();
                mostrar += 3;
                telefono.setText(mostrar);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = telefono.getText().toString();
                mostrar += 4;
                telefono.setText(mostrar);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = telefono.getText().toString();
                mostrar += 5;
                telefono.setText(mostrar);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = telefono.getText().toString();
                mostrar += 6;
                telefono.setText(mostrar);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = telefono.getText().toString();
                mostrar += 7;
                telefono.setText(mostrar);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = telefono.getText().toString();
                mostrar += 8;
                telefono.setText(mostrar);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = telefono.getText().toString();
                mostrar += 9;
                telefono.setText(mostrar);
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = telefono.getText().toString();
                if (mostrar != "" && !mostrar.isEmpty()) {
                    mostrar = mostrar.substring(0, mostrar.length() - 1);
                    telefono.setText(mostrar);
                }
            }
        });

        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroTelefono = telefono.getText().toString();
                intentLlamar = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numeroTelefono));
                if (numeroTelefono != null) {
                    //Comprobar version actual de android
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                        //Comprobar si ha ceptado, ha denegado o nunca se ha pregunatdo
                        if (CheckPermission(Manifest.permission.CALL_PHONE)) {
                            registrarLlamada(numeroTelefono);
                            intentLlamar = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numeroTelefono));
                            startActivity(intentLlamar);
                        } else {
                            //No ha aceptado o es la primera vez que se pregunta
                            if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
                                //no se ha preguntado aún
                                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PHONE_CALL_CODE);
                            } else {
                                //Ha denegado
                                Toast.makeText(MainActivity.this, "Please enable the request permission", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                i.addCategory(Intent.CATEGORY_DEFAULT);
                                i.setData(Uri.parse("package: " + getPackageName()));
                                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                                startActivity(i);
                            }
                        }
                    } else {
                        OlderVersions(numeroTelefono);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Insert a phone number", Toast.LENGTH_SHORT).show();
                }
            }
            private void OlderVersions(String phoneNumber) {
                if (CheckPermission(Manifest.permission.CALL_PHONE)) {
                    startActivity(intentLlamar);
                    registrarLlamada(numeroTelefono);
                } else {
                    Toast.makeText(MainActivity.this, "You decline access", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void registrarLlamada(String phoneNumber) {
        ConexionSQLiteHelper con = new ConexionSQLiteHelper(this, "llamarBD", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constantes.CAMPO_NUMERO, phoneNumber);

        db.insert(Constantes.TABLA_LLAMADAS, Constantes.CAMPO_ID, values);

        db.close();
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //Caso del teléfono
        switch (requestCode) {
            case PHONE_CALL_CODE:
                String permission = permissions[0];
                int result = grantResults[0];
                if (permission.equals(Manifest.permission.CALL_PHONE)) {
                    //Comprobar si ha sido aceptado o denegado la petición del permiso
                    if (result == PackageManager.PERMISSION_GRANTED) {
                        //Concedio permiso
                        intentLlamar = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numeroTelefono));
                        startActivity(intentLlamar);
                    } else {
                        //No concedio permiso
                        Toast.makeText(MainActivity.this, "You declined the access", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }
    }

    private boolean CheckPermission(String permission) {
        int result = this.checkCallingOrSelfPermission(permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }
}
