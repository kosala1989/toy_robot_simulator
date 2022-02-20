# README #
This README documents whatever steps are necessary to get your application up and running.

### What is this repository for? ###
* The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 units x 5 units
* Application able to read below commands of following form 
```
PLACE X,Y,F - supporting facing directions (NORTH|SOUTH|EAST|WEST)
MOVE
LEFT
RIGHT
REPORT
```


Example:
```
PLACE 0,0,NORTH
MOVE
REPORT

Output: 0,1,NORTH
```
## Environment 

* JAVA 11
* MAVEN

### Configuration 
* Default board size is 5 X 5, However you can increase board size by changing height & width parameter in Main.java class

### Build Application

```bash
# Please execute below comamnd to build the application
$ mvn clean install
```
### Test
```bash
# unit tests
$ mvn test
```
### Run Application
```bash
# After a successful build, compiled `toy_robot_simulator-1.0.jar` jar file can be run via console by  
$ java -jar toy_robot_simulator-1.0.jar

# Can be run via maven 
$ mvn exec:java
```