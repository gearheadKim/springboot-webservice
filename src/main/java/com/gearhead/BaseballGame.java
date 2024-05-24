package com.gearhead;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaseballGame {
    public String getScore( String given, String input ){
        String[] ma = given.split("");
        String[] pa = input.split("");

        //채점시작
        int strikeCount = 0;
        int ballCount = 0;
        for(int i = 0; i < ma.length; i++){
            for(int j = 0; j < pa.length; j++){
                if(ma[i].equals(pa[j])){
                    if(i == j){
                        strikeCount++;
                    }
                    else{
                        ballCount++;
                    }
                }
            }
        }

        //결과출력
        String strResult = "";
        if(strikeCount == 0 && ballCount == 0){
            strResult = "(OUTPUT) (null)";
        }
        else{
            strResult = "(OUTPUT) " + (strikeCount > 0 ? strikeCount+"S" : "") + (ballCount > 0 ? ballCount+"B" : "");
        }

        return strResult;
    }
}