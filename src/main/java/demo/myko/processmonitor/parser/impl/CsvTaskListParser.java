package demo.myko.processmonitor.parser.impl;

import demo.myko.processmonitor.entity.Task;
import demo.myko.processmonitor.parser.SystemProcessParser;

import java.util.*;

public class CsvTaskListParser implements SystemProcessParser {

    public Set<Task> parse(List<String> rawProcesses) {
        Map<String, Task> processes = new HashMap<>();
        for (String rawCsvString : rawProcesses) {
            Task process = parseCsvString(rawCsvString);
            if (processes.containsKey(process.getName())) {
                Task processForUpdate = processes.get(process.getName());
                processForUpdate.setUsedMemory(process.getUsedMemory() + processForUpdate.getUsedMemory());
            } else {
                processes.put(process.getName(), process);
            }
        }
        return new HashSet<>(processes.values());
    }

    private Task parseCsvString(String csvString) {
        String[] parsedString = csvString.split(",");
        String processName = parsedString[0];
        String processPID = parsedString[1];
        float processUsedMemory = getProcessUsedMemory(parsedString);
        return new Task(processName, processPID, processUsedMemory);
    }

    private float getProcessUsedMemory(String[] stringArr) {
        float result;
        if (stringArr.length > 5) {
            // case for float number
            result = Float.parseFloat(stringArr[4] + "." +stringArr[5]);
        } else {
            result = Float.parseFloat(stringArr[4]);
        }
        return result;
    }
}
