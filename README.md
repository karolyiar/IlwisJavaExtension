<h1>WPS-Ilwis Bridge</h1>
Wiki page: https://wiki.52north.org/bin/view/Projects/GSoC2015WpsIlwisBridge <br>
Introductory blogpost: http://blog.52north.org/2015/05/27/wps-ilwis-bridge/ <br>
Midterm blogpost: http://blog.52north.org/2015/07/03/wps-ilwis-bridge-midterm-post/ <br>

<h2>JavaAPI</h2>
<b>Will be moved to IlwisConnectors.</b><br>
Qt project, generates a Java API for <a href="https://github.com/52North/IlwisCore">Ilwis-Objects</a> with <a href="http://www.swig.org/">SWIG</a>.
<h3>Requirements</h3>
<li>Qt 5.2.1 with MinGW 4.8.2 32bit</li>
<li>SWIG 3.0.6</li>
<li>Java 1.8 <a href=http://www.webupd8.org/2014/03/how-to-install-oracle-java-8-in-debian.html>Linux</a></li>
<h3>Build</h3>
<li>Set <b>JAVADIR</b> in javaapi.pro to JDK location.
<li>Set <b>Projects / Build / Build Steps</b> to run SWIG:
<a href="https://drive.google.com/open?id=0B0bWmJJYoWIpNXo2TGhMZWdzcDQ">Windows</a> <a href=https://drive.google.com/open?id=0B0bWmJJYoWIpbXdKZC1xeGl6ZzQ>Linux</a></li>
SWIG build parameters: <code>-verbose -java -c++ -package org.n52.ilwis.java -outdir ../ilwisjava/src/main/java/org/n52/ilwis/java ilwisobjects.i</code><br>
<b>Output:</b>
<li>Java files in the swig outdir <i>(ilwisjava/src/main/java/org/n52/ilwis/java)</i>.
<li>_ilwisobjects.dll / lib_ilwisobjects.so in the <i>output/extensions/_ilwisobjects</i> folder.

<h2>IlwisJava</h2>
Maven project.
<h3>Building the library</h3>
<li>Edit <i>ilwisjava/src/main/resources/ilwislocation.config</i> to the ilwisobjects folder.</li>
Default: <code>ilwisDir=F:/documents/ilwis/ilwisObjects/output/win32debug/bin/</code>
<li>Download the testfiles from <a href="https://docs.google.com/uc?id=0B0bWmJJYoWIpR2VuWmRYdUlFSkk&export=download">Here</a> to <i>ilwisjava/src/test/resources</i>.
<li>Use <code>mvn clean install</code> in the <i>ilwisjava</i> folder to export to jar and run the tests.<br></li>
<b>Output:</b>
<li>The jar file is in <i>ilwisjava/target</i>.</li>
<h3>Using the library</h3>
<li>Ilwis location have to be in the <b>PATH variable</b>.<br>(Folder with ilwis.exe, development location: <i>D:\ilwisObjects\output\win32debug\bin;</i>).<br></li>
<li>Copy <b>ilwislocation.config</b> to the <i>projectfolder</i>.
<li>Copy 52n-ilwis-java-version-SNAPSHOT.jar to <i>projectfolder/lib</i></li>
<li>Add the jar to build path.</li>
<li>Import: <code>import org.n52.ilwis.java.*;</code></li>
<li>Before use, load Ilwis-Objects with <code>ilwisobjects.initIlwisObjects();</code><br>

<h2>Ilwis Process Repository</h2>
<b>Ilwis backend for 52°North WPS.</b>
<h3>Set up Ilwis-Objects with Java</h3>
<li>Download from <a href="https://drive.google.com/open?id=0B0bWmJJYoWIpYS1rdWVkbUJnS3c">Here</a>.</li>
<li>Extract it to eg. <i>C:\ilwisobjects</i>.</li>
<li>Add the ilwisobjects folder to the PATH variable. <a href="http://www.computerhope.com/issues/ch000549.htm">HOWTO</a></li>
<h3>Building the library</h3>
<li>Use <code>mvn clean install</code> in the <i>52n-wps-ilwis</i> folder to export to jar.<br></li>
<h3>Add at WPS build time</h3>
Extend the 52n-wps-webapp <b>pom.xml</b> dependencies:<br>
```xml
<!-- Ilwis dependency -->
		<dependency> 
			<groupId>org.n52.wps</groupId>
			<artifactId>52n-wps-ilwis</artifactId>
		</dependency>
		<dependency>
			<groupId>org.n52.ilwis.java</groupId>
			<artifactId>52n-ilwis-java</artifactId>
		</dependency>
```
Edit and copy the <b>ilwislocation.config</b> to <i>WPS\52n-wps-webapp\src\main\webapp\config</i>.
<h3>Add at WPS runtime</h3>
<li>Copy <b>52n-ilwis-java-0.0.1-SNAPSHOT.jar</b> and <b>52n-wps-ilwis-3.3.2-SNAPSHOT.jar</b> to <i>52n-wps-webapp-3.3.2-SNAPSHOT\WEB-INF\lib</i></li>
<li>Edit <i>wps/config/</i><b>ilwislocation.config</b>.</li>
<h3>Activate in WPS</h3>
<a href="https://drive.google.com/open?id=0B0bWmJJYoWIpQXA0WkxkNlNxMXM">Image</a><br>
IlwisRepository<br>
org.n52.wps.server.ilwis.IlwisProcessRepository<br>
Algorithm	org.n52.wps.server.ilwis.mirrorrotateraster<br>

<h1>Contact</h1>
Ilwis mailing list: ilwis@52north.org

<h1>License</h1>
TODO

