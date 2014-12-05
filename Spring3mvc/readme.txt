Setup requirements

Maven
Eclipse juno
Tomcat 7

project creation mvn 
mvn archetype:generate -DgroupId=com.mvc -DartifactId=firstSpringApplication -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false



To convert the created project into eclipse web project
mvn eclipse:eclipse  -Dwtpversion=2.0
