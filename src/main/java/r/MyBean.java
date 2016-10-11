package r;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyBean {
    private RestTemplate restTemplate = new RestTemplate();
    private Pattern categoryPattern = Pattern.compile("portfolio-wrap.*?href=\"(?<categoryUrl>[^\"]*)\"", Pattern.MULTILINE | Pattern.DOTALL);
    private Pattern trPattern = Pattern.compile("<tr>(?<trGroup>(.*?<td.*?(?<!<td)){3})</tr>", Pattern.MULTILINE | Pattern.DOTALL);
    private Pattern mailPattern = Pattern.compile("href=\"mailto:(?<mail>[^\"]*)\"");

    public MyBean() {}

    private String downloadPage(String uri) {
        return restTemplate.getForEntity(uri, String.class).getBody();
    }

    public void downloadIt() {
        //String mainBody = downloadPage( "http://www.polfirms.ru/domiogrod/index.html");

        //Matcher categoryMatcher = categoryPattern.matcher(mainBody);

        //categoryMatcher.find();
        //while(categoryMatcher.find()) {
            //String category = categoryMatcher.group("categoryUrl");
            //System.out.println("processing " + category + " ... ");
            String categoryBody = downloadPage("http://www.polish.ru/A01/ru.html");
            Matcher trMatcher = trPattern.matcher(categoryBody);
            trMatcher.find();
            while(trMatcher.find()) {
                String trBody = trMatcher.group("trGroup");
    //            System.out.println(trBody);

                Matcher mailMatcher = mailPattern.matcher(trBody);
                if(mailMatcher.find()) {
                    System.out.println(mailMatcher.group("mail"));
                }
            }
        //}
    }
}
