package com.gearhead;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class BaseballGame {
    public static void main(String[] args) {
        BaseballGame bg = new BaseballGame();

        System.out.println("MasterAnswer : 123");
        bg.play("123");
    }

    public void play(String masterAnswer){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(true){
                System.out.print("PlayerAnswer : ");
                String playerAnswer = br.readLine();

                String[] ma = masterAnswer.split("");
                String[] pa = playerAnswer.split("");
                if(result(ma, pa)){
                    break;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean result(String[] ma, String[] pa){
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
        if(strikeCount == 0 && ballCount == 0){
            System.out.println("(OUTPUT) (null)");
        }
        else{
            System.out.println("(OUTPUT) " + (strikeCount > 0 ? strikeCount+"S" : "") + (ballCount > 0 ? ballCount+"B" : ""));
        }

        return strikeCount == ma.length;
    }
}