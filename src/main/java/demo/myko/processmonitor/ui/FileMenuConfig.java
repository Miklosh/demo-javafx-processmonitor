package demo.myko.processmonitor.ui;

import demo.myko.processmonitor.entity.RootTask;
import demo.myko.processmonitor.facade.TaskFacade;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class FileMenuConfig {

    public static Menu configureFileMenu(Stage stage) {
        Menu fileMenu = new Menu("File");
        try {
            RootTask rootTask = new RootTask(TaskFacade.getTasks());
            JAXBContext contextObj = JAXBContext.newInstance(RootTask.class);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Unmarshaller unmarshaller = contextObj.createUnmarshaller();
            MenuItem exportMenuItem = new MenuItem("Export");
            MenuItem importMenuItem = new MenuItem("Import");

            exportMenuItem.setOnAction(event -> MenuItemAction.exportXMlFile(stage, marshallerObj, rootTask));
            importMenuItem.setOnAction(event -> MenuItemAction.importXmlFileAndShowDiff(stage, unmarshaller));

            fileMenu.getItems().addAll(exportMenuItem, importMenuItem);
        } catch (JAXBException e) {
            System.out.println(e.getErrorCode());
        }
        return fileMenu;
    }

}
