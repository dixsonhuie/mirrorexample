
set GIGA_14=C:/Users/Dixson/work/xap/gigaspaces-insightedge-enterprise-14.2.0-ga-b20400

set CLASSES_DIR=C:/Users/Dixson/IdeaProjects/replicationfilter-example/feeder/target/classes

set MODEL_DIR=C:/Users/Dixson/IdeaProjects/replicationfilter-example/common/target/classes

set CLASSPATH=%GIGA_14%/lib/required/*

set CLASSPATH=%CLASSPATH%;%MODEL_DIR%

set CLASSPATH=%CLASSPATH%;%CLASSES_DIR%

set XAP_LOOKUP_LOCATORS=10.10.10.117
set XAP_LOOKUP_GROUPS=xap-14.2.0

java -Xms1g -Xmx1g -classpath "%CLASSPATH%" com.gigaspaces.demo.feeder.FeederWithWrite > tmp.txt 2>&1
