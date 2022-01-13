package fr.eni.VenteEnchere.ihm.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class connexionFilter
 */
@WebFilter("/ConnexionServlet")
public class connexionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public connexionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		String nextScreen = "ConnexionServlet";
		
//		if (((HttpServletRequest)request).getSession().getAttribute("utilisateur") != null) {
//			nextScreen = "MonProfilServlet";
//		}
		
//		request.getRequestDispatcher(nextScreen).forward(request, response);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
