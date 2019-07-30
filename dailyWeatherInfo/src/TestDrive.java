import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//Key  797a42666568617038304266515253
public class TestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BufferedReader br = null;
	     try{            
	         String urlstr = "http://openAPI.seoul.go.kr:8088/797a42666568617038304266515253/json/DailyWeatherStation/1/10/20190721"; 
	         URL url = new URL(urlstr);
	         HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
	         urlconnection.setRequestMethod("GET");
	         br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
	         String result = "";
	         String line;
	         while((line = br.readLine()) != null) {
	             result = result + line + "\n";
	         }
	         System.out.println(result);
	     }catch(Exception e){
	         System.out.println(e.getMessage());
	     }
	}
}



