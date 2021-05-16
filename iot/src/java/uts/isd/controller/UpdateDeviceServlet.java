package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.*;

/**
 *
 * @author George
 */
public class UpdateDeviceServlet extends HttpServlet {
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.getRequestDispatcher("editdevice.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String deviceName = request.getParameter("deviceName");
        String deviceType = request.getParameter("deviceType");
        String devicePrice = request.getParameter("devicePrice");
        String deviceStock = request.getParameter("deviceStock");
        DeviceManager deviceManager = (DeviceManager) session.getAttribute("deviceManager");        
        Validator validator = new Validator();
        validator.clear(session);
        
        if(!validator.validateDeviceInt(devicePrice)){
            session.setAttribute("updateErr", "Error: price format incorrect");
            request.getRequestDispatcher("editdevice.jsp").include(request, response);
        }
        else if(!validator.validateDeviceInt(deviceStock)){
            session.setAttribute("updateErr", "Error: stock format incorrect");
            request.getRequestDispatcher("editdevice.jsp").include(request, response);
        }
        else{
            try {
            Device device = new Device(deviceName,deviceType,devicePrice,deviceStock);
            if (device != null) {
                session.setAttribute("device", device);
                deviceManager.updateDevice(deviceName,deviceType,devicePrice,deviceStock);
                session.setAttribute("resultInfor", "Update was successful");
                request.getRequestDispatcher("editdevice.jsp").include(request, response);
            } else {
                session.setAttribute("resultInfor", "Update was not successful!");
                request.getRequestDispatcher("editdevice.jsp").include(request, response);
            }
        }   catch (SQLException | NullPointerException ex) {
              
            }
        } 
    }
}
