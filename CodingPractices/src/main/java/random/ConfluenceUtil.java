///**
// * 
// */
//package random;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//
//import org.apache.commons.io.IOUtils;
//import org.apache.commons.lang.StringUtils;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPut;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.util.EntityUtils;
//import org.json.JSONObject;
//
///**
// * @author Nitin Sharma
// *
// */
//public class ConfluenceUtil {
//
//	private static final String BASE_URL = "http://localhost:1990/confluence";
//	private static final String USERNAME = "admin";
//	private static final String PASSWORD = "admin";
//	private static final String ENCODING = "utf-8";
//
//	private static String getContentRestUrl(final Long contentId, final String[] expansions)
//			throws UnsupportedEncodingException {
//		final String expand = URLEncoder.encode(StringUtils.join(expansions, ","), ENCODING);
//
//		return String.format("%s/rest/api/content/%s?expand=%s&os_authType=basic&os_username=%s&os_password=%s",
//				BASE_URL, contentId, expand, URLEncoder.encode(USERNAME, ENCODING),
//				URLEncoder.encode(PASSWORD, ENCODING));
//	}
//
//	public static void main(final String[] args) throws Exception {
//		final long pageId = 98334;
//
//		HttpClient client = new DefaultHttpClient();
//
//		// Get current page version
//		String pageObj = null;
//		HttpEntity pageEntity = null;
//		try {
//			HttpGet getPageRequest = new HttpGet(
//					getContentRestUrl(pageId, new String[] { "body.storage", "version", "ancestors" }));
//			HttpResponse getPageResponse = client.execute(getPageRequest);
//			pageEntity = getPageResponse.getEntity();
//
//			pageObj = IOUtils.toString(pageEntity.getContent());
//
//			System.out.println("Get Page Request returned " + getPageResponse.getStatusLine().toString());
//			System.out.println("");
//			System.out.println(pageObj);
//		} finally {
//			if (pageEntity != null) {
//				EntityUtils.consume(pageEntity);
//			}
//		}
//
//		// Parse response into JSON
//		JSONObject page = new JSONObject(pageObj);
//
//		// Update page
//		// The updated value must be Confluence Storage Format
//		// (https://confluence.atlassian.com/display/DOC/Confluence+Storage+Format), NOT
//		// HTML.
//		page.getJSONObject("body").getJSONObject("storage").put("value", "hello, world");
//
//		int currentVersion = page.getJSONObject("version").getInt("number");
//		page.getJSONObject("version").put("number", currentVersion + 1);
//
//		// Send update request
//		HttpEntity putPageEntity = null;
//
//		try {
//			HttpPut putPageRequest = new HttpPut(getContentRestUrl(pageId, new String[] {}));
//
//			StringEntity entity = new StringEntity(page.toString(), ContentType.APPLICATION_JSON);
//			putPageRequest.setEntity(entity);
//
//			HttpResponse putPageResponse = client.execute(putPageRequest);
//			putPageEntity = putPageResponse.getEntity();
//
//			System.out.println("Put Page Request returned " + putPageResponse.getStatusLine().toString());
//			System.out.println("");
//			System.out.println(IOUtils.toString(putPageEntity.getContent()));
//		} finally {
//			EntityUtils.consume(putPageEntity);
//		}
//	}
//}
