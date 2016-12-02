package Utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/*Class to used for get value from properties*/
public class Util{
	
    public String getProperties(String key) throws IOException{
        ResourceBundle rb = ResourceBundle.getBundle("MessageResources", new EncodedControl("UTF8"));
        return rb.getString(key);
    }
    
    //Get message by result from Find,Insert, Update, Delete
    public String MessageShow(int result) throws IOException
    {
    	String message = null;
    	switch(result){
    		case 1:
    			message=String.valueOf(getProperties("insert.success.book.message"));
    			break;
    		case -1:
    			message=String.valueOf(getProperties("insert.fail.book.message"));
    			break;
    		case 2:
    			message=String.valueOf(getProperties("update.success.book.message"));
    			break;
    		case -2:
    			message=String.valueOf(getProperties("update.fail.book.message"));
    			break;
    		case 3:
    			message=String.valueOf(getProperties("delete.success.book.message"));
    			break;
    		case -3:
    			message=String.valueOf(getProperties("delete.fail.book.message"));
    			break;	
    		case -4:
    			message=String.valueOf(getProperties("dberror.book.message"));
    			break;
    		case -5:
    			message=String.valueOf(getProperties("exists.book.message"));
    			break;
    		case -6:
    			message=String.valueOf(getProperties("notfound.book.message"));
    			break;
    	}	
    	
    	return message;
    }
    
    public class EncodedControl extends ResourceBundle.Control
    {
        private String encoding;
     
        public EncodedControl(String encoding)
        {
            this.encoding = encoding;
        }
     
        @Override
        public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
               throws IllegalAccessException, InstantiationException, IOException
        {
            if (!format.equals("java.properties"))
            {
                return super.newBundle(baseName, locale, format, loader, reload);
            }
            String bundleName = toBundleName(baseName, locale);
            ResourceBundle bundle = null;
            // code below copied from Sun's/Oracle's code; that's their indentation, not mine ;)
            final String resourceName = toResourceName(bundleName, "properties");
            final ClassLoader classLoader = loader;
            final boolean reloadFlag = reload;
            InputStream stream = null;
            try {
                stream = AccessController.doPrivileged(
                new PrivilegedExceptionAction<InputStream>() {
                    public InputStream run() throws IOException {
                    InputStream is = null;
                    if (reloadFlag) {
                        URL url = classLoader.getResource(resourceName);
                        if (url != null) {
                        URLConnection connection = url.openConnection();
                        if (connection != null) {
                            // Disable caches to get fresh data for
                            // reloading.
                            connection.setUseCaches(false);
                            is = connection.getInputStream();
                        }
                        }
                    } else {
                        is = classLoader.getResourceAsStream(resourceName);
                    }
                    return is;
                    }
                });
            } catch (PrivilegedActionException e) {
                throw (IOException) e.getException();
            }
            if (stream != null) {
                try {
    // CHANGE HERE
//              bundle = new PropertyResourceBundle(stream);
                Reader reader = new InputStreamReader(stream, encoding);
                bundle = new PropertyResourceBundle(reader);
    // END CHANGE
                } finally {
                stream.close();
                }
            }
            // and to finish it off
            return bundle;
        }
    }
    
    public static Date ConvertStringToDate(String date)
    {
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	try {
			return (Date) format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
}

