package de.itgain.hdl;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;

@Component
public class CorsFilter implements WebFilter {

	private static final String ALLOW_ORIGINS = "*";

	private static final String MAX_AGE = "1728000";

	private static final String ALLOW_METHODS = "GET, PUT, POST, DELETE, OPTIONS";

	private static final String ALLOW_EXPOSE_HEADER = "DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Content-Range,Range";

	@Override
	public Mono<Void> filter(final ServerWebExchange serverWebExchange, final WebFilterChain webFilterChain) {
		serverWebExchange.getResponse().getHeaders().add("Access-Control-Allow-Origin", ALLOW_ORIGINS);
		serverWebExchange.getResponse().getHeaders().add("Access-Control-Allow-Methods", ALLOW_METHODS);
		serverWebExchange.getResponse().getHeaders().add("Access-Control-Allow-Headers", ALLOW_EXPOSE_HEADER);

		if (serverWebExchange.getRequest().getMethod() == HttpMethod.OPTIONS) {
			serverWebExchange.getResponse().getHeaders().add("Access-Control-Max-Age", MAX_AGE);
			serverWebExchange.getResponse().setStatusCode(HttpStatus.NO_CONTENT);

			return Mono.empty();
		} else {
			serverWebExchange.getResponse().getHeaders().add("Access-Control-Expose-Headers", ALLOW_EXPOSE_HEADER);

			return webFilterChain.filter(serverWebExchange);
		}
	}
}