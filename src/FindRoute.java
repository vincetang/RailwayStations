import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FindRoute {

	
	private HashMap<String, Station> stations;
	
	private void parseStations(String data) {
		String[] dataArray;
		String stationName1, stationName2;
		Integer distance;
		
		dataArray = data.split(",");
		stationName1 = dataArray[0];
		stationName2 = dataArray[1];
		distance = Integer.decode(dataArray[2]);
		Station station1, station2;
		if (!this.stations.containsKey(stationName1)) {
			station1 = new Station(stationName1);
			this.stations.put(stationName1, station1);
		} else {
			station1 = this.stations.get(stationName1);
		}
		
		if (!this.stations.containsKey(stationName2)) {
			station2 = new Station(stationName2);
			this.stations.put(stationName2, station2);
		} else {
			station2 = this.stations.get(stationName2);
		}
		
		station1.addRoute(stationName2, distance);
		station2.addRoute(stationName1, distance);
		
	}
	
	private void readFile(String filename) {
		File file = new File(filename);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line;

			this.stations = new HashMap<String, Station>();
			while ((line = br.readLine()) != null) {
				parseStations(line);
			}
			
			runMainLoop();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private Integer findShortestRoute(String stationStart, String stationDest) {
		ArrayList<String> visited = new ArrayList<String>();

		
		visited.add(stationStart);
		Station startingStation = this.stations.get(stationStart);
		
		startingStation.setLowestCostPath(Integer.valueOf(0));
		startingStation.setPreviousStation(null);
		

		ArrayList<String> connectedStations = new ArrayList<String>();
		Station currentStation, connectedStation;
		Integer totalCost, additionalCost, costToStation;
		String connectedStationName;
		

		Boolean loop_flag = true;
		/** loop until every node is visited **/
		while (visited.size() < this.stations.keySet().size() && loop_flag) {
			String closestUnvisitedName = null;
			Integer lowestCostUnvisited = -1;
			for (int i = 0; i < visited.size(); i++) {
				// iterate through all stations connected to visited stations to
				// find unvisited nodes connected to our path so far
				currentStation = this.stations.get(visited.get(i));
				connectedStations = currentStation.getConnectedStations();
				totalCost = currentStation.getLowestCostPath();
			
				
				// loop through unvisited connected station
				for (int k = 0; k < connectedStations.size(); k++) {
					
					connectedStationName = connectedStations.get(k);
					// only look at unvisited
					if (!visited.contains(connectedStationName)) {
						connectedStation = this.stations.get(connectedStationName);
						additionalCost = currentStation.getDistanceToStation(connectedStationName);
						
						costToStation = totalCost + additionalCost;
						
						// update if this path is closer than previously calculated
						if ( (connectedStation.getLowestCostPath() == -1) ||
								 (lowestCostUnvisited.intValue() == -1) || 
								 (costToStation < connectedStation.getLowestCostPath())) {
							
							connectedStation.setLowestCostPath(totalCost+additionalCost);
							connectedStation.setPreviousStation(currentStation.getStationName());
							
							// closest unvisited path
							if  ((lowestCostUnvisited == -1) || (costToStation < lowestCostUnvisited)) {
								closestUnvisitedName = connectedStation.getStationName();
								lowestCostUnvisited = costToStation;
							}
						}
					}
				}
				
	
			}
			// We've searched through all unvisited stations connected to our path so far
			// and found the closest. Add this station to our visited
			if (closestUnvisitedName == null) {
				// could not find any unvisited neighbours
				loop_flag = false;
			} else {
				visited.add(closestUnvisitedName);
			}
		}
		/** end loop **/		
		// get shortest distance
		Station destination = this.stations.get(stationDest);
		return destination.getLowestCostPath();
	}
	
	private void runMainLoop() {
		Scanner reader = new Scanner(System.in);
		String stationStart, stationDest;
		boolean stopLoop = false;
		int shortestRoute;
		do {
			System.out.println("Enter your current station:");
			stationStart = reader.next();
			
			if (stationStart.compareToIgnoreCase("exit") == 0) {
				stopLoop = true;
			} else if (!this.stations.containsKey(stationStart)) {
				System.out.println(stationStart + " does not exist.");
				stopLoop = true;
			} else {
				System.out.println("\nEnter your destination station:");
				stationDest = reader.next();
				
				if (stationDest.compareToIgnoreCase("exit") == 0) {
					stopLoop = true;
				} else if (!this.stations.containsKey(stationDest)) {
					System.out.println(stationDest + " does not exist");
				} else {
					shortestRoute = findShortestRoute(stationStart, stationDest);
					System.out.println("The shortest route from " + stationStart + " to " + stationDest +
							" is " + shortestRoute + "KM.");
				}
			}
			
			
		} while (!stopLoop);
	}
	public static void main(String[] args) {
		// read in file line by line
		// if stations don't exist
		// 	create stations
		// Add stations to each other's routes
		// 
		// prompt user input for two stations (start, end)
		// run djikstra's algorithm to find shortest path
		
		/** to run: FindRoute.class test.csv **/
		//System.out.println("Args[0]: " + args[0]);
		FindRoute findRoute = new FindRoute();
		String filename = args[0];
		findRoute.readFile(filename);
		
	
	}

}
