package com.asoriach.ecommerce.vista;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asoriach.ecommerce.modelo.Usuario;
import com.asoriach.ecommerce.negocio.UsuarioTrs;

/**
 * Servlet implementation class ServeltLogin
 */
@WebServlet(description ="Clase para procesar los valores ingresados en el formulario login", urlPatterns = "/abcd") // Clase qeu funciona con servidores web 
public class ServeltLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeltLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//1. Recuperar datos enviados
		String nombreUsuario = request.getParameter("txtNomUsu"); // valor atributo name de su componente html 
		String claveUsuario = request.getParameter("ptxtClaUsu");
		
		//Integer valor = Integer.parseInt(request.getParameter(claveUsuario));
		//System.out.println(nombreUsuario + "-" + claveUsuario);
		
		//2. Procesar Peticion 
		UsuarioTrs adminUsu = new UsuarioTrs();
		Usuario usu = adminUsu.validarusuario(nombreUsuario,claveUsuario);
		
		if(usu!= null) {
			// reenviar menu
		}else {
			// Mensaje Cred incorrecta
			PrintWriter escritor = response.getWriter();
			escritor.print("<b><label>Credenciales Incorrectas !!!</label></b>");
			escritor.close();
			
			
		}
		
	}

}
