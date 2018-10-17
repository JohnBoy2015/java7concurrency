package com.cicada.chapt01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {

        Thread threads [] =new Thread[10];
        Thread.State status[] =new Thread.State[10];
        for (int i = 0; i <10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if(i%2==0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread - "+i);
        }
        try(FileWriter fileWriter =new FileWriter(".\\data\\log.txt"); PrintWriter pw =new PrintWriter(fileWriter);) {
            for (int i = 0; i <10; i++) {
                pw.println("Main : Status of Thread "+i+" "+threads[i].getState());
                status[i]=threads[i].getState();
            }
            for(int i=0;i<10;i++){
                threads[i].start();
            }
            boolean finish =false;
            while (!finish){
                for(int i=0;i<10;i++){
                    if(threads[i].getState()!=status[i]){
                        writeThreadInfo(pw,threads[i],status[i]);
                        status[i]=threads[i].getState();
                    }
                }
                finish = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } ;




    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
    }
}
