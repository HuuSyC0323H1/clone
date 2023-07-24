package Servlet;

import DAO.PhotoDao;
import Model.Photos;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(value = "/index")
public class PhotoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.setContentType("text/html; charset=UTF-8");
        //b1:get data form photo
        //b2: set data toi jsp
        PhotoDao photoDao = new PhotoDao();
        List<Photos> list = photoDao.getListPhoto();
        request.setAttribute("listPhotos", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }
}


