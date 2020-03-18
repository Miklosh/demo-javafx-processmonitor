package demo.myko.processmonitor.ui;

import demo.myko.processmonitor.entity.Task;
import demo.myko.processmonitor.parser.SystemProcessParser;
import demo.myko.processmonitor.parser.impl.CsvTaskListParser;
import demo.myko.processmonitor.reader.SystemProcessReader;
import demo.myko.processmonitor.reader.impl.WindowsProcessReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewConfig {

    public static TableView<Task> table = new TableView<Task>();

    public static TableView<Task> createAndConfigureTable() {
        TableColumn<Task, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Task, String> pidColumn = new TableColumn<>("PID");
        TableColumn<Task, Float> memoryColumn = new TableColumn<>("Memory Used");
        TableColumn<Task, String> diffColumn = new TableColumn<>("Diff");
        diffColumn.setVisible(false);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        pidColumn.setCellValueFactory(new PropertyValueFactory<>("pid"));
        memoryColumn.setCellValueFactory(new PropertyValueFactory<>("usedMemory"));
        diffColumn.setCellValueFactory(new PropertyValueFactory<>("diff"));

        table.getColumns().addAll(nameColumn, pidColumn, memoryColumn, diffColumn);
        return table;
    }

}
