package demo.myko.processmonitor;

import demo.myko.processmonitor.reader.SystemProcessReader;
import demo.myko.processmonitor.reader.impl.WindowsProcessReader;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class WindowsProcessReaderTest {

    Logger logger = Logger.getLogger(WindowsProcessReaderTest.class.getName());

    @Test
    public void taskListNotEmpty() {
        SystemProcessReader reader = new WindowsProcessReader();
        List<String> processesCSVList = reader.read();
        assertNotNull(processesCSVList);
//        for (String s : processesCSVList) System.out.println(s);
        assertNotEquals(0, processesCSVList.size());
    }

}
