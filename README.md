						 **Weather-Music App**
						-----------------------------

This is a Spring Boot App which accepts either city name or latitude/longitude of a place, gets the current temperature of the place and suggests a list of music links from spotify.

It gets weather data from https://openweathermap.org and fetches a playlist from spotify depending on the current temperature of the place. 

Application is deployed on [Heroku](https://aqueous-journey-41424.herokuapp.com/). 

#### Business rules:
▪ If temperature (Celsius) is above 30 degrees, suggests tracks for party
▪ In case temperature is between 15 and 30 degrees, suggests pop music tracks
▪ If it's a bit chilly (between 10 and 14 degrees), suggests rock music tracks
▪ Otherwise, if it's freezing outside, suggests classical music tracks

#### Instructions to run the application:
The application is tested on a mac OS. 

*Requirements*:  Make sure below softwares are installed on your system.
	- [JDK 11](https://www.oracle.com/in/java/technologies/javase-jdk11-downloads.html) 
	- [Maven](https://maven.apache.org/download.cgi)
	- [Docker](https://www.docker.com/)
	- [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

- Clone the Project from https://github.com/SharvariNagesh/MusicForWeather
			
			$ git clone https://github.com/SharvariNagesh/MusicForWeather
- Run maven clean build:
			
			$ mvn clean package
- Build Docker image
	
			docker build --tag=message-server:latest .

- Run Docker image using:
		
			docker run -p8081:8080 message-server:latest
- Can access the application at : http://localhost:8081/

#### Design Details:
The application is developed using Java Spring Boot framework. The decision to use Spring-Boot was taken because the framework is robust, flexible and provides various features just by using annotations. 

##### The directory structures and control flow:
	- **Controller** - Displays a form to Enter City name and lat/long details.
		- Spring Boot validation, @Validate is used to validate the input details. 
	- **Services** Services defined are responsible for implementing the business logic and fetching the needed data. 
		- The main service, "GetMusicForLocation", receives request from Controller. Requests "WeatherService" to get weather for a region.
		- "WeatherService" accesses https://openweathermap.org webpage and fetches the weather details. Java WebClient is used to fetch weather data from openweathermap.org.
		- "SpotifyService" uses the weather details to fetch a playlist from spotify depending on the temperature. [SpotifyAPI](https://developer.spotify.com/documentation/web-api/quick-start/) is used to authenticate and fetch spotify playlists. 
	- **Constants** : A Java enum,"TempMapEnums" is used to store the constants like different temperature ranges, Spotify playlist to be played for each weather type.
	- **Util** : Util folder holds common utility functions used across the application
	- **Custom Exception** handler : handles the messages and returns a ResponseString
	
#### Pending work or TO-DOs:
	- There are some API keys used in the application. For example, API key of openweathermap.org or Client Id/secret of Spotify which are hard coded. This needs to be made configurable and moved out in a secure place. Preferably as an environment variable.
	- Test cases are not written. 
	- Exception handling needs to be enhanced to present the exception in a user friendly way. Currently, the proper error messages are printed on an empty html page.
	
