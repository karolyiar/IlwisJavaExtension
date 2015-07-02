<h1>JavaAPI for Ilwis</h1>
<h2>JavaAPI</h2>
<li>Qt Project</li>
<li>SWIG build parameters: -verbose -java -c++ -package ilwisobject_test -outdir ../ilwisobject_test/src/ilwisobject_test ilwisobjects.i</li>


<h2>IlwisObject Test</h2>
Java project for testing the generated output.
<h3>Set up</h3>
<li>Download the ilwisobject_test folder and the _ilwisobjects.dll.</li>
<li>Ilwis location have to be in the PATH variable. (Folder with ilwis.exe, default location: "D:\ilwisObjects\output\win32debug\bin;").</li>
<li>_ilwisobjects.dll have to be reachable by Ilwis, in "ilwislocation\extensions\\\_ilwisobjects\".</li>
<li>Open the ilwisobject_test project in Eclipse.</li>
<li>To run all the tests, right-click on the test folder, "Run as" JUnit Test.</li>
