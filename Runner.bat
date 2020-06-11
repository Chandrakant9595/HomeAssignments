set projectLocation=D:\Projects\HomeAssignment
cd %projectLocation%
set classpath=C:\Users\vicky\.m2\repository\org\testng\testng\7.1.0\*
java org.testng.TestNG %projectLocation%\TestNG.xml
pause