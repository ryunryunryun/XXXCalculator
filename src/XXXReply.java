
import java.util.Date;

import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class XXXReply {
	
	Twitter twitter;
	
	XXXTranslator translator;

	public static long lastPostId;
	public static long lastPostTime;
	
	public XXXReply (Twitter twitter) {	
		this.twitter = twitter;
		renewLastPostTime();
	}
	
	
	public void reply () {
		ResponseList<Status> mentions = null;
		
		try {
			mentions = twitter.getMentionsTimeline();
		}
		catch (Exception e) {
			System.out.println("Problem here");
		}
		
		for (int i = mentions.size() - 1; i >= 0; i--) {
			// need to compare the current mentionID and the last one saved.
			if (mentions.get(i).getCreatedAt().getTime() > lastPostTime) {
				String equation = "";
				try {
					equation = mentions.get(i).getText().substring(16);
				}
				catch (Exception e){
				}
			
				translator = new XXXTranslator (equation);
			
				String reply = "@" + mentions.get(i).getUser().getScreenName() + " " + translator.getDogLanguage();
			
		
				try {
					StatusUpdate su = new StatusUpdate(reply);
					su.setInReplyToStatusId(mentions.get(i).getId());
					twitter.updateStatus(su);
					System.out.println(mentions.get(i).getText());
				}
				catch (Exception e) {
				}
			}
		}			
	}
	
	
	private void renewLastPostTime () {
		lastPostTime = new Date().getTime() - 1000 * 60 * 5;
		ResponseList<Status> homeTimeLine = null;
		
		try {
			Paging p = new Paging();
			p.setCount(40);
			homeTimeLine = twitter.getHomeTimeline(p);
		}
		catch (Exception e) {
		}
		
		for (Status tweet : homeTimeLine) {
			if (tweet.getText().contains("@")) {
				try {
					lastPostTime = Math.max(lastPostTime, twitter.showStatus(tweet.getInReplyToStatusId()).getCreatedAt().getTime());
				}
				catch (Exception e) {
					
				}
			}
		}
	}
	
	private void renewLastID () {
		lastPostId = -1;
		ResponseList<Status> homeTimeLine = null;
		try {
			Paging p = new Paging();
			p.setCount(40);
			homeTimeLine = twitter.getHomeTimeline();
		}
		catch (Exception e) {
		}
		
		for (Status tweet : homeTimeLine) {
			lastPostId = Math.max(lastPostId, tweet.getInReplyToStatusId());
		}
	}
}