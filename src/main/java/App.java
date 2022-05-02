import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
      staticFileLocation("/public");
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


    }

}
