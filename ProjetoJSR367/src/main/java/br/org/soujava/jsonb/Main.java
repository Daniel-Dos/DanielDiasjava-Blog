package br.org.soujava.jsonb;

import java.time.LocalDate;
import java.time.Month;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import br.org.soujava.jsonb.modelo.Meetup;

public class Main {
    public static void main(String[] args) {

        JsonbConfig jsonbConfig = new JsonbConfig().withFormatting(true);
        Jsonb jsonB = JsonbBuilder.create(jsonbConfig);

        Meetup meetupJunho = new Meetup("Daniel", "Daniel é Desenvolvedor Java EE...",
                                        "Conhecendo a JSR 382 - Configuration API 1.0", 
                                        LocalDate.of(2019, Month.JUNE, 20));

        System.out.println(jsonB.toJson(meetupJunho));
        
        meetupJunho = jsonB.fromJson("{\"dataEvento\":\"20/06/2019\",\"miniBio\":\"Daniel é Desenvolvedor Java EE...\",\"nomePalestrante\":\"Daniel\",\"tituloPalestra\":\"Conhecendo a JSR 382 - Configuration API 1.0\"}\n" + 
                "", Meetup.class);
      
        System.out.println(meetupJunho);
    }
}