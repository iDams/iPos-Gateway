package cl.ibss.reale.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class SimpleFilter extends ZuulFilter {
	   private static Logger  log = LoggerFactory.getLogger(SimpleFilter.class);
	   @Override
	   public String filterType() {
	       return "pre";
	   }
	   @Override
	   public int filterOrder() {
	       return 1;
	   }
	   @Override
	   public boolean shouldFilter() {
	       return true;
	   }
	   @Override
	   public Object run() {
	       RequestContext ctx = RequestContext.getCurrentContext();
	       HttpServletRequest request = ctx.getRequest();
	       log.info(String.format("%s request from %s to %s", request.getMethod(), request.getRemoteAddr(),  request.getRequestURL().toString()));
	       return null;
	   }
	}