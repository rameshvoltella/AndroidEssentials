In software engineering, continuous integration (CI) is the practice of merging all developer working copies to a shared mainline several times a day. Grady Booch first named and proposed CI in his 1991 method,[1] although he did not advocate integrating several times a day. Extreme programming (XP) adopted the concept of CI and did advocate integrating more than once per day - perhaps as many as tens of times per day.

In this section we are discussing about integrating Jenkin and Travis CI

##Jenkins

Jenkins is an open source automation server written in Java. The project was forked from Hudson after a dispute with Oracle.

Jenkins helps to automate the non-human part of the whole software development process, with now common things like continuous integration, but by further empowering teams to implement the technical part of a Continuous Delivery. It is a server-based system running in a servlet container such as Apache Tomcat. It supports SCM tools including AccuRev, CVS, Subversion, Git, Mercurial, Perforce, Clearcase and RTC, and can execute Apache Ant and Apache Maven based projects as well as arbitrary shell scripts and Windows batch commands. The creator of Jenkins is Kohsuke Kawaguchi.[3] Released under the MIT License, Jenkins is free software.[4]

Builds can be triggered by various means, for example by commit in a version control system, by scheduling via a cron-like mechanism and by requesting a specific build URL. It can also be triggered after the other builds in the queue have completed.

Jenkins functionality can be extended with plugins.

if you want to install jenkin in windows please see this tutorial https://www.youtube.com/watch?v=h74i7krG33Y&t=91s

##Jenkin for Ubandu

Follow the steps to play with jenkin 

1) Go to https://jenkins.io/ click on download tab.choose which platform or type of junkin you need to install am using ubandu for this tutorial, so that you can use select latest or any specific version of jenkin you need to use

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/Screenshot%20from%202016-12-20%2012-41-02.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/Screenshot%20from%202016-12-20%2012-41-02.png" alt="Screenshot one" style="max-width:100%;"></a></p>

if you need to use latest build go to terminal

follow the cammands

* Installation

     wget -q -O - https://pkg.jenkins.io/debian/jenkins-ci.org.key | sudo apt-key add -
     
     sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
     
     sudo apt-get update
     
     sudo apt-get install jenkins

* Upgrade

Once installed like this, you can update to the later version of Jenkins (when it comes out) by running the following commands:

    sudo apt-get update
    sudo apt-get install jenkins
(aptitude or apt-get doesn't make any difference.)

for more go to https://wiki.jenkins-ci.org/display/JENKINS/Installing+Jenkins+on+Ubuntu

2) Once you install jenkin go to http://localhost:8080/ so if you running for the first time you will see this screen

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/EeLNT.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/EeLNT.png" alt="Screenshot two" style="max-width:100%;"></a></p>

you need to unlock the jenkin first using a passord which is under /var/lib/jenkins/secrets

-->Then login as root user: sudo su

-->then go to the below path: cd /var/lib/jenkins/secrets

-->just view the IntialAdminPassword file ,you can see the secret key.(in terminal type cat /var/lib/jenkins/secrets/InitialAdminPassword)

you will get a key like this c3ca6360fa014c5d9143286484696217 paste in the unlock field and countinue

3) Next we need to install the plugin, you will see two option one is install the recommended plugin other is custum selection where you can select plugin you need to install other can be igonored

##Warning Jenkins 2.0 stuck during initial install

please follow this step before you install Jenkin 2.0

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/triGn.jpg" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/triGn.jpg" alt="Screenshot three" style="max-width:100%;"></a></p>

There is bug in Jenkin 2.0 if you using this version and select recommended plugin to countinue you will be in a dead lock state and cant be countinue to the next level of jenkin. so i recommend to follow this step

* go to https://issues.jenkins-ci.org/browse/JENKINS-35523 check whether the issue is resolved  if it is resolved countine normally 

* if issue un resolved use option to select the plugin you need to install untick the two plugins

   1)Github Organization Folder Plugin
   
   2)Pipeline plugin

and countinue the installation other wise you need to downgrade or uninstall the jenkin and want to follow the steps again

Great now you have sucessfully installed jenkins

4)As we are using jenkin for android make sure we have the following three plugin installed

* Android Emulator Plugin
* Gradle Plugin
* Git plugin

To check go to plugin manager to check this in the installed tab if this not install seach the plugins and install it

The below screen shot show how to navigate to the jenkin plugin manager

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/pluginmanage.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/pluginmanage.png" alt="pluginmanage" style="max-width:100%;"></a></p>


Checking the three plugin in screen shot you can see the mentioned plugin installed

Android Emulator Plugin

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/androidplug.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/androidplug.png" alt="androidplug" style="max-width:100%;"></a></p>

Git plugin

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/gitplugin.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/gitplugin.png" alt="gitplugin" style="max-width:100%;"></a></p>

Gradle Plugin
<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/gradelplug.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/gradelplug.png" alt="gradelplug" style="max-width:100%;"></a></p>

so if above plugin are installed let create our first project

5) Now lets create our first project click start project or new item option from left side of the panel. Enter the item name thats your project name and select FreestyleProject option and click ok you first project has been created

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p1.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p1.png" alt="p1" style="max-width:100%;"></a></p>

6)Now go to the Configure option of the created folder

add your project in the git to the GitHub project option and paste your git repo url

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p2.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p2.png" alt="p2" style="max-width:100%;"></a></p>

* next Source Code Management tab add the repo address again like this

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p6.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p6.png" alt="p6" style="max-width:100%;"></a></p>

let just save this for this moment.press apply and save

* now you have just set the git path we need to fetch the project from git so that after setting the git path in config press ##Build Now
 option

if build is a sucess you will see the console log like this

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p4.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p4.png" alt="p4" style="max-width:100%;"></a></p>

you can see your build history on the Build History section click on the globe like icon to see the out put console

so after this step you can see your project workspace on the jenkin console under the selected project like this

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p5.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p5.png" alt="p5" style="max-width:100%;"></a></p>

So we have set up the project sucess fully now what we need to do is to set the build step under build tab

7)click on build step option in build tab and select Invoke Gradel Script 

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p9.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p9.png" alt="p9" style="max-width:100%;"></a></p>



* Set the option as per the following screen shot

1)In Tasks section add:    build --stacktrace
2)Root Build script


<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p101.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p101.png" alt="p101" style="max-width:100%;"></a></p>


8)Apply and save and after that click on Build Now again which start the Countinues Integartion using Jenkin

You can see the build is running in the Build History section

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p102.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p102.png" alt="p102" style="max-width:100%;"></a></p>

After the buld complete in my case it failed see the screenshot below

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p104.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p104.png" alt="p104" style="max-width:100%;"></a></p>

In screen shot the jenkin say what went wrong this is a awesome feature, so that we can identify the issue easily, so in my case i havent set my Android sdk path. This is a common error occur when we start to play with jenkin, No worrys we can set it  just follow the steps below

* Go to configuration setting

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p200.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p200.png" alt="p200" style="max-width:100%;"></a></p>

* Go to Global properties and tick the Environment variables  and press add option 

1)Set the name as ANDROID_HOME

2)put the path of your android sdk in Value field example my sdk path is /home/munnaz/Android/Sdk

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p201.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p201.png" alt="p201" style="max-width:100%;"></a></p>

* Again scroll down and go to Android option in that there is a field for Android SDK root set the path of android sdk there also.

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p202.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p202.png" alt="p202" style="max-width:100%;"></a></p>

9)Save and click Build Now again if everything goes right you will get a build sucess


<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p206.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/p206.png" alt="p206" style="max-width:100%;"></a></p>


if the you complete this tutorial you have set your first jenkin continuous integration (CI) Sucessfully.(Cheers)



##To unistall jenkin follow this for ubandu

    sudo apt-get remove jenkins
    sudo apt-get remove --auto-remove jenkins




##Travis

Travis CI is a hosted, distributed continuous integration service used to build and test software projects hosted at GitHub.
Open source projects may be tested at no charge via travis-ci.org. Private projects may be tested at the same location on a fee basis. TravisPro provides custom deployments of a proprietary version on the customer's own hardware.

Although the source is technically free software and available piecemeal on GitHub under permissive licenses, the company notes that it is unlikely that casual users could successfully integrate it on their own platforms

Travis CI is configured by adding a file named .travis.yml, which is a YAML format text file, to the root directory of the repository.[5] This file specifies the programming language used, the desired building and testing environment (including dependencies which must be installed before the software can be built and tested), and various other parameters.



Setting Travis is way more easier that jenkin

1)Go to https://travis-ci.org/ register using your github account

2)After registraion all your public repo will get listed in your travis account 

3)Select the Project you want to add

4)Adding .travis.yml in to our project root before commiting the code again if you want to execute Ci in Travis


make .travis.yml file and add

    language: android
    android:
      components:
        # Uncomment the lines below if you want to
        # use the latest revision of Android SDK Tools
        # - platform-tools
        # - tools

        # The BuildTools version used by your project
        - build-tools-25.0.0

        # The SDK version used to compile your project
        - android-25


        # Specify at least one system image,
        # if you need to run emulator(s) during your tests
        - sys-img-armeabi-v7a-android-22
        - sys-img-armeabi-v7a-android-17

    before_install:
        # Some times we need to Specify to access gradlew
        - chmod +x gradlew

you can take a copy of the file from this [link](https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/travis/file/.travis.yml).

and add in the parent folder of your project

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/travis/f0.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/travis/f0.png" alt="f0" style="max-width:100%;"></a></p>


if you set the yml file just commit your project

and go to the travis console 

if your build is a sucess the log will be some thing like screen below with lable build Passing


<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/travis/f1.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/travis/f1.png" alt="f1" style="max-width:100%;"></a></p>


<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/travis/f2.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/travis/f2.png" alt="f2" style="max-width:100%;"></a></p>

if your build is a failing the log will be some thing like screen below with lable build failing

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/travis/f3.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/travis/f3.png" alt="f3" style="max-width:100%;"></a></p>


<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/travis/f4.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/travis/f4.png" alt="f4" style="max-width:100%;"></a></p>


So travis is so simple as we compare with jenkin.

Optional: you can add your project build status in your readme by giving the 

##[![master](https://api.travis-ci.org/yourprofilename/yourproject.svg?branch=master)](https://travis-ci.org/yourprofilename/yourproject)

so that you can find easily whether you build is a pass or fail

it look like this

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/travis/f5.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ContinuousIntegration/screens/travis/f5.png" alt="f5" style="max-width:100%;"></a></p>



Hope the CI Tutorial is useful to you guys Happy Coding and CI



 








