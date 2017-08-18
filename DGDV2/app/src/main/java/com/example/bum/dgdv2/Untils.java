package com.example.bum.dgdv2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Bum on 17-Aug-17.
 */

public class Untils {
    public static String paserTranslate(String jsonObject){
        String str2 = null;
        String str3 = null;
        String str4 = "";
        JSONObject localJSONObject = null;
        try {
            localJSONObject = new JSONObject(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < localJSONObject.length(); i++) {
            StringBuilder sb;
            int j;
            if (i == 0) {
                JSONArray w;
                try {
                    w = localJSONObject.getJSONArray("sentences");
                    sb = new StringBuilder();
                    Logger.d("......" + w.length());
                    for (j = 0; j < w.length(); j++) {
                        sb.append(w.getJSONObject(j).getString("trans"));
                    }
                    str2 = sb.toString();
                    if (localJSONObject.has("dict")) {
                        str3 = localJSONObject.getJSONArray("dict").getJSONObject(0).getJSONArray("terms").getString(0);
                        str4 = new StringBuilder(String.valueOf(str2)).append("\n\n").append(str3).toString();
                    } else {
                        str4 = str2;
                    }
                    System.out.println(str2);
                } catch (Exception e) {
                    try {
                        w = localJSONObject.getJSONArray("sentences");
                        sb = new StringBuilder();
                        for (j = 0; j < w.length() - 1; j++) {
                            sb.append(w.getJSONObject(j).getString("trans"));
                        }
                        str2 = sb.toString();
                        if (localJSONObject.has("dict")) {
                            str3 = localJSONObject.getJSONArray("dict").getJSONObject(0).getJSONArray("terms").getString(0);
                            str4 = new StringBuilder(String.valueOf(str2)).append("\n\n").append(str3).toString();
                        } else {
                            str4 = str2;
                        }
                        System.out.println(str2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            // TODO: option 2
                              /* web.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        MyAsyncTask myAsyncTask = new MyAsyncTask();
                                        myAsyncTask.execute(input);
                                    }
                                });*/

                        } catch (Exception e3) {
                        }
                        str3 = "";
                    }
                }
            } else if (i == 1) {
                try {
                    JSONArray str5 = localJSONObject.getJSONArray("dict").getJSONObject(1).getJSONArray("terms");
                    sb = new StringBuilder();
                    for (j = 0; j < str5.length(); j++) {
                        sb.append(str5.getString(j) + "\n");
                    }
                    str4 = new StringBuilder(String.valueOf(str2)).append("\n\n").append(str3).append("\n").append(sb.toString()).toString();
                } catch (Exception e4) {
                }
            }
        }
        return str4;
    }
}
