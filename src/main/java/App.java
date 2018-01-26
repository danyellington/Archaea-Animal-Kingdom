import com.google.gson.Gson;
import exceptions.ApiException;
import models.*;
import org.sql2o.Sql2o;
import static spark.Spark.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Sql2oArchaeaDomainDao sql2oArchaeaDomainDao;
        Sql2oArchaeaPhylumDao sql2oArchaeaPhylumDao;
        Sql2oArchaeaClassDao sql2oArchaeaClassDao;
        Sql2oArchaeaOrderDao sql2oArchaeaOrderDao;
        Sql2oArchaeaFamilyDao sql2oArchaeaFamilyDao;
        Sql2oArchaeaGenusDao sql2oArchaeaGenusDao;
        Sql2oArchaeaSpeciesDao sql2oArchaeaSpeciesDao;
        Connection conn;
        Gson gson = new Gson();
        String connectionString = "jdbc:h2:~/animalkingdom.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        sql2oArchaeaDomainDao = new Sql2oArchaeaDomainDao(sql2o);
        sql2oArchaeaPhylumDao = new Sql2oArchaeaPhylumDao(sql2o);
        sql2oArchaeaClassDao = new Sql2oArchaeaClassDao(sql2o);
        sql2oArchaeaOrderDao = new Sql2oArchaeaOrderDao(sql2o);
        sql2oArchaeaFamilyDao = new Sql2oArchaeaFamilyDao(sql2o);
        sql2oArchaeaGenusDao = new Sql2oArchaeaGenusDao(sql2o);
        sql2oArchaeaSpeciesDao = new Sql2oArchaeaSpeciesDao(sql2o);

        get("/domains", "application/json", (req, res) -> {
            if(sql2oArchaeaDomainDao.getAll().size() > 0){
                return gson.toJson(sql2oArchaeaDomainDao.getAll());
            } else {
                return "{\"message\" :\"I'm sorry, but no domains are in the database.\"}";
            }
        });

        //FILTERS
        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = (ApiException) exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });

        after((req, res) ->{
            res.type("application/json");
        });
    }
}
