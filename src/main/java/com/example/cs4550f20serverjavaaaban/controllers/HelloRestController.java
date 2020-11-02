package com.example.cs4550f20serverjavaaaban.controllers;


import com.example.cs4550f20serverjavaaaban.models.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

  @GetMapping("/message")
  public Message getMessage() {
    Message m = new Message();
    m.setMessage("Life is Good!!!");
    return m;
  }

  @GetMapping("/hello") // if you see the string "/hello" then execute
public String sayHello() {
  return "Hello World";
}


}
