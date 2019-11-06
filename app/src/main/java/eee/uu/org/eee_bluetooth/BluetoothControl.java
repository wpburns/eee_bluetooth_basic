package eee.uu.org.eee_bluetooth;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * Created by williamburns on 19/11/18.
 */
public class BluetoothControl extends Activity {

    Button btnDis;
    TextView txtHR;
    String address = null;
    private ProgressDialog progress;

    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    private boolean isBtConnected = false;

    //SPP UUID. Look for it
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); // Standard/Base UUID

    StringBuilder sb = new StringBuilder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_screen);

        Intent i = getIntent();
        address = i.getStringExtra(DeviceList.EXTRA_ADDRESS); // Receive the address of the bluetooth device

        new connectBT().execute();

        btnDis = (Button) findViewById(R.id.btnDisconnect);
        txtHR = (TextView) findViewById(R.id.txtHR);

        btnDis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disconnectBT(); //close connection
            }
        });
    }

    private void disconnectBT()
    {
//        Disconnect Code
    }

    private void displayMessage(String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    private class connectBT extends AsyncTask<Void, Void, Void> {
        private boolean ConnectSuccess = true; //if it's here, it's almost connected

        @Override
        protected void onPreExecute() {
            // show a progress dialog
        }

        @Override
        protected Void doInBackground(Void... devices) //while the progress dialog is shown, the connection is done in background
        {
//            doInBackground code

            return null;
        }

        @Override
        protected void onPostExecute(Void result)
        {
//            onPostExecute Code
        }
    }


        private class MyTask extends AsyncTask<BluetoothSocket, Void,StringBuilder > {

            @Override
            protected StringBuilder doInBackground(BluetoothSocket... params) {
//                StringBuilder code
                return sb;
            }

            @Override
            protected void onPostExecute(StringBuilder result) {
                super.onPostExecute(result);
            }
        }

}
