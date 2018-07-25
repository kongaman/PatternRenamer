package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;

public class Controller {
	
	final DirectoryChooser chooser = new DirectoryChooser();
	private Logic _logic = new Logic();
	private ArrayList<File> filesIndDir;
	private ArrayList<FileDetails> detailList;
	private File dir;
	private char masterSeperator;

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
    	filesIndDir = new ArrayList<File>(Arrays.asList(dir.listFiles()));
    	masterSeperator = _logic.verifySplit(filesIndDir);
    		
    	for (File file : filesIndDir) {
			detailList.add(new FileDetails(file));
			detailList.get(detailList.size()).setSeperator(masterSeperator);
		}
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
