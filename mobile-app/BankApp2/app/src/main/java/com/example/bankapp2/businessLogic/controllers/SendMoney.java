package com.example.bankapp2.businessLogic.controllers;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.bankapp2.R;
import com.example.bankapp2.dataAccess.models.Account;
import com.example.bankapp2.dataAccess.repositories.AccountRepository;


public class SendMoney extends AppCompatActivity {


    private EditText v_cuenta;
    private EditText v_monto;
    private Button v_enviar;
    private int idcuenta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienvenido_ui);
        v_cuenta = (EditText) findViewById(R.id.txt_account);
        v_monto = (EditText) findViewById(R.id.txt_amount);
        v_enviar = (Button) findViewById(R.id.btn_enviar);

        v_enviar.setOnClickListener((View.OnClickListener) this);

        idcuenta = 0;
        Intent intent = getIntent();
        idcuenta = intent.getIntExtra("id_cuenta", 0);
    }

    public void onClick(View view) {
        if (view == findViewById(R.id.btn_enviar)){
            AccountRepository repo = new AccountRepository();
            Account account = new Account();
            Account account2 = new Account();
            account = repo.getAccountById(idcuenta);
                if(account.getSaldo()>= Integer.parseInt(v_monto.getText().toString())) //Si hay dinero suficiente para retirar
                    {
                    account.setSaldo(account.getSaldo() - Integer.parseInt(v_monto.getText().toString()));
                    account2.setSaldo(account2.getSaldo()+Integer.parseInt(v_monto.getText().toString()));
                        Toast.makeText(getApplicationContext(), "TRANSACCIÓN REALIZADA", Toast.LENGTH_SHORT).show();
            } else {
                    Toast.makeText(getApplicationContext(), "NO HAY DINERO SUFICIENTE", Toast.LENGTH_SHORT).show();
                }

            }
        }
}


