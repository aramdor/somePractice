# Required software setup:
 * Java 1.8 (jdk1.8.0_172 was used for the development)
 * Maven (installed and added to the classpath)
 * Git
 * Allure
 * WebDriver for the Google Chrome
    * Project contains ChromeDriver which is compatible with the Chrom brovsr Version 74.* if you use different version please update the driver in the ```seleniumGridFiles/localGridAndHub``` folder
    
# How to start:
* Download the project ```git clone git@github.com:aramdor/somePractice.git```
* Download dependencies ```mvn clean install -DskipTests```
* Update existing credentials for the admin user in the ```pom.xml``` file or add your own profile
* Make sure that YouTrack application is running.
  * Update Url profile if required
* Launch selenium grid and hub via bat file ```seleniumGridFiles/localGridAndHub/runLocalHubAndNode.bat```or manually
* Execute test cases
  * via IDE
  * via command line ```mvn clean test```
* To review the report execute in the command line ```allure serve /allure-results```
