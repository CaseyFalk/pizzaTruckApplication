package com.grizzhacks.pizzatruck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ifttt.Applet;
import com.ifttt.ErrorResponse;
import com.ifttt.IftttApiClient;
import com.ifttt.api.AppletsApi;
import com.ifttt.api.PendingResult;

import java.util.List;

public class StopActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);

        buttonStop = (Button) findViewById(R.id.buttonStop);

        //attaching listener to button
        buttonStop.setOnClickListener(this);
    }

    private void onButtonStop() {
        AppletsApi appletsApi = IftttApiClient.getInstance().appletsApi();
        appletsApi.listApplets("GWVfs5b4GzoddG0cudz2WutzYjnFBGj5vwx5kBh3OaZIfo6rZWSEfuTGPvHMlYnE", AppletsApi.Platform.android, AppletsApi.Order.enabled_count_asc)
                .execute(new PendingResult.ResultCallback<List<Applet>>() {
                    @Override
                    public void onSuccess(List<Applet> applets) {
                        finish();
                        startActivity(new Intent(StopActivity.this, PizzaReadyActivity.class));
                    }

                    @Override
                    public void onFailure(ErrorResponse errorResponse) {
                        Toast.makeText(StopActivity.this, "FAILED, CONTACT STORE FOR DETAILS",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v == buttonStop) {
            onButtonStop();
        }
    }

}
