/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Asus
 */
class GitHub {
    
    private static String full(Reader read) throws IOException {
        StringBuilder builder = new StringBuilder();
        int cp;

        while ((cp = read.read()) != -1) {
            builder.append((char) cp);
        }
        return builder.toString();
    }

    public static JSONArray readUrl(String url) throws IOException, JSONException {
        InputStream inputStream = new URL(url).openStream();
        try {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %5s| %10s| %10s| %10s|\n","No.","Login ID","Number of Repositories","Number of Followers");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            BufferedReader read = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String text = full(read);
            JSONArray jsonArray = new JSONArray(text);
            return jsonArray;
        } finally {
            inputStream.close();
        }
    }

    public static JSONObject readOneUrl(String url) throws IOException, JSONException {
        InputStream inputStream = new URL(url).openStream();
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String text = full(read);
            JSONObject json = new JSONObject(text);
            return json;
        } finally {
            inputStream.close();
        }

    }

    public static LinkedList<data2> findAll() throws IOException, JSONException {

        LinkedList<data2> data = new LinkedList<data2>();

        JSONArray jsonArray = readUrl("https://api.github.com/users/zhamri/followers?access_token=3d1ca6930b12cb3704d6d6712a759300b0d0eb06");

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject jsonObject = jsonArray.getJSONObject(i);

            String link = jsonObject.optString("url");

            JSONObject jsonObject1 = readOneUrl(link+"?access_token=3d1ca6930b12cb3704d6d6712a759300b0d0eb06");


            String login = jsonObject1.optString("login");
            String Repo = jsonObject1.optString("public_repos");
            String Followers = jsonObject1.optString("followers");
            

            Thread thread = new Thread(() -> {
                //System.out.println("t-"+Thread.currentThread().getId()+" "+login + " " + t_Repo + " " + t_Followers + " " + t_Following + " " + githubLink);
                System.out.printf("| %-3s",Thread.currentThread().getName());
                System.out.printf("| %12s",login);
                System.out.printf("| %22s",Repo);
                System.out.printf("| %15s",Followers+"\n");
               
                data.add(new data2(login, Repo, Followers));
            });

            thread.setName(String.valueOf(i+1));
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        return data;
    }
    
}
