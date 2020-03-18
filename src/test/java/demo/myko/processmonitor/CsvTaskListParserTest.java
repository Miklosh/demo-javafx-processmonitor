package demo.myko.processmonitor;

import demo.myko.processmonitor.entity.Task;
import demo.myko.processmonitor.parser.SystemProcessParser;
import demo.myko.processmonitor.parser.impl.CsvTaskListParser;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CsvTaskListParserTest {

    private static String CSV_TEST_STRING = "System Idle Process,0,Services,0,8";
    private static String CSV_TEST_STRING_FLOAT_NUMBER = "System,4,Services,0,6,136";
    private List<String> rawProcesses = new ArrayList<>();
    private List<String> rawProcessesWithDuplicates = new ArrayList<>();
    SystemProcessParser parser = new CsvTaskListParser();

    @Before
    public void init() {
        rawProcesses.add("System Idle Process,0,Services,0,8");
        rawProcesses.add("System,4,Services,0,4,024");
        rawProcesses.add("Registry,96,Services,0,43,308");
        rawProcesses.add("smss.exe,432,Services,0,764");

        rawProcessesWithDuplicates.add("Registry,96,Services,0,43,308");
        rawProcessesWithDuplicates.add("Registry,96,Services,0,93,437");
    }

    @Test
    public void assertThatDuplicatesAreReducedToSingleField() {
        assertEquals(2, rawProcessesWithDuplicates.size());
        Set<Task> processes = parser.parse(rawProcessesWithDuplicates);
        assertNotNull(processes);
        assertEquals(1, processes.size());
        assertEquals(136.745f, processes.iterator().next().getUsedMemory(), 0.001);
    }

    @Test
    public void assertParsedListExistsANdNotEmpty() {
        assertEquals(4, rawProcesses.size());
        Set<Task> processes = parser.parse(rawProcesses);
        assertNotNull(processes);
        processes.stream().forEach(System.out::println);
        assertEquals(4, processes.size());
    }

    @Test
    public void csvStringParseIntoPartsCorrectly() {
        String[] splitResult = CSV_TEST_STRING.split(",");
        for (String s : splitResult) System.out.println(s);
        assertEquals("System Idle Process", splitResult[0]);
        assertEquals("0", splitResult[1]);
        assertEquals("Services", splitResult[2]);
        assertEquals("0", splitResult[3]);
        assertEquals("8", splitResult[4]);
        float castResult = Float.parseFloat(splitResult[4]);
        assertNotNull(castResult);
    }

    @Test
    public void csvStringGetFloatNumber() {
        String[] splitResult = CSV_TEST_STRING_FLOAT_NUMBER.split(",");
        StringBuffer floatString = new StringBuffer(splitResult[4] + "." + splitResult[5]);
        System.out.println(floatString.toString());
        float processMemory = Float.parseFloat(floatString.toString());
        System.out.println(processMemory);
    }

}
