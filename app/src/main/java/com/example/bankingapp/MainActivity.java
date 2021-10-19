package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAllUsers, btnAllTransactions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    btnAllUsers = findViewById(R.id.users);
    btnAllTransactions = findViewById(R.id.transactions);
}

    public void showUsers(View view) {
        Intent intent = new Intent(this, UsersList.class);
        startActivity(intent);
    }

    public void showTransactions(View view) {
        Intent intent = new Intent(this, TransactionHistory.class);
        startActivity(intent);
    }
}