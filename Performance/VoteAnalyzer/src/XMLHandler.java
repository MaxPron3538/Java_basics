import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class XMLHandler extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            if (qName.equals("voter")) {
                String name = attributes.getValue("name");
                String birthDay = attributes.getValue("birthDay");
                DBConnection.countVoter(name,birthDay);
            }
        }catch (SQLException ex){
           ex.printStackTrace();
        }
    }

    @Override
    public void endElement(String uri,String localName, String qName) throws SAXException{
    }
}
