package com.GruppG.IOT_System;

import models.DHTSensor;
import repository.SensorDAO;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "historicalData", value = "/historicalData")
public class DataServlet extends HttpServlet{


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SensorDAO sensorDAO = new SensorDAO();
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"sv\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    \n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl\" crossorigin=\"anonymous\">\n" +
                "    <link rel=\"stylesheet\" href=\"data.css\">\n" +
                "     \n" +
                "    <title>Historical data</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"header\">\n" +
                "        <h1>Grupp G</h1>\n" +
                "        <p>Temperature data</p>\n" +
                "    </div>\n" +
                "    <div class=\"container mt-5\">\n" +
                "        <table class=\"table\">\n" +
                "            <thead>\n" +
                "            <tr>\n" +
                "                <th scope=\"col\">ID</th>\n" +
                "                <th scope=\"col\">Temperature</th>\n" +
                "                <th scope=\"col\">Humidity</th>\n" +
                "                <th scope=\"col\">Datetime</th>\n" +
                "            </tr>");

        for (DHTSensor c : sensorDAO.getAll()) {

            out.println("            <tr>\n" +
                    "                <td>"+c.getId()+"</td>\n" +
                    "                <td>"+c.getTemperature()+"°C</td>\n" +
                    "                <td>"+c.getHumidity()+"%</td>\n" +
                    "                <td>"+c.epochToDate()+"</td>\n" +
                    "            </tr>");
        }

        out.println(
                "        </table>\n" +
                        "        </div>\n" +
                        "    \n" +
                        "</body>\n" +
                        "</html>");

    }
    public void destroy() {
    }
}
