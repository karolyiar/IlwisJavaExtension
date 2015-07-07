<h1>WPS-Ilwis Bridge</h1>
Wiki page: https://wiki.52north.org/bin/view/Projects/GSoC2015WpsIlwisBridge
Introductory blogpost: http://blog.52north.org/2015/05/27/wps-ilwis-bridge/
Midterm blogpost: http://blog.52north.org/2015/07/03/wps-ilwis-bridge-midterm-post/

<h2>JavaAPI</h2>
Qt project, generates a Java API for <a href="https://github.com/52North/IlwisCore">Ilwis-Objects</a> with <a href="http://www.swig.org/">SWIG</a>.
<li>SWIG build parameters: -verbose -java -c++ -package org.n52.ilwis.java -outdir ../ilwisjava/src/main/java/org/n52/ilwis/java ilwisobjects.i</li>
<b>Output:</b>
<li>Java files in the swig outdir <i>(ilwisjava/src/main/java/org/n52/ilwis/java)</i>.
<li>_ilwisobjects.dll in the project root folder.

<h2>IlwisJava</h2>
Maven project.
<h3>Building the library</h3>
Use <code>mvn clean install</code> in the <i>ilwisjava</i> folder to export to jar.
<b>Output:</b> The jar file is in <i>ilwisjava/target</i>.
<h3>Using the library</h3>
<li>Copy the dependencies (_ilwisobjects.dll, 52n-ilwis-java-version-SNAPSHOT.jar) to <i>projectfolder/lib</i></li>
<li>Load Ilwis-Objects with <code>ilwisobjects.initIlwisObjects(ilwisLocation);</code><br>
Folder with ilwis.exe, default: <i>D:\ilwisObjects\output\win32debug\bin;</i></li>

<h2>IlwisJava Test</h2>
Eclipse JUnit project for testing the IlwisJava project.
<h3>Dependencies</h3>
<li><i>ilwisjava_test/lib</i>: _ilwisobjects.dll (copy from the project root folder).</li>
<li><i>ilwisjava_test/lib</i>: 52n-ilwis-java-version-SNAPSHOT.jar (copy from <i>ilwisjava/target</i>).</li> 
<li>Ilwis location have to be in the PATH variable. (Folder with ilwis.exe, default location: <i>D:\ilwisObjects\output\win32debug\bin;</i>). Add to build path. (In Eclipse: Right click, Build Path, Add.)</li>
<li>Edit the locations in TestUtil.java</li>
<li>Test files will be available on Google Drive.</li>
<h3>Run tests</h3>
<li>Open the ilwisobject_test project in Eclipse.</li>
<li>To run all the tests, right-click on the test folder, "Run as" JUnit Test.</li>

<h1>Contact</h1>
Ilwis mailing list: ilwis@52north.org

<h1>License</h1>
Published under The Apache Software License, Version 2.0. If you want to build your own algorithms you can depend on these modules alone and release it under any compatible open source license.
For details see the LICENSE and NOTICE files. Be aware that some modules contain their own LICENSE and NOTICE files.

