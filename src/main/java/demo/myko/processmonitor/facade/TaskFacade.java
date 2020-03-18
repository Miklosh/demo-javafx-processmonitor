package demo.myko.processmonitor.facade;

import demo.myko.processmonitor.entity.Task;
import demo.myko.processmonitor.parser.SystemProcessParser;
import demo.myko.processmonitor.parser.impl.CsvTaskListParser;
import demo.myko.processmonitor.reader.SystemProcessReader;
import demo.myko.processmonitor.reader.impl.WindowsProcessReader;

import java.util.List;
import java.util.Set;

public class TaskFacade {

    public static Set<Task> getTasks() {
        SystemProcessParser parser = new CsvTaskListParser();
        SystemProcessReader reader = new WindowsProcessReader();
        List<String> rawProcess = reader.read();
        return parser.parse(rawProcess);
    }

}
