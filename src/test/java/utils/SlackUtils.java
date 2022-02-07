package utils;

import io.restassured.http.ContentType;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class SlackUtils {

	private static String urlSlackWebHook = "https://hooks.slack.com/services/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";
	
    public static void slackPassed(String channelName,String pretext, String titleText, String textMessage)  {
        given().
                baseUri(urlSlackWebHook).
                contentType(ContentType.JSON).
                when().body("{\n" +
                        "\t\"channel\": \""+channelName+"\",\n" +
                        "\t\"icon_emoji\": \":mega:\",\n" +
                        "\t\"attachments\": [{\n" +
                        "\t\t\"pretext\": \""+pretext+"\",\n" +
                        "\t\t\"color\": \"#29343c\",\n" +
                        "\t},\n" +
                        "{\t\t\"color\": \"#36a64f\",\n" +
                        "\t\t\"title\": \""+titleText+"\",\n" +
                        "\t  \"text\": \"" + textMessage + "\"\n" +
                        "\t},\n" +
                        "{\t\t\"color\": \"#08c4ac\",\n" +
                        "\t\t\"title\": \""+"Author: "+"\",\n" +
                        "\t  \"text\": \"" + "M Nur" + "\"\n" +
                        "\t}" +
                        "],\n" +
                        "\t\"username\": \"mnur\"\n" +
                        "}\n").post().
                then().statusCode(200);
    }
    public static void slackFailed(String channelName,String pretext, String titleText, String textMessage)  {
        given().
                baseUri(urlSlackWebHook).
                contentType(ContentType.JSON).
                when().body("{\n" +
                        "\t\"channel\": \""+channelName+"\",\n" +
                        "\t\"icon_emoji\": \":mega:\",\n" +
                        "\t\"attachments\": [{\n" +
                        "\t\t\"pretext\": \""+pretext+"\",\n" +
                        "\t\t\"color\": \"#29343c\",\n" +
                        "\t},\n" +
                        "{\t\t\"color\": \"#f65109\",\n" +
                        "\t\t\"title\": \""+titleText+"\",\n" +
                        "\t  \"text\": \"" + textMessage + "\"\n" +
                        "\t},\n" +
                        "{\t\t\"color\": \"#08c4ac\",\n" +
                        "\t\t\"title\": \""+"Author: "+"\",\n" +
                        "\t  \"text\": \"" + "M Nur" + "\"\n" +
                        "\t}" +
                        "],\n" +
                        "\t\"username\": \"mnur\"\n" +
                        "}\n").post().
                then().statusCode(200);
    }

    public static void slackTestResult(String channelName,String pretext, String titleTextPass,String titleFail, int countResultPass, int countResultFail)  {
        given().
                baseUri(urlSlackWebHook).
                contentType(ContentType.JSON).
                when().body("{\n" +
                        "\t\"channel\": \""+channelName+"\",\n" +
                        "\t\"icon_emoji\": \":mega:\",\n" +
                        "\t\"attachments\": [{\n" +
                        "\t\t\"pretext\": \""+pretext+"\",\n" +
                        "\t\t\"color\": \"#29343c\",\n" +
                        "\t},\n" +
                        "{\t\t\"color\": \"#36a64f\",\n" +
                        "\t\t\"title\": \""+titleTextPass+"\",\n" +
                        "\t  \"text\": \"" + countResultPass + "\"\n" +
                        "\t},\n" +
                        "{\t\t\"color\": \"#f65109\",\n" +
                        "\t\t\"title\": \""+titleFail+"\",\n" +
                        "\t  \"text\": \"" + countResultFail + "\"\n" +
                        "\t},\n" +
                        "{\t\t\"color\": \"#08c4ac\",\n" +
                        "\t\t\"title\": \""+"Author: "+"\",\n" +
                        "\t  \"text\": \"" + "M Nur" + "\"\n" +
                        "\t}" +
                        "],\n" +
                        "\t\"username\": \"mnur\"\n" +
                        "}\n").post().
                then().statusCode(200);
    }
}
