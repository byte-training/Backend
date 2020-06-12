package com.bytesw.demo.bs.controller;

import com.bytesw.demo.bs.eis.bo.User;
import com.bytesw.demo.bs.eis.bto.GreetingsResponseText;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bytesw.demo.bs.eis.bto.GreetingsResponse;
import com.bytesw.demo.bs.service.GreetingsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/byte-crud", produces = MediaType.APPLICATION_JSON_VALUE)

public class AccountController {
    @Bean
    public WebMvcConfigurer CORSConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

            }

            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

            }

            @Override
            public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

            }

            @Override
            public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

            }

            @Override
            public void addFormatters(FormatterRegistry formatterRegistry) {

            }

            @Override
            public void addInterceptors(InterceptorRegistry interceptorRegistry) {

            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedHeaders("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
                        .maxAge(-1)   // add maxAge
                        .allowCredentials(false);
            }

            @Override
            public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {

            }

            @Override
            public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

            }

            @Override
            public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

            }

            @Override
            public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

            }

            @Override
            public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

            }

            @Override
            public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

            }

            @Override
            public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

            }

            @Override
            public Validator getValidator() {
                return null;
            }

            @Override
            public MessageCodesResolver getMessageCodesResolver() {
                return null;
            }
        };
    }
    private final GreetingsService greetingsService;

    public AccountController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    public int entityNumber = 0;

    @GetMapping
    public ResponseEntity<ArrayList> getUser(){
        ArrayList user = greetingsService.getUser();
        ResponseEntity<ArrayList> result = new ResponseEntity<ArrayList>(user, HttpStatus.OK);
        return result;
    }

    @GetMapping("/buscar")
    public ResponseEntity<GreetingsResponse> getUserById(@RequestParam("id") int id) {
        User user = greetingsService.getUserById(id);
        GreetingsResponse response = new GreetingsResponse();
        response.setIdentification(user.getIdentification());
        response.setName(user.getName());
        response.setLastname(user.getLastname());
        response.setBirthdate(user.getBirthdate());
        ResponseEntity<GreetingsResponse> result = new ResponseEntity<GreetingsResponse>(response, HttpStatus.OK);
        return result;
    }

    @PostMapping("/crear")
    public @ResponseBody ResponseEntity<GreetingsResponseText> createUser(@RequestBody User user) {
        this.entityNumber += 1;
        greetingsService.createUser(this.entityNumber,user.getIdentification(), user.getName(), user.getLastname(),user.getBirthdate());
        GreetingsResponseText response = new GreetingsResponseText();
        response.setResponse("Created");
        response.setMessage("Usuario creado correctamente");
        ResponseEntity<GreetingsResponseText> result = new ResponseEntity<GreetingsResponseText>(response, HttpStatus.OK);
        return result;
    }

    @PutMapping("/update")
    public @ResponseBody ResponseEntity<GreetingsResponseText> updateUser(@RequestBody User user) {
        greetingsService.updateUser(user.getId(),user.getIdentification(), user.getName(), user.getLastname(),user.getBirthdate());
        GreetingsResponseText response = new GreetingsResponseText();
        response.setResponse("Updated");
        response.setMessage("Usuario actualizado correctamente");
        ResponseEntity<GreetingsResponseText> result = new ResponseEntity<GreetingsResponseText>(response, HttpStatus.OK);
        return result;
    }


    @DeleteMapping("/delete")
    public @ResponseBody ResponseEntity<GreetingsResponseText> deleteUser(@RequestParam("id") int id){
        greetingsService.deleteUser(id);
        GreetingsResponseText response = new GreetingsResponseText();
        response.setResponse("Deleted");
        response.setMessage("Usuario eleminado correctamente");
        ResponseEntity<GreetingsResponseText> result = new ResponseEntity<GreetingsResponseText>(response, HttpStatus.OK);
        return result;
    }


}
