import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Station {
	private String stationName;
	private HashMap<String, Integer> routes;
	private Integer lowestCostPath;
	public Integer getLowestCostPath() {
		return lowestCostPath;
	}

	public void setLowestCostPath(Integer lowestCostPath) {
		this.lowestCostPath = lowestCostPath;
	}

	public String getPreviousStation() {
		return previousStation;
	}

	public void setPreviousStation(String previousStation) {
		this.previousStation = previousStation;
	}

	private String previousStation;
	
	public Station(String name) {
		this.stationName = name;
	}
	
	public String getStationName() {
		return stationName;
	}

	public Integer getDistanceToStation(String station) {
		if (this.routes.containsKey(station)) {
			return this.routes.get(station);
		}
		return -1;
	}
	
	public boolean hasRoutesToOtherStations() {
		return (this.routes.size() != 0);
	}
	
	public ArrayList<String> getConnectedStations() {
		ArrayList<String> stationNames = new ArrayList<String>();
		stationNames.addAll(this.routes.keySet());
		return stationNames;
	}
	
	public Map.Entry<String, Integer> getClosestStation() {
		Iterator iter = this.routes.entrySet().iterator();
		Map.Entry<String, Integer> closestStation = null;
		Integer shortestDist = -1;
		while (iter.hasNext()) {
			Map.Entry<String, Integer> route = (Map.Entry<String, Integer>) iter.next();
			if (shortestDist == -1 || route.getValue() < shortestDist) {
				shortestDist = route.getValue();
				closestStation = route;
			}
		}
		return closestStation;
	}
	
	public void addRoute(String stationName, Integer distance) {
		if ((!this.routes.containsKey(stationName)) ||
				(this.routes.get(stationName) > distance)) {
			this.routes.put(stationName, distance);
		}
	}

}
