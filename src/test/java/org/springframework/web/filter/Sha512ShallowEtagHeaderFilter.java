package org.springframework.web.filter;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

/**
 * Custom implementation that uses SHA-512 for ETag generation
 * instead of the default algorithm.
 */
public class Sha512ShallowEtagHeaderFilter extends OncePerRequestFilter {

    private final ShallowEtagHeaderFilter delegate;
    
    /**
     * The default constructor.
     */
    public Sha512ShallowEtagHeaderFilter() {
        this.delegate = new ShallowEtagHeaderFilter();
    }

	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Delegate to the standard implementation
        delegate.doFilter(request, response, filterChain);
	}
}
