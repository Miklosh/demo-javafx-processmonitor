package demo.myko.processmonitor.parser;

import demo.myko.processmonitor.entity.Task;

import java.util.List;
import java.util.Set;

public interface SystemProcessParser {

    public Set<Task> parse(List<String> rawProcesses);

}
