package demo.myko.processmonitor;

import demo.myko.processmonitor.entity.RootTask;
import demo.myko.processmonitor.entity.Task;
import demo.myko.processmonitor.facade.TaskFacade;
import demo.myko.processmonitor.parser.SystemProcessParser;
import demo.myko.processmonitor.parser.impl.CsvTaskListParser;
import demo.myko.processmonitor.reader.SystemProcessReader;
import demo.myko.processmonitor.reader.impl.WindowsProcessReader;
import demo.myko.processmonitor.ui.MenuBarConfig;
import demo.myko.processmonitor.ui.MenuItemAction;
import demo.myko.processmonitor.ui.RootConfig;
import demo.myko.processmonitor.ui.TableViewConfig;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ProcessMonitor extends Application {

    private Set<Task> processes = new HashSet<>();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        MenuBar menuBar = MenuBarConfig.configureMenuBar(stage);
        TableView<Task> table = TableViewConfig.createAndConfigureTable();
        table.setItems(getUserList());
        BorderPane root = RootConfig.configRoot(menuBar, table);
        stage.setTitle("Process Monitor");
        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.show();
    }

    private ObservableList<Task> getUserList() {
        processes = TaskFacade.getTasks();
        ObservableList<Task> list = FXCollections.observableList(new ArrayList<>(processes));
        return list;
    }

}
