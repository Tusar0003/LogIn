package com.example.login.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.api.ApiClient;
import com.example.login.api.ApiService;
import com.example.login.model.GetResponse;
import com.example.login.model.LogInResponse;
import com.example.login.model.User;

import org.json.JSONStringer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText userNameEditText = findViewById(R.id.edit_text_user_name);
        final EditText passwordEditText = findViewById(R.id.edit_text_password);

        findViewById(R.id.button_log_in).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(userNameEditText.getText()) && !TextUtils.isEmpty(passwordEditText.getText())) {
//                    insert(userNameEditText.getText().toString(), passwordEditText.getText().toString());
                    get();
                } else {
                    Toast.makeText(MainActivity.this, "Field can not be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void insert(String userName, String password) {
        ApiService apiService = ApiClient.getApiClient().create(ApiService.class);
        Call<String> call = apiService.logIn(userName, password);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Successful.", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "onResponse: " + response);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void get() {
        ApiService apiService = ApiClient.getApiClient().create(ApiService.class);
        Call<List<GetResponse>> call = apiService.getUser("1");
        call.enqueue(new Callback<List<GetResponse>>() {
            @Override
            public void onResponse(Call<List<GetResponse>> call, Response<List<GetResponse>> response) {
                if (response.isSuccessful()) {
                    Log.e(TAG, "onResponse: " + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<GetResponse>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
