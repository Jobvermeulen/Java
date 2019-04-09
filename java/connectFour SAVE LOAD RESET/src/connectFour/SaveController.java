package connectFour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class SaveController implements ActionListener{
	private ConnectFourModel model;
	
	/**
	 * 
	 * @param model
	 */
	public SaveController(ConnectFourModel model)
	{
		this.model = model;
	}
	
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ChooseSaveFile();
	}
	
	/**
	 *
	 */
	private void ChooseSaveFile() {
		JFileChooser saveFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		
		saveFile.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Tekst bestand", "txt");
		saveFile.addChoosableFileFilter(filter);

		if (saveFile.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			WriteToFile(saveFile.getSelectedFile());
		}
	}
	
	/**
	 * 
	 * @param saveFile
	 */
	private void WriteToFile(File saveFile) {
		try {
			PrintWriter writeGame = new PrintWriter(saveFile + ".txt");
			
			for(int row = 0; row < model.getGrid().length; row++) {
				for(int column = 0; column < model.getGrid()[0].length; column++) {
					switch (model.checkCelStatus(row, column)) {
					case PLAYER1:
						writeGame.print("1;");
						break;
					case PLAYER2:
						writeGame.print("2;");
						break;
					case EMPTY:
						writeGame.print("0;");
						break;
					default:
						writeGame.print("*;");
						break;
					}
				}
				writeGame.println();
			} 
			writeGame.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
