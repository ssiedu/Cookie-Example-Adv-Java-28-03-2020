import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PScore extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int aScore=80, bScore=90, cScore=95;
            PrintWriter out=response.getWriter();
            
            //reading the cookie to know the current user.
            //step-1 (get all the cookies coming with request)
            Cookie ck[]=request.getCookies();
            //step-2 (searching for the desired one)
            String user="";
            for(Cookie c:ck){
                String name=c.getName();
                if(name.equals("userid")){
                    user=c.getValue();
                    break;
                }
            }
            
            if(user.equals("A")){
                out.println("Physics Score of A :"+aScore);
            }else if(user.equals("B")){
                out.println("Physics Score of B :"+bScore);
            }else if(user.equals("C")){
                out.println("Physics Score of C :"+cScore);
            }

            out.close();
        
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
