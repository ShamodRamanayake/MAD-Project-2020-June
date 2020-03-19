package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import Adapters.IncomeAdapter;
import Database.WalletDBhelper;
import Model.AddIncome;

public class Income_details extends AppCompatActivity implements IncomeAdapter.onIncomeListner{

    WalletDBhelper db;
    RecyclerView rv;
    EditText editText;

    private ArrayList<AddIncome> arrayList;
    IncomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_details);

        EditText editText = findViewById(R.id.edittext1);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) { filter(editable.toString()); }
        });



        db = new WalletDBhelper(this);

        rv = findViewById(R.id.recycleV);
        rv.setLayoutManager( new LinearLayoutManager(this));
        arrayList = db.readAllIncome();

        adapter = new IncomeAdapter(arrayList , this );
        rv.setAdapter(adapter);

        new ItemTouchHelper(itemTouchHelpercallback).attachToRecyclerView(rv);

    }
    private void filter(String text){
        ArrayList<AddIncome> filteredList = new ArrayList<>();

        for (AddIncome item : arrayList){
            if (item.getDate().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }

    ItemTouchHelper.SimpleCallback itemTouchHelpercallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            int deleteid = arrayList.get(viewHolder.getAdapterPosition()).getID();
            db.deleteIncome(deleteid);
            arrayList.remove(viewHolder.getAdapterPosition());
            adapter.notifyDataSetChanged();
           // adapter.setArrayList(arrayList);
            Toast.makeText(getApplicationContext(),"DELETED!" +  deleteid  ,Toast.LENGTH_LONG).show();
        }
    };

    public void addData1(View view){
        Intent intent = new Intent(Income_details.this,Daily.class);
        startActivity(intent);
    }
    public void addData2(View view){
        Intent intent = new Intent(Income_details.this,DashboardExpensesCate.class);
        startActivity(intent);
    }

    public void addData3(View view){
        Intent intent = new Intent(Income_details.this,DasboardIncomeCate.class);
        startActivity(intent);
    }

    public void addData4(View view) {
        Intent intent = new Intent(Income_details.this, My_Wallet_Repot.class);
        startActivity(intent);
    }
    public void addData5(View view){
        Intent intent = new Intent(Income_details.this, Add.class);
        startActivity(intent);
        }

    public void addData6(View view){
        Intent intent = new Intent(Income_details.this, Income_details.class);
        startActivity(intent);
    }

    @Override
    public void OnIncomeClick(int position) {
              AddIncome income = arrayList.get(position );
              Intent intent = new Intent( Income_details.this , EditIncome.class);
              intent.putExtra( "ID" , income.getID() );
              intent.putExtra( "Amount" , income.getIncomeAmount() );
              intent.putExtra( "Note" , income.getNote()   );
              startActivity(intent);
    }
}

