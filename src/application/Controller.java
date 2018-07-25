package application;

import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;

public class Controller {
	
	final DirectoryChooser chooser = new DirectoryChooser();
	private ArrayList<FileDetails> detailList;
	private File dir;

	@FXML
    private Button btnDirChoser;
	
    @FXML
    private Button btnReScan;
    
    @FXML
    private ListView<String> lvLeftOrig;
    
    @FXML
    private VBox middleBox;

    @FXML
    private ListView<String> lvRightChanged;
    
    @FXML
    private Button btnSave;

    @FXML
    private Button btnSaveNExit;

   
    @FXML
    void openDirChoser(ActionEvent event) {
    	dir = chooser.showDialog(null);
    }
    
    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    void saveNExit(ActionEvent event) {

    }

   

    @FXML
    void rescan(ActionEvent event) {

    }

}
