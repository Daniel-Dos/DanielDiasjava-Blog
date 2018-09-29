/*
 * The MIT License
 * Copyright © 2017 Daniel Dias
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.org.soujava.rio.app;

import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import java.util.Optional;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import br.org.soujava.rio.model.JUG;
import br.org.soujava.rio.model.ResponseModel;
import br.org.soujava.rio.repository.JUGRepository;
import io.javalin.Javalin;
import io.javalin.json.JavalinJson;

/**
 * @author <a href="mailto:daniel.dias@soujava.org.br">Daniel Dias</a>
 * github:Daniel-Dos 
 * twitter:@danieldiasjava
 */
public class ApplicationMain {

    @Inject
    private JUGRepository jugRepository;

    public static Optional<String> port = Optional.ofNullable(System.getenv("PORT"));

    public void main(@Observes ContainerInitialized event) {
        Javalin javalin = Javalin.create()
                                 .enableCorsForAllOrigins()
                                 .defaultContentType("application/json")
                                 .start(Integer.parseInt(port.orElse("8080")));
        Jsonbind();

        javalin.routes(() -> {
            path("jugs", () -> {

                get(ctx -> {
                    ctx.json(jugRepository.findAll());
                });

                get(":codigo", ctx -> {
                    ctx.json(jugRepository.findBy(Long.valueOf(ctx.pathParam("codigo"))));					
                });

                post(ctx -> {
                    try {
                        jugRepository.save(ctx.bodyAsClass(JUG.class));
                        ctx.json(new ResponseModel(1, "JUG adicionada com sucesso!"));
                    } catch (Exception e) {
                        ctx.json(new ResponseModel(0, e.getMessage()));
                    }
                });

                put(ctx -> {
                    try {
                        jugRepository.save(ctx.bodyAsClass(JUG.class));
                        ctx.json(new ResponseModel(1, "JUG atualizada com sucesso!"));
                    } catch(Exception ex) {
                        ctx.json(new ResponseModel(0, ex.getMessage()));
                    }
                });

                delete(":codigo", ctx -> {
                    try {
                        jugRepository.remove(jugRepository.findBy(Long.valueOf(ctx.pathParam("codigo"))));

                        if (ctx.status() == 200) {
                            ctx.json(new ResponseModel(1, "JUG excluida com Sucesso!"));
                        }

                    } catch (Exception e) {
                        ctx.json(new ResponseModel(0, e.getMessage()));
                    }
                });
            });
        });
    }

    protected static void Jsonbind() {
        Jsonb jsonb = JsonbBuilder.create();

        JavalinJson.setFromJsonMapper(jsonb::fromJson);
        JavalinJson.setToJsonMapper(jsonb::toJson);
    }
}
