package demo;

import demo.models.Film;
import demo.models.Gatunek;
import demo.models.Ocena;
import demo.service.FilmService;
import demo.service.GatunekService;
import demo.service.OcenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import java.util.Date;

@SpringBootApplication
public class Application implements CommandLineRunner, ApplicationListener<ContextClosedEvent> {

    @Autowired
    private FilmService filmService;

    @Autowired
    private GatunekService gatunekService;

    @Autowired
    private OcenaService ocenaService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println("Rozpoczęto działanie.");
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {

    }
}
