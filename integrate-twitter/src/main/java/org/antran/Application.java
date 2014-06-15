package org.antran;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
@ImportResource("integration.xml")
public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(Application.class);
	}

	@Bean
	public String newline() {
		return System.getProperty("line.separator");
	}

	@Bean
	public TwitterTemplate twitterTemplate(OAuth2Operations oauth2) {
		return new TwitterTemplate(oauth2.authenticateClient().getAccessToken());
	}

	@Bean
	// -DclientId=ooDUdy1sHXMgGGmWDZ6f6jyXt
	// -DclientSecret=aKH8lXgsf9eOPtY4FqpMyhSKs4INHfpltXvu2siUXQXXOCGWZ0
	public OAuth2Operations oauth2Template(Environment env) {
		return new OAuth2Template(env.getProperty("clientId"),
				env.getProperty("clientSecret"), "",
				"https://api.twitter.com/oauth2/token");
	}
}
