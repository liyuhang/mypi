package com.rayon.framework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Description:<br/>
 *
 * @author Rayon
 * @version 0.0.1
 * @date 2017/10/30
 * <p>
 * History:2017/10/30 Rayon 初始创建
 */
public class ExecThread extends Thread{


    private String uuid;
    private String cmd;
    private Process process;
    private boolean isStop;

    public ExecThread(String cmd){
        this.cmd = cmd;
        this.uuid = UUID.randomUUID().toString();
        this.isStop=false;
    }

    public void run(){
        try {
            process = Runtime.getRuntime().exec(this.cmd);
            while(!isStop){
                if(!process.isAlive()){
                    break;
                }
                sleep(1000);
            }
            if(process.isAlive()){
                process.destroy();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public boolean inputToProcess(String c){
        if(this.isStop){
            return false;
        }
        PrintWriter print = new PrintWriter(process.getOutputStream());
        print.println(c);
        print.flush();
        try{
            Thread.sleep(100);
        }catch(Exception ex){

        }
        return true;
    }

    public void stopExce(){
        this.isStop = true;
    }

    public List<String> readLineFromProcess(){
        if(this.isStop){
            return new ArrayList<>();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        List<String>result = new ArrayList<>();
        try {

            String line = null;
            while(reader.ready() && (line=reader.readLine()) != null){
                result.add(line);
            }
        }catch (Exception ex){

        }
        return result;
    }


    public String getUuid() {
        return uuid;
    }


    public String getCmd() {
        return cmd;
    }
}
