package com.zenappse.passbeacon;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	final static int CONTACT_ID = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		menu.add(0, CONTACT_ID, 0, "Contacts").setIcon(R.drawable.ic_menu_allfriends)
        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            // app icon in action bar clicked; go home
	            Intent intent = new Intent(this, MainActivity.class);
	            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent);
	            return true;
	        case CONTACT_ID:
	            // app icon in action bar clicked; go home
	        	Log.d("Contact click", "Enter Contacts");
	            Intent intent_contacts = new Intent(this, ContactsActivity.class);
	            intent_contacts.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent_contacts);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	public void helpButton(View view){
		TextView t = (TextView)findViewById(R.id.textDebug);
		//if((TextView)findViewById(R.id.toggleAlarmButton).get){
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("message[to]", "7165749407");
		data.put("message[from]", "4253294880");
		data.put("message[body]", "Auto text from Patricks's PASS Safety App. If you have received this message, something has happened to me and I need immediate help!");
		AsyncHttpPost asyncHttpPost = new AsyncHttpPost(data);
		asyncHttpPost.execute("http://passapp.herokuapp.com/messages");
		//}
//		HttpClient client = new DefaultHttpClient();
//		HttpPost post = new HttpPost("http://passapp.herokuapp.com/messages");
//		post.addHeader("Authorization", "Basic 78f91d346838110d9edb6be3996624a9");
//		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
//		pairs.add(new BasicNameValuePair("message[to]", "7165749407"));
//		pairs.add(new BasicNameValuePair("message[from]", "4253294880"));
//		pairs.add(new BasicNameValuePair("message[body]", "Test help!"));
//		try {
//			post.setEntity(new UrlEncodedFormEntity(pairs));
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			Log.d("HTTP POST", "Posting data");
//			HttpResponse response = client.execute(post);
//			Log.d("HTTP Response", response.toString());
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			Log.d("Exception", "Caught IllegalStateException");
//			e.printStackTrace();
//		}
//	     try {
//	         HttpClient client = new DefaultHttpClient();  
//	         String postURL = "http://passapp.herokuapp.com/messages";
//	         HttpPost post = new HttpPost(postURL);
//	         post.addHeader("Authorization", "Basic 78f91d346838110d9edb6be3996624a9");
//             List<NameValuePair> params = new ArrayList<NameValuePair>();
//             params.add(new BasicNameValuePair("message[to]", "7165749407"));
//             params.add(new BasicNameValuePair("message[from]", "4253294880"));
//             params.add(new BasicNameValuePair("message[body]", "Test help!"));
//             UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params,HTTP.UTF_8);
//             post.setEntity(ent);
//             HttpResponse responsePOST = client.execute(post);  
//             HttpEntity resEntity = responsePOST.getEntity();  
//             if (resEntity != null) {    
//                 Log.i("RESPONSE",EntityUtils.toString(resEntity));
//             }
//	     } catch (Exception e) {
//	         e.printStackTrace();
//	     }
		t.setText("Help Pressed!");
	}

}
