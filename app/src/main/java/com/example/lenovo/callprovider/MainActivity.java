package com.example.lenovo.callprovider;

import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.provider.CallLog.CONTENT_URI;

public class MainActivity extends AppCompatActivity {

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=(TextView)findViewById(R.id.txt);

        Cursor c=getCallLog();
        String cad="";
        while (c.moveToNext()){
            cad+="Tipo: "+c.getString(0)+" Fecha: "+c.getString(1)+" Numero: "+c.getString(2)+"\n";
        }
        txt.setText(cad);
    }

    public Cursor getCallLog(){
        Uri uri=Uri.parse("content://call_log/calls");
        return getContentResolver().query(
                uri,//URI
 /*Proyecion*/  new String[]{CallLog.Calls.TYPE, CallLog.Calls.DATE, CallLog.Calls.NUMBER},
 /*Where*/      null,
                null,
 /*Order*/      null
        );
    }
}
