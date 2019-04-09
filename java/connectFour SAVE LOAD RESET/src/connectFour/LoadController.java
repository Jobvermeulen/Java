package connectFour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class LoadController implements ActionListener {

	private ConnectFourModel model;
	
	public LoadController(ConnectFourModel model) {
		this.model = model;
	}
		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		chooseFile();
	}
	
	/**
	 * 
	 */
	private void chooseFile() {
		System.out.println("1.");

		JFileChooser file = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		
		file.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Tekst bestand", "txt");
		file.addChoosableFileFilter(filter);
		
		if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			System.out.println("2.");

			readFile(file.getSelectedFile());			
		}		
	}
	
	/**
	 * 
	 * @param gekozenBestand
	 */
	private void readFile(File file) {
		try {
			System.out.println("3.");

			int rows = 0;
			Scanner scanning = new Scanner(file);
			model.initializeFields();
			
			while(scanning.hasNext() && rows < model.getGrid().length) {
				String row = scanning.next();
				String[] savedCoins = row.split(";");
				
				if(savedCoins.length == model.getGrid()[0].length) {	
					model.setRow(savedCoins, rows);
				}
				else {
					System.out.println("ERROR");
					break;
				}
				rows++;
			}			
			scanning.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
