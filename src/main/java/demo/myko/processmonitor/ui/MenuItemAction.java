package demo.myko.processmonitor.ui;

import demo.myko.processmonitor.entity.RootTask;
import demo.myko.processmonitor.entity.Task;
import javafx.collections.FXCollections;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;

public class MenuItemAction {

    private static final String DESCRIPTION = "XML files (*.xml)";
    private static final String EXTENSION = "*.xml";

    public static RootTask importXmlFileAndShowDiff(Stage stage, Unmarshaller unmarshaller) {
        RootTask rootTask = new RootTask();
        try {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(DESCRIPTION, EXTENSION);
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(stage);
            rootTask = (RootTask) unmarshaller.unmarshal(file);

            Set<Task> oldTasks = rootTask.getTaskSet();

            TableViewConfig.table.setItems(FXCollections.observableList(new ArrayList<>(oldTasks)));
        } catch (JAXBException e) {
            System.out.println(e.getErrorCode());
        }
        return rootTask;
    }

    public static void exportXMlFile(Stage stage, Marshaller marshallerObj, RootTask rootTask) {
        try {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(DESCRIPTION, EXTENSION);
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(stage);
            PrintWriter writer = new PrintWriter(file);
            marshallerObj.marshal(rootTask, writer);
        } catch (JAXBException e) {
            System.out.println(e.getCause());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
