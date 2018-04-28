package com.example.sourabh.postmessagemock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.sourabh.postmessagemock.mvcviews.MainScreenView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainScreenView mainScreenView = new MainScreenViewImp(getLayoutInflater(), this);
        setContentView(mainScreenView.getRootView());

        //Push up activity on keyboard open
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN
        );

        //Business Logic
        mainScreenView.setPostMessageListener(new MainScreenView.PostMessageListener() {
            @Override
            public void onPostMessage(String msg) {
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
