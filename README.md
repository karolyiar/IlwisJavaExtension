<h1>WPS-Ilwis Bridge</h1>
Wiki page: https://wiki.52north.org/bin/view/Projects/GSoC2015WpsIlwisBridge <br>
Introductory blogpost: http://blog.52north.org/2015/05/27/wps-ilwis-bridge/ <br>
Midterm blogpost: http://blog.52north.org/2015/07/03/wps-ilwis-bridge-midterm-post/ <br>

<h2>JavaAPI</h2>
<h4>Will be moved to IlwisConnectors.</h4>
Qt project, generates a Java API for <a href="https://github.com/52North/IlwisCore">Ilwis-Objects</a> with <a href="http://www.swig.org/">SWIG</a>.<br>
Qt can run SWIG in the building process.<br>
<li>Set <b>Projects / Build / Build Steps</b>:
<a href="https://drive.google.com/open?id=0B0bWmJJYoWIpNXo2TGhMZWdzcDQ">image</a>.</li>
<li>SWIG build parameters: -verbose -java -c++ -package org.n52.ilwis.java -outdir ../ilwisjava/src/main/java/org/n52/ilwis/java ilwisobjects.i</li>
<b>Output:</b>
<li>Java files in the swig outdir <i>(ilwisjava/src/main/java/org/n52/ilwis/java)</i>.
<li>_ilwisobjects.dll in the project root folder.

<h2>IlwisJava</h2>
Maven project. (SWIG is not used here.)
<h3>Building the library</h3>
<li>Edit <i>ilwisjava/src/main/resources/ilwislocation.config</i> to the folder with ilwis.exe.</li>
Default: <code>ilwisDir=F:/documents/ilwis/ilwisObjects/output/win32debug/bin/</code>
<li>Use <code>mvn clean install</code> in the <i>ilwisjava</i> folder to export to jar and run the tests.<br></li>
<b>Output:</b> The jar file is in <i>ilwisjava/target</i>.
<h3>Using the library</h3>
<li>Ilwis location have to be in the <b>PATH variable</b>.<br>(Folder with ilwis.exe, development location: <i>D:\ilwisObjects\output\win32debug\bin;</i>).<br></li>
<li>Copy <b>ilwislocation.config</b> to the projectfolder.
<li>Copy the dependencies (_ilwisobjects.dll, 52n-ilwis-java-version-SNAPSHOT.jar) to <i>projectfolder/lib</i></li>
<li>Add the jar to build path.</li>
<li>Import: <code>import org.n52.ilwis.java.*;</code></li>
<li>Before use, load Ilwis-Objects with <code>ilwisobjects.initIlwisObjects(ilwisobjects.ilwisLocation);</code><br>

<h1>Contact</h1>
Ilwis mailing list: ilwis@52north.org

<h1>License</h1>
TODO

