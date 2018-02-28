package org.openmrs.module.facespsmart;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.web.RestUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * Created by rugute on 2/27/18.
 */
public class AuthorizationFilter implements Filter {
    protected final Log log = LogFactory.getLog(getClass());

    /**
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */

    public void init(FilterConfig arg0) throws ServletException {
        log.debug("Initializing REST WS Authorization filter");
    }

    /**
     * @see javax.servlet.Filter#destroy()
     */

    public void destroy() {
        log.debug("Destroying REST WS Authorization filter");
    }

    /**
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        // check the IP address first.  If its not valid, return a 403
        if (!RestUtil.isIpAllowed(request.getRemoteAddr())) {
            // the ip address is not valid, set a 403 http error code
            HttpServletResponse httpresponse = (HttpServletResponse) response;
            httpresponse.sendError(HttpServletResponse.SC_FORBIDDEN, "IP address '" + request.getRemoteAddr()
                    + "' is not authorized");
        }

        // skip if the session has timed out, we're already authenticated, or it's not an HTTP request
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            if (httpRequest.getRequestedSessionId() != null && !httpRequest.isRequestedSessionIdValid()) {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Session timed out");
            }

            if (!Context.isAuthenticated()) {
                String basicAuth = httpRequest.getHeader("Authorization");
                if (basicAuth != null) {
                    // this is "Basic ${base64encode(username + ":" + password)}"
                    try {
                        basicAuth = basicAuth.substring(6); // remove the leading "Basic "
                        String decoded = new String(Base64.decodeBase64(basicAuth), Charset.forName("UTF-8"));
                        String[] userAndPass = decoded.split(":");
                        Context.authenticate(userAndPass[0], userAndPass[1]);
                        if (log.isDebugEnabled())
                            log.debug("authenticated " + userAndPass[0]);
                    }
                    catch (Exception ex) {
                        // This filter never stops execution. If the user failed to
                        // authenticate, that will be caught later.
                    }
                }
            }
        }

        // continue with the filter chain in all circumstances
        chain.doFilter(request, response);
    }

    @Override
    public boolean isLoggable(LogRecord logRecord) {
        return false;
    }
}
