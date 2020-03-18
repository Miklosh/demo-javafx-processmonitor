package demo.myko.processmonitor.ui;

import demo.myko.processmonitor.entity.Task;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class RootConfig {

    public static BorderPane configRoot(MenuBar menuBar, TableView<Task> table) {
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(table);
        return root;
    }

}
