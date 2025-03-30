package com.example.sokolova_alena.endpoints;

import com.example.sokolova_alena.Models.CustomerObject;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleEndponts {

    static String lastString;

    @GetMapping (path = "/getString")
    public String getString (@RequestParam(defaultValue = "empty") String str ){
        lastString = str;
        return str.trim();
    }

    @GetMapping (path = "/getInteger")
    public Integer getInt (@RequestParam(defaultValue = "123", required = true) Integer number ){
        return number;
    }

    @GetMapping (path = "/getLastSring")
    public  String getLastString (){
        if (lastString!=null){
        return lastString;}
        return "Строка еще не передана";
    }

    @DeleteMapping (path ="/deleteLastString")
    public void deleteLastString (){
        lastString = null;
    }


    @GetMapping (path ="getJson")
    public String getJson (){
        JSONObject newJsonOnject = new JSONObject();
        newJsonOnject.put("query","куртка");
        newJsonOnject.put("page","0");
        newJsonOnject.put("size","10");
        return newJsonOnject.toString();
    }

    @GetMapping (path ="/getObject")
    public CustomerObject getCustomerObject (){
        CustomerObject c = new CustomerObject("rj", 22, 15);
//        c.setQuery("кошка");
//        c.setPage(22);
        return c;
    }

}
