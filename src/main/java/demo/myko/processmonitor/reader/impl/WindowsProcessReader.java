package demo.myko.processmonitor.reader.impl;

import demo.myko.processmonitor.reader.SystemProcessReader;
import demo.myko.processmonitor.util.Command;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WindowsProcessReader implements SystemProcessReader {

    public List<String> read() {
        List<String> processesCSVList = new ArrayList<String>();
        try {
            String line;
            java.lang.Process systemProcess = Runtime.getRuntime().exec(Command.TASKLIST_CSV);
            BufferedReader input = new BufferedReader(new InputStreamReader(systemProcess.getInputStream()));
            while ((line = input.readLine()) != null) {
                String cleanedLine = line.replace("\"", "");
                String cleanedLine2 = cleanedLine.replace("K", "").trim();
                processesCSVList.add(cleanedLine2);
            }
            input.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return processesCSVList;
    }
}
