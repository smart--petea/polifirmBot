package r;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyBean {
    public MyBean() {}

    public void downloadIt() {
        String uri = "http://www.polfirms.ru/domiogrod/index.html";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        String body = response.getBody();


        Pattern categoryPattern = Pattern.compile("portfolio-wrap.*?href=\"(?<categoryUrl>[^\"]*)\"", Pattern.MULTILINE | Pattern.DOTALL);
        Matcher categoryMatcher = categoryPattern.matcher(body);

        //while(categoryMatcher.find()) {
            System.out.println("processing " + categoryMatcher.group("categoryUrl") + " ... ");
        //}
    }
}
