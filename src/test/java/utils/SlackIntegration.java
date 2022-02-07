package utils;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.IOException;

public class SlackIntegration {
    private static String urlSlackWebHook = "https://hooks.slack.com/services/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";
    private static String channelName = "#hijra-automate-test";
    private static String botUserOAuthAccessToken = "xoxb-1249715368885-2923535068224-HJFZRRHqRxbjR4FM8LVD4L44";

    public void sendTestExecutionStatusToSlack(String message) throws Exception {
        try {
            StringBuilder messageBuider = new StringBuilder();
            messageBuider.append(message);
            Payload payload = Payload.builder().channel(channelName).text(messageBuider.toString()).build();

            WebhookResponse webhookResponse = Slack.getInstance().send(urlSlackWebHook, payload);
            webhookResponse.getMessage();
        } catch (IOException e) {
            System.out.println("Unexpected Error! WebHook:" + urlSlackWebHook);
        }
    }

    public void sendTestExecutionReportToSlack(String testReportPath) throws Exception {
        String url = "https://slack.com/api/files.upload ";
        try {
            HttpClient httpclient = HttpClientBuilder.create().disableContentCompression().build();
            HttpPost httppost = new HttpPost(url);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            FileBody fileBody = new FileBody(new File(testReportPath));
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.addPart("file", fileBody);
            builder.addTextBody("channels", channelName);
            builder.addTextBody("token", botUserOAuthAccessToken);
            httppost.setEntity(builder.build());
            HttpResponse response = null;
            response = httpclient.execute(httppost);
            HttpEntity result = response.getEntity();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
