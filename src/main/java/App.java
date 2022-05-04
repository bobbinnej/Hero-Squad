import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


import static spark.Spark.*;
import static spark.Spark.post;
public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

      staticFileLocation("/public");
      Hero.setUpNewHero1();
      Hero.setUpNewHero2();
      get("/", (request, response)->{
          Map<String, Object>model=new HashMap<String, Object>();
          return new ModelAndView(model, "index.hbs");
              }, new HandlebarsTemplateEngine());

      get("/landing-page", (request, respond)->{
          Map<String, Object>model=new HashMap<>();
          return new ModelAndView(model, "landing-page.hbs");
              }, new HandlebarsTemplateEngine() );

      get("/hero-form", (request,respond)->{
        Map<String, Object>model= new HashMap<>();
        return new ModelAndView(model, "hero-form.hbs");
      },new HandlebarsTemplateEngine());

      get("/hero", (request,respond)->{
          Map<String,Object>model=new HashMap<>();
          ArrayList<Hero> hero = Hero.getAllInstances();
          model.put("hero", hero);
          return new ModelAndView(model, "hero.hbs");
      },  new HandlebarsTemplateEngine());

        post("/new/hero",(request, respond) ->{
            Map<String, Object> model = new HashMap<>();

            String name = request.queryParams("name");
            Integer age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");

            Hero newHero = new Hero(name,age,power,weakness);
            request.session().attribute("item",name);
            model.put("item",request.session().attribute("item"));
            model.put("newHero",newHero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

          get("/new/:id",(request, respond)->{
              Map<String,Object>model= new HashMap<>();
              int idOfHero = Integer.parseInt(request.params(":id"));
              Hero foundHero = Hero.findById(idOfHero);
              model.put("hero",foundHero);
              return new ModelAndView(model,"hero-details.hbs");
          }, new HandlebarsTemplateEngine());

          get("/squad-form",(request, respond)->{
              Map<String, Object>model=new HashMap<>();
              return new ModelAndView(model,"squad-form.hbs");
          }, new HandlebarsTemplateEngine());

          get("/squad", (request,respond)->{

              Map<String, Object> model = new HashMap<>();
              ArrayList<Squad> squads = Squad.getInstances();
              model.put("squads",squads);
              ArrayList<Hero> members = Hero.getAllInstances();
              model.put("heroes",members);
              Squad newSquad = Squad.findBySquadId(1);
              model.put("allSquadMembers", newSquad.getSquadMembers());
              return new ModelAndView(model, "squad.hbs");
          }, new HandlebarsTemplateEngine());
    }

}
