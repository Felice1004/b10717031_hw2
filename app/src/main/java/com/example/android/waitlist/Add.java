package com.example.android.waitlist;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.waitlist.data.WaitlistContract;


public class Add extends AppCompatActivity {
    private static final String LOG_TAG = null;
    //      private static final String LOG_TAG = com.example.android.waitlist.Add.class.getSimpleName();
    private TextView tv_name,tv_people_number;
    private EditText edt_name,edt_people_number;
    private Button btn_ok, btn_cancel;
    String guestName;
    int peopleNum;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        tv_name = (TextView) findViewById(R.id.tv_name);
        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_people_number = (EditText) findViewById(R.id.edt_people_number);
        btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);

        //cancel功能
        btn_ok.setOnClickListener(new Button.OnClickListener() {



            @Override
            public void onClick(View v) {
                guestName = edt_name.getText().toString();
                peopleNum = Integer.parseInt(edt_people_number.getText().toString());
                Intent intent = new Intent(Add.this,MainActivity.class);
                intent.putExtra("name",guestName);
                intent.putExtra("size",peopleNum);
//                intent.putExtra("sizeAndName",bag);
                startActivity(intent);
            }
        });

//cancel功能
        btn_cancel.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_name.setText("");
                edt_people_number.setText("");
            }
        });
    }

//    public void addToWaitlist(View view) {
//        if (edt_name.getText().length() == 0 ||
//                edt_people_number.getText().length() == 0) {
//            return;
//        }
//        //default party size to 1
//        int partySize = 1;
//        try {
//            //mNewPartyCountEditText inputType="number", so this should always work
//            partySize = Integer.parseInt(edt_people_number.getText().toString());
//        } catch (NumberFormatException ex) {
//            Log.e(LOG_TAG, "Failed to parse party size text to number: " + ex.getMessage());
//        }
//
//        // Add guest info to mDb
//        addNewGuest(edt_name.getText().toString(), partySize);
//
//        // Update the cursor in the adapter to trigger UI to display the new list
//        mAdapter.swapCursor(getAllGuests());
//
//        //clear UI text fields
//        edt_people_number.clearFocus();
//        edt_name.getText().clear();
//        edt_people_number.getText().clear();
//    }
//
//
//    private long addNewGuest(String name, int partySize) {
//        ContentValues cv = new ContentValues();
//        cv.put(WaitlistContract.WaitlistEntry.COLUMN_GUEST_NAME, name);
//        cv.put(WaitlistContract.WaitlistEntry.COLUMN_PARTY_SIZE, partySize);
//        return mDb.insert(WaitlistContract.WaitlistEntry.TABLE_NAME, null, cv);
//    }
//
//    private Cursor getAllGuests() {
//        return mDb.query(
//                WaitlistContract.WaitlistEntry.TABLE_NAME,
//                null,
//                null,
//                null,
//                null,
//                null,
//                WaitlistContract.WaitlistEntry.COLUMN_TIMESTAMP
//        );
//    }


}
