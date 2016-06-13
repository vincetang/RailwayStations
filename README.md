# RailwayStations

The program reads a CSV file of locations and distances. It then prompts the user to input a starting location and a destination. Using an implementation of Djikstra's Algorithm, the shortest path's distance from the starting location to the destination is returned.<br />
<br />
Sample input file:<br />
A,B,4<br />
A,C,3<br />
A,E,7<br />
B,D,5<br />
B,C,6<br />
C,D,11<br />
C,E,8<br />
D,G,10<br />
D,E,5<br />
D,F,2<br />
E,G,5<br />
G,F,3<br />
<br /><br />
Sample input:<br />
Enter your current station:<br />
\>A<br />
Enter your destination station:<br />
\>F<br />
<br />
Sample output:<br />
The shortest route from A to F is 11KM.

<br/>
<br/>
More complex sample file:<br/>
Blundellsands,Marden,93<br/>
Blundellsands,Clonmel (CIE),97<br/>
Southampton Docks,Bridport (by bus),16<br/>
Southampton Docks,Redruth,82<br/>
Southampton Docks,Ealing Broadway,43<br/>
Redruth,Aspley Guise,55<br/>
Ealing Broadway,Longford (CIE),10<br/>
Ealing Broadway,High Wycombe,6<br/>
Ealing Broadway,Duffield,33<br/>
Marden,Redruth,40<br/>
Marden,Spalding,97<br/>
Marden,Scunthorpe,86<br/>
Spalding,Bath Spa,53<br/>
Spalding,Ealing Broadway,55<br/>
Spalding,Blundellsands,43<br/>
Apsley,Ealing Broadway,47<br/>
Apsley,Williamwood,15<br/>
Apsley,Oakham,45<br/>
Bridport (by bus),Williamwood,77<br/>
Bridport (by bus),Duffield,81<br/>
Longford (CIE),High Wycombe,91<br/>
Longford (CIE),Scunthorpe,40<br/>
Longford (CIE),Oakham,76<br/>
Carmyle,Kirklees,10<br/>
Clonmel (CIE),Spalding,97<br/>
Clonmel (CIE),Squires Gate,78<br/>
Clonmel (CIE),Southampton Docks,16<br/>
Knighton,Bridport (by bus),51<br/>
Knighton,Duffield,24<br/>
Williamwood,Redruth,40<br/>
Williamwood,Scunthorpe,2<br/>
Williamwood,Bath Spa,97<br/>
Duffield,Oakham,89<br/>
Kirkham and Wesham,Blundellsands,11<br/>
Kirkham and Wesham,Knighton,40<br/>
Kirkham and Wesham,Spalding,55<br/>
Bath Spa,Redruth,98<br/>
Aspley Guise,Knighton,61<br/>
Aspley Guise,Longford (CIE),55<br/>
Squires Gate,Williamwood,93<br/>
Squires Gate,Spalding,98<br/>
Scunthorpe,Longford (CIE),16<br/>
Scunthorpe,Squires Gate,62<br/>
High Wycombe,Knighton,82<br/>
High Wycombe,Clonmel (CIE),6<br/>
High Wycombe,Bath Spa,63<br/>
Oakham,Knighton,96<br/>
Oakham,Kirkham and Wesham,18<br/>

