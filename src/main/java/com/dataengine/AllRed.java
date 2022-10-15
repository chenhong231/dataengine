package com.dataengine;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class AllRed {

    private static String fold= "F:\\stockdata\\ÈýÏßºì\\";



    private static String oldFile = fold + "20200731.txt";

    private static String newFile = fold + "20200803.txt";

    public static void main(String[] args) throws Exception {

        Set<StockInfo> oldSet = getList(oldFile);

        Set<StockInfo> newSet = getList(newFile);

        for(StockInfo newStock : newSet) {

            if(!oldSet.contains(newStock)) {
                System.out.println(newStock.getId() + "    " + newStock.getName()) ;
            }
        }
    }

    private static Set<StockInfo> getList(String fileName) throws Exception {
        Set<StockInfo> set = new HashSet<StockInfo>();

        FileInputStream fis = new FileInputStream(fileName);

        InputStreamReader isr = new InputStreamReader(fis, "gbk");
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {

            String[] value = line.split("\t");

            StockInfo info = new StockInfo();
            info.setId(value[0]);
            info.setName(value[1]);

            set.add(info);
        }

        br.close();
        return set;
    }
}
