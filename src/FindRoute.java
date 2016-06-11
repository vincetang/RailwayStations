import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class FindRoute {

	
	private HashMap<String, Station> stations;
	
	private void parseStations(String data) {
		this.stations = new HashMap<String, Station>();
	}
	
	private void readFile(String filename) {
		File file = new File("test.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line;
			String[] dataArray;
			String stationName1, stationName2;
			Integer distance;
			while ((line = br.readLine()) != null) {
			
				dataArray = line.split(",");
				stationName1 = dataArray[0];
				stationName2 = dataArray[1];
				distance = Integer.decode(dataArray[2]);
			
				if (!this.stations.containsKey(stationName1)) {
					
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	public static void main(String[] args) {
		// read in file line by line
		// if stations don't exist
		// 	create stations
		// Add stations to each other's routes
		// 
		// prompt user input for two stations (start, end)
		// run djikstra's algorithm to find shortest path
		
		
		
	
	}

}
