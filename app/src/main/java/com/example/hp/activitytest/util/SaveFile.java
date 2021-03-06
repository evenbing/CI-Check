package com.example.hp.activitytest.util;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SaveFile {

    public static boolean save(Context context, String name, String pass){
        try {
            File f=new File(context.getFilesDir(),"info.txt");
            FileOutputStream fos=new FileOutputStream(f);
            fos.write((name+"=="+pass).getBytes());
            fos.close();
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 获取保存的数据
     * @param context
     * @return
     */
    public static Map<String,String> getSaveFiles(Context context){

        File f=new File(context.getFilesDir(),"info.txt");
        try {
            FileInputStream fis=new FileInputStream(f);
            BufferedReader br=new BufferedReader(new InputStreamReader(fis));

            String str=br.readLine();
            String[] infos=str.split("==");
            Map<String,String> map=new HashMap<String,String>();
            map.put("username", infos[0]);
            map.put("userpass", infos[1]);


            return map;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

}
