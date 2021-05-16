
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
 * @author 47288
 */
public class DeleteDeviceServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.getRequestDispatcher("editdevice.jsp").include(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String deviceName = request.getParameter("deviceNameD");
        String deviceType = request.getParameter("deviceTypeD");
        DeviceManager deviceManager = (DeviceManager) session.getAttribute("deviceManager");  
        validator.clear(session);
        
        if(!validator.validateDeviceType(deviceType)){
            session.setAttribute("typeErrD", "Error: type format incorrect");
            request.getRequestDispatcher("editdevice.jsp").include(request, response);
        }
        else{    
            try{
                if(deviceManager.checkDevice(deviceName, deviceType)){
                    deviceManager.deleteDevice(deviceName, deviceType);
                    session.setAttribute("resultInfor", "Delete device was successful!");
                    request.getRequestDispatcher("editdevice.jsp").include(request, response);}
                else{
                     session.setAttribute("resultInfor", "Delete device was not successful! Device does not exist in the database.");
                    request.getRequestDispatcher("editdevice.jsp").include(request, response);
                }
                
            } catch (SQLException | NullPointerException ex){
            }
        }
}
}