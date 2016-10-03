
import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;


@SuppressWarnings("serial")
public class XXXMain extends HttpServlet {
	static Logger logger = Logger.getLogger("XXXMain");
	
	private String consumerKey = "";
	private String consumerSecret = "";
	private String accessToken = "";
	private String accessSecret = "";

	private XXXReply dr;
	
	private String[] tweetList = {
			
	};
	
	public void doReply() {
		dr.reply();
	}
	
	public void doGet (HttpServletRequest req, HttpServletResponse res) throws IOException{
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
			.setOAuthAccessToken(accessToken)
			.setOAuthAccessTokenSecret(accessSecret)
			.setOAuthConsumerKey(consumerKey)
			.setOAuthConsumerSecret(consumerSecret);
		
		Twitter twitter = new TwitterFactory(cb.build()).getInstance();
		
		dr = new XXXReply(twitter);
		
		try {
			int rand = (int)(Math.random() * 144000);
			Random r = new Random();
			if (rand <= 200) {
				twitter.updateStatus(tweetList[r.nextInt(tweetList.length)]);
			}
		}
		catch (Exception e) {
			
		}
		
		doReply();			
	}
}
