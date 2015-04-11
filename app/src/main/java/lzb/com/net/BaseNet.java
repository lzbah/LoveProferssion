package lzb.com.net;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;


/**
 * Created by lzb92 on 2015/4/11.
 */
public class BaseNet {
    public BaseNet(final String charset, final HttpMethod method, final SuccessCallBack successCallBack, final FailCallBack failCallBack, final String url, final String... parms) {

        new AsyncTask<Void,Void,String>(){

            @Override
            protected String doInBackground(Void... params) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < parms.length; i += 2) {
                    sb.append(parms[i]).append("=").append(parms[i + 1]).append("&");
                }
                try {
                    URLConnection urlConnection;
                    if (method == HttpMethod.POST) {
                        urlConnection = new URL(url).openConnection();
                        urlConnection.getDoInput();
                        urlConnection.setDoInput(true);

                        OutputStream os = urlConnection.getOutputStream();
                        os.write(sb.toString().getBytes(charset));
                        os.flush();
                    } else {
                        urlConnection = new URL(url + "?" + sb.toString()).openConnection();
                        urlConnection.getDoInput();
                        urlConnection.setDoInput(true);
                    }

                    InputStream input=urlConnection.getInputStream();
                    BufferedReader bf=new BufferedReader(new InputStreamReader(input,charset));
                    StringBuffer sb1=new StringBuffer();
                    String line;
                    while ((line=bf.readLine())!=null){
                        sb1.append(line);
                    }
                    return sb1.toString();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {

                if(s!=null){
                    successCallBack.success(s);
                }else{
                    failCallBack.fail();
                }
                super.onPostExecute(s);
            }
        }.execute();

    }

    public static interface SuccessCallBack {
        public void success(String resultStr);
    }

    public static interface FailCallBack {
        public void fail();
    }
}

