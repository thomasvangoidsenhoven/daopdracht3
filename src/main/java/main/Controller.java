package main;

import domain.Gemeente;
import domain.GemeenteDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class Controller
{
    private GemeenteDB db;

    @Autowired
    private DiscoveryClient discoveryClient;


    public Controller(@Autowired GemeenteDB db)
    {
        this.db = db;
    }

    @RequestMapping(value = "/getInfo")
    public String getInfo(@RequestParam("naam") String naam)
    {
        return db.getGemeenteInfo(naam);
    }


}
