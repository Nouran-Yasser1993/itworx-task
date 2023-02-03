package util;

public class DataReader {

    public static String readElement( String elementName) {
        PropertiesReader.readProperties(System.getProperty("user.dir")+"/src/main/resources/webElements.properties");
        return PropertiesReader.getPropertyValue(elementName);
    }
}