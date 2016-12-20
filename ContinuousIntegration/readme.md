In software engineering, continuous integration (CI) is the practice of merging all developer working copies to a shared mainline several times a day. Grady Booch first named and proposed CI in his 1991 method,[1] although he did not advocate integrating several times a day. Extreme programming (XP) adopted the concept of CI and did advocate integrating more than once per day - perhaps as many as tens of times per day.

##Jenkins

Jenkins is an open source automation server written in Java. The project was forked from Hudson after a dispute with Oracle.

Jenkins helps to automate the non-human part of the whole software development process, with now common things like continuous integration, but by further empowering teams to implement the technical part of a Continuous Delivery. It is a server-based system running in a servlet container such as Apache Tomcat. It supports SCM tools including AccuRev, CVS, Subversion, Git, Mercurial, Perforce, Clearcase and RTC, and can execute Apache Ant and Apache Maven based projects as well as arbitrary shell scripts and Windows batch commands. The creator of Jenkins is Kohsuke Kawaguchi.[3] Released under the MIT License, Jenkins is free software.[4]

Builds can be triggered by various means, for example by commit in a version control system, by scheduling via a cron-like mechanism and by requesting a specific build URL. It can also be triggered after the other builds in the queue have completed.

Jenkins functionality can be extended with plugins.

##Jenkin for Ubandu

Follow the steps to play with jenkin 

1)go to https://jenkins.io/ click on download tab.choose which platform or type of junkin you need to install am using ubandu for this tutorial, so that you can use select latest or any specific version of jenkin you need to use

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


