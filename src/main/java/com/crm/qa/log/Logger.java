package com.crm.qa.log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Logger {

    public static String OutputFileName= getDateTimeByFormat(new Date(),"yyyy-MM-dd_HHmmss");
    private static OutputStreamWriter outputStreamWriter;
    private static String logFileName;

    public static boolean LogFlag = true;

    public Logger(){

    }

    private static void WriteLog(String logEntry){
        try {
            logFileName = ".\\Log" + "\\" + OutputFileName + ".log";
            if (outputStreamWriter == null){
                File logFile = new File(logFileName);
             if (!logFile.exists())
                 logFile.createNewFile();
             outputStreamWriter = new OutputStreamWriter(new FileOutputStream(logFile),"utf-8");

            }
            outputStreamWriter.write(logEntry,0,logEntry.length());
            outputStreamWriter.flush();

        } catch (Exception e) {
            System.out.println(com.crm.qa.log.LogType.LogTypeName.ERROR.toString()+":failed to write the file" + logFileName);
            e.printStackTrace();
        }
    }

    private static String getDateTimeByFormat(Date date,String format){
        SimpleDateFormat df = new SimpleDateFormat(format);

        return df.format(date);
    }

    public  static void Output(com.crm.qa.log.LogType.LogTypeName logTypeName, String logMessage){

        Date date = new Date();
        String logTime = getDateTimeByFormat(date,"yyyy-MM-dd HH:mm:ss.SSS");
        String logEntry = logTime + " " + logTypeName.name() + ": " + logMessage + "\r\n";

        //定义日志输出开关，True输出；
        if (LogFlag)
            WriteLog(logEntry);
    }
}
