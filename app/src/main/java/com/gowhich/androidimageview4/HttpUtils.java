package com.gowhich.androidimageview4;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by durban126 on 16/9/3.
 */
public class HttpUtils {
    private static final String URL_PATH = "http://img3.doubanio.com/view/dale-online/dale_ad/public/65b481f183f5b79.jpg";

    public HttpUtils() {

    }

    public static InputStream getImageViewInputStream() {
        InputStream inputStream = null;
        try {
            URL url = new URL(URL_PATH);
            if (url != null) {
                Log.i("HttpUtils", "开始LoadingImage");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(3000);//设置超时3秒钟
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                int response_code = httpURLConnection.getResponseCode();
                if (response_code == 200) {
                    inputStream = httpURLConnection.getInputStream();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("HttpUtils", "结束LoadingImage");
        return inputStream;
    }

    public static byte[] getImageViewArray(){
        byte[] data = new byte[0];
        InputStream inputStream = null;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try{
            URL url = new URL(URL_PATH);
            if (url != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(3000);//设置超时3秒钟
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                int response_code = httpURLConnection.getResponseCode();
                int len = 0;
                byte[] bData = new byte[1024];
                if (response_code == 200) {
                    inputStream = httpURLConnection.getInputStream();

                    while((len = inputStream.read(bData)) != -1){
                        outputStream.write(bData, 0, len);
                    }

                    data = outputStream.toByteArray();
                }
            }
        }catch(Exception e){

        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {

                }
            }
        }

        return data;
    }
}
