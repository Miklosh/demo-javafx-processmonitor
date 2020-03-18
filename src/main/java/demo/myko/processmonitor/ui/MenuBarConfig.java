package demo.myko.processmonitor.ui;

import demo.myko.processmonitor.entity.RootTask;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class MenuBarConfig {

    public static MenuBar configureMenuBar(Stage stage) {
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = FileMenuConfig.configureFileMenu(stage);
        menuBar.getMenus().add(fileMenu);
        return menuBar;
    }

}
