package br.com.bikelock.config;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse; // Importe a classe HttpServletResponse
import java.io.IOException;

@WebFilter("/*")
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        // Faz um cast explícito para HttpServletResponse
        HttpServletResponse httpResponse = (HttpServletResponse) res;

        // Adiciona os cabeçalhos CORS
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");

        // Continua com a cadeia de filtros
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Pode ser necessário realizar alguma inicialização, mas aqui não é necessário
    }

    @Override
    public void destroy() {
        // Pode ser necessário liberar recursos, mas aqui não é necessário
    }
}
