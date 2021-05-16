
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
public class FindEditDeviceServlet extends HttpServlet {  
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.getRequestDispatcher("devicepage.jsp").include(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String deviceName = request.getParameter("deviceName");
        String deviceType = request.getParameter("deviceType");
        DeviceManager deviceManager = (DeviceManager) session.getAttribute("deviceManager");    
        Device device = null;    
        validator.clear(session);
        
         if(!validator.validateDeviceType(deviceType)){
            session.setAttribute("typeErr", "Error: type format incorrect");
            request.getRequestDispatcher("devicepage.jsp").include(request, response);
        }
        else{
            try{
               
                if(deviceManager.checkDevice(deviceName, deviceType)){
                    device = deviceManager.findDevice(deviceName, deviceType);
                    session.setAttribute("device", device);
                    request.getRequestDispatcher("editdevice.jsp").include(request, response);
                }
                else{
                    session.setAttribute("existErr", "Device does not exist in the Database");
                    request.getRequestDispatcher("devicepage.jsp").include(request, response);
                }
            } catch (SQLException ex){
                Logger.getLogger(FindDeviceServlet.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
       
    }
}
