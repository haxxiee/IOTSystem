package com.GruppG.IOT_System;

import repository.SensorDAO;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "realtime", value = "/realtime")
public class RealtimeServlet extends HttpServlet{


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SensorDAO sensorDAO = new SensorDAO();
        response.setIntHeader("Refresh", 5);
        response.setContentType("text/html");


        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Mange Schmidt</title>\n" +
                "  <link rel=\"stylesheet\" href=\"realtime.css\">\n" +
                "</head>\n" +
                "<style>\n" +
                "  .timetext{\n" +
                "    color: white;\n" +
                "    font-family: Helvetica, sans-serif;\n" +
                "    font-size: 50px;\n" +
                "\n" +
                "    position: absolute;\n" +
                "    left: 30%;\n" +
                "    top: 65%;\n" +
                "  }\n" +
                "</style>" +
                "<body>");

        out.println("  <div class=\"temp\">\n" +
                "    <p>"+sensorDAO.getLatest().getTemperature()+"°C</p>\n" +
                "  </div>\n" +
                "  <div class=\"hum\">\n" +
                "    <p>"+sensorDAO.getLatest().getHumidity()+"%</p>\n" +
                "  </div>");

        out.println("  <div class=\"celsiusText\">\n" +
                "    <p>CELCIUS</p>\n" +
                "  </div>\n" +

                "  <div class=\"humidityText\">\n" +
                "    <p>HUMIDITY</p>\n" +
                "  </div>\n" +
                "  <div class=\"timetext\">\n" +
                "    <p>"+sensorDAO.getLatest().epochToDate()+"</p>\n" +
                "  </div>\n" +
                "\n" +
                "</body>\n" +
                "</html>");

    }
    public void destroy() {
    }
}
