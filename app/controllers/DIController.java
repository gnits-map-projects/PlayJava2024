package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.typesafe.config.Config;
import models.Book;
import models.responses.BookResponse;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.ComputationService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DIController extends Controller {

    private final Config config;
    private final ComputationService compute;
   @Inject
    public  DIController(Config config, ComputationService compute) {
        this.config = config;
       this.compute = compute;
    }

    //DI with configuration read
    public Result calculate() {
       Integer value = compute.calculate();
        Boolean isEnabled = config.getBoolean("feature.enable");
       if(isEnabled)
            return ok(value.toString());
       else
           return ok("feature not enabled");
    }


}
