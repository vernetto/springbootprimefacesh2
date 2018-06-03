package org.pierre.mavenfilter;

import java.util.Arrays;

import org.littleshoot.proxy.HttpFiltersAdapter;
import org.littleshoot.proxy.HttpFiltersSource;
import org.springframework.stereotype.Component;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;

@Component
public class MavenFilter implements HttpFiltersSource {
	private static final String HTTP_REPO1_MAVEN_ORG_MAVEN2 = "http://repo1.maven.org/maven2/";


   
	public HttpFiltersAdapter filterRequest(HttpRequest originalRequest, ChannelHandlerContext ctx) {
		return new HttpFiltersAdapter(originalRequest) {
			@Override
			public HttpResponse clientToProxyRequest(HttpObject httpObject) {
				// TODO: implement your filtering here
				System.out.println("clientToProxyRequest invoked");
				System.out.println(httpObject.toString());
				if (httpObject instanceof DefaultHttpRequest) {
					DefaultHttpRequest request = (DefaultHttpRequest) httpObject;
					System.out.println("it's a DefaultHttpRequest with uri:");
					String uri = request.getUri();
					System.out.println(uri);
					System.out.println(request.toString());
					System.out.println(request.headers());
					if (uri.startsWith(HTTP_REPO1_MAVEN_ORG_MAVEN2)) {
						String gavstring = uri.substring(HTTP_REPO1_MAVEN_ORG_MAVEN2.length());
						System.out.println("gavstring=" + gavstring);
						String[] parts = gavstring.split("/");
						int len = parts.length;
						if (len < 4) {
							System.err.println("invalid length for gavstring " + gavstring + " len = " + len
									+ " should be at least 4");
						} else {
							String filename = parts[len - 1];
							String version = parts[len - 2];
							String artifactid = parts[len - 3];
							String group = String.join(".", Arrays.copyOfRange(parts, 0, len - 3));
							System.out.println("filename=" + filename + " version=" + version + " artifactid="
									+ artifactid + " group=" + group);
						}

					}
				}
				System.out.println();
				return null;
			}

			@Override
			public HttpObject serverToProxyResponse(HttpObject httpObject) {
				System.out.println("serverToProxyResponse invoked");
				System.out.println(httpObject.toString());
				System.out.println();
				return httpObject;
			}
		};
	}

	@Override
	public int getMaximumRequestBufferSizeInBytes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaximumResponseBufferSizeInBytes() {
		// TODO Auto-generated method stub
		return 0;
	}

}
