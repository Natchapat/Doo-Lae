package com.example.spring_sama.doo_lae;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mynameismaxz on 2/3/15 AD.
 */

public class SendHTTP extends AsyncTask<String, Integer, Double> {

    public void postData(String idNumber, String strData){
        HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost("http://202.44.12.175/doolae-response/edit_medical.php");

        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("id",idNumber));
            nameValuePairs.add(new BasicNameValuePair("data",strData));
            Log.d("HTTPResponse", idNumber);
            Log.d("HTTPResponse", strData);
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));

            HttpResponse response = httpClient.execute(httpPost);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected Double doInBackground(String... params) {
        postData(params[0],params[1]);
        return null;
    }

}
