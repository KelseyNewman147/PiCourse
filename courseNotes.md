# Raspberry Pi Crash Course using Java

Welcome everyone!

Today I will be walking through how to host a Spring Boot server on a Raspberry Pi to control an LED using an web UI. 

You can find a link to my first LED test project here: 
https://github.com/ArcSoftware/PiLedTest

## Fork and Clone this Repo.
First we will fork this repository.
Then we will clone the new repo by the following git command:
```
/git clone [your new repo URL.git]
```
##### Note: Your current directory is where the cloned project will be placed. 

### If you don't have Git on your computer already, you can do this by the following:

#### Linux: 
<code>$ sudo yum install git-all</code>

#### MacOSX: 
Install HomeBrew, then Git:

#### Homebrew: 
<code>$ /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"</code>

#### Git: 
<code>$ brew install git</code>

#### Windows: 
Install here: http://msysgit.github.io


## Now that we have the repo locally, open the project in IntelliJ. 
Open new project with all default settings, adding only "Auto Import". 

Create a Java Class named "PiCourseController". 

Copy the following code into your controller class:



    @Controller
    public class PiCourseController {
        private RaspberryPiManager piManager;

        public PiCourseController() {
            piManager = new RaspberryPiManager();

        @RequestMapping(path = "/", method = RequestMethod.GET)
        public String home(Model model, String led) {
            if (led != null) { piManager.toggleLED(led);}
            return "index";
        }
    } 

Now create a Java Class named "PiManager". 

Copy the following code into your new manager class: 

    public class PiManager {
        private final GpioController gpio;
        private GpioPinDigitalOutput testLED;

        public PiManager() {
            gpio = GpioFactory.getInstance();
            testLED = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "testLED", PinState.LOW);
        }

        public void toggleLED(String led) {
            if (led.equalsIgnoreCase("testled")) {
                testLED.toggle();
        }
    }
#### Finally we need to create the HTML interface to call the new fuction we have created. 
Open the HTML file named "index.html" that I have pre created for you and paste the following code into the body:
```Toggle Light: <a href="/?led=testled"><button>LED</button></a>```
#### Now build your Gradle project from the Gradle menu. 

## That's it for the code! Now lets push our code, and spin up a web server!
Perform the following to get your code updated on your GitHub account:
```
$ git add .
$ git commit -m "adding changes"
$ git push
```

Now SSH into your Pi using terminal:
```
$ ssh pi@192.168.[subnet].[ip]
password: raspberry
```
Perform the following once connected:
```
$ sudo apt-get install git
$ curl -s get.pi4j.com | sudo bash
```
Change to a good directory to clone your repo as you did before:
```
$ git clone [repo.git]
```
Change to the jar directory:
```
cd PiCourse\builds\libs
ls
```
Start your spring server!
```
sudo java -jar [jar file name]
```
## Now we go to the URL of your Pi and the port of Spring Boot:
```
192.168.[subnet].[ip]:8080
```
        
