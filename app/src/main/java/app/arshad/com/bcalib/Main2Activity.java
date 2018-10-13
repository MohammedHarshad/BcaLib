package app.arshad.com.bcalib;

import android.app.ProgressDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Main2Activity extends AppCompatActivity {



    WebView wb2;
    ProgressDialog pg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        wb2 = (WebView) findViewById(R.id.wb);


        wb2.getSettings().setUseWideViewPort(true);
        wb2.getSettings().setLoadWithOverviewMode(true);
        wb2.getSettings().setJavaScriptEnabled(true);
        wb2.getSettings().setBuiltInZoomControls(true);
        wb2.getSettings().setDisplayZoomControls(false);
        wb2.getSettings().setAppCacheEnabled(true);
        wb2.getSettings().setPluginState(WebSettings.PluginState.ON);
      //  wb2.loadUrl("https://www.bcareflibrary.ml/");
        wb2.loadUrl("https://www.bcareflibrary.ml/");
        pg = new ProgressDialog(Main2Activity.this);
        pg.setTitle("Loading ...");
        pg.setMessage("Please Wait");
        pg.show();
    //    pg.setCancelable(false);
        Runnable progressRunnable = new Runnable() {

            @Override
            public void run() {
                pg.dismiss();

            }
        };

        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 11000);


    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
