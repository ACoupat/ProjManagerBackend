mvn clean install
java -jar -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=4242 target/smartproj-0.0.1-SNAPSHOT.jar
#java -jar target/smartproj-0.0.1-SNAPSHOT.jar
