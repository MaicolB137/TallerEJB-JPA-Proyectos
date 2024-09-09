/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.edu.unipiloto.arquitectura.vota.entity.Proyectos;
import co.edu.unipiloto.arquitectura.vota.session.ProyectosFacadeLocal;

import javax.ejb.EJB;

/**
 *
 * @author Michael
 */
@WebServlet(name = "VotaServlet", urlPatterns = {"/VotaServlet"})
public class VotaServlet extends HttpServlet {

    @EJB
    private ProyectosFacadeLocal proyectosFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String votaIdstr = request.getParameter("PROYECTOID");
        Integer id = null;
        if (votaIdstr != null && !votaIdstr.trim().isEmpty()) {
            try {
                id = Integer.parseInt(votaIdstr);
            } catch (NumberFormatException e) {

            }
        }

        String NombreProyecto = request.getParameter("NOMBREPROYECTO");
        String Descripcion = request.getParameter("DESCRIPCION");
        String Localidad = request.getParameter("LOCALIDAD");

        String Presupuestostr = request.getParameter("presupuesto");
        Integer Presupuesto = null;
        if (Presupuestostr != null && !Presupuestostr.trim().isEmpty()) {
            try {
                Presupuesto = Integer.parseInt(Presupuestostr);
            } catch (NumberFormatException e) {

            }
        }
        String NumeroHabitantesstr = request.getParameter("NUMEROHABITANTES");
        Integer numerohabitantes = null;
        if (NumeroHabitantesstr != null && !NumeroHabitantesstr.trim().isEmpty()) {
            try {
                numerohabitantes = Integer.parseInt(NumeroHabitantesstr);
            } catch (NumberFormatException e) {
                // Manejo de error
            }
        }

        Proyectos Votos = new Proyectos(id, NombreProyecto, Descripcion, Localidad, Presupuesto,numerohabitantes);

        if ("Add".equalsIgnoreCase(action)) {
            proyectosFacade.create(Votos);
        } else if ("Edit".equalsIgnoreCase(action)) {
            proyectosFacade.edit(Votos);
        } else if ("Delete".equalsIgnoreCase(action)) {
            proyectosFacade.remove(Votos);
        } else if ("Search".equalsIgnoreCase(action)) {
            Votos = proyectosFacade.find(id);
            List<Proyectos> voto = new ArrayList<>();
            if (Votos != null) {
                voto.add(Votos);
            }
            request.setAttribute("stud", Votos);
            request.setAttribute("allStudents", voto);
            request.getRequestDispatcher("VotaInfo.jsp").forward(request, response);
            return;
        }

        List<Proyectos> voto = proyectosFacade.findAll();
        request.setAttribute("stud", Votos);
        request.setAttribute("allStudents", voto);
        request.getRequestDispatcher("VotaInfo.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
