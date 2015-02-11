package com.example.spring_sama.doo_lae;

/**
 * Created by Spring-Sama on 11-Feb-15.
 */
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DownloadData extends AsyncTask<String,Void , String>{ //

    String myXMLData="";
    boolean flag = true;


    @Override
    protected String doInBackground(String... urls) {
        try{
            myXMLData = downloadXML(urls[0]);

        }catch (IOException e){
            return "Unable to download the XML file.";
        }
        return myXMLData;
    }

    protected void onPostExecute(String result){
        Log.d("OnPostExecute", myXMLData);
    }

    private String downloadXML(String theUrl) throws IOException{

        try {
            HttpParams httpParameters = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParameters, 10000);
            HttpConnectionParams.setSoTimeout(httpParameters, 10000);

            HttpClient client = new DefaultHttpClient(httpParameters);
            //String link = "http://202.44.12.175/doolae-response/elder_check_login.php?eldername=BayMax&homename=Home-A&macaddress=78:24:af:b2:55:31&phonename=ASUS_T00I";
            HttpGet request = new HttpGet(theUrl);
            HttpResponse response = client.execute(request);

            BufferedReader in = new BufferedReader
                    (new InputStreamReader(response.getEntity().getContent()));

            StringBuffer sb = new StringBuffer("");
            String line="";
            while ((line = in.readLine()) != null) {
                sb.append(line);
                break;
            }
            in.close();
            flag = false;
            return sb.toString();
        }
        catch (IOException e) {
            Log.e("Tag", "Could not get HTML: " + e.getMessage());
            return e.getMessage();
        }
    }
}