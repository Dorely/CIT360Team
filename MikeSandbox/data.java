package com.example.mike.httpurlcon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Mike on 2/26/2016.
 */
public class data {
    public String getdata() throws Exception {
        // this sends an HTTP request to get my Website and returns the HTML text
        URL url = new URL("http://www.easyhtmlcoding.net");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setReadTimeout(10000);
        con.setConnectTimeout(15000);
        con.setRequestMethod("POST");
        con.setDoInput(true);
        con.connect();
        readStream(con.getInputStream());
        return null;
    }

    private void readStream(InputStream in) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
