java -cp C:\Users\Dell\Desktop\POM\Library\*;C:\Users\Dell\Desktop\POM\bin org.testng.TestNG testng1.xml 


set projectLocation=C:\Users\Dell\Desktop\POM
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\Library\*
java org.testng.TestNG %projectLocation%\testng1.xml
pause