package vn.ithcmute.csp;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CSPFilter implements Filter {
	// Chỉ thị default-src: Mặc định chỉ tải từ domain trang web này và trang https://www.google.com	
	public static final String defaultSrc = "default-src 'self'"
			+ " https://www.google.com;";
	
	// Chỉ thị img-src: Chỉ tải hình ảnh từ domain trang web này và các trang được khai báo
	public static final String imgSrc = " img-src 'self'"
			+ " https://hasthemes.com"
			+ " http://www.w3.org;";
	
	// Chỉ thị style-src: Chỉ tải CSS từ domain trang web này và các trang được khai báo	
	public static final String styleSrc = " style-src 'self' 'unsafe-inline'"
			+ " https://fonts.googleapis.com"
			+ " http://fonts.googleapis.com"
			+ " https://stackpath.bootstrapcdn.com"
			+ " http://maxcdn.bootstrapcdn.com"
			+ " https://use.fontawesome.com"
			+ " https://cdnjs.cloudflare.com;";
	
	// Chỉ thị font-src: Chỉ tải webfont từ domain trang web này và các trang được khai báo
	public static final String fontSrc = " font-src 'self'"
			+ " https://fonts.gstatic.com"
			+ " https://use.fontawesome.com"
			+ " https://cdnjs.cloudflare.com;";
	
	// Chỉ thị script-src: Chỉ tải Javascript từ domain trang web này và các trang được khai báo
	public static final String scriptSrc = " script-src 'self' 'unsafe-inline'"
			+ " https://code.jquery.com"
			+ " http://code.jquery.com"
			+ " http://cdnjs.cloudflare.com"
			+ " https://stackpath.bootstrapcdn.com"
			+ " http://maxcdn.bootstrapcdn.com"
			+ " https://ajax.googleapis.com"
			+ " https://unpkg.com"
			+ " https://cdn.jsdelivr.net;";
	
	// Chỉ thị form-action: Các form trên trang web chỉ được submit về domain trang web này
	public static final String formAction = " form-action 'self';";
	
	// Chỉ thị frame-ancestors: Không trang web nào được nhúng trang web này ngoài trừ chính nó.
	public static final String frameAncestors = " frame-ancestors 'self'";
	
	public static final String POLICY = defaultSrc + imgSrc + styleSrc + fontSrc + scriptSrc + formAction + frameAncestors;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		if (response instanceof HttpServletResponse) {
			// Set CSP header cho response			
        	((HttpServletResponse)response).setHeader("Content-Security-Policy", CSPFilter.POLICY);
    	}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
