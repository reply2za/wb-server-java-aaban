package com.example.cs4550f20serverjavaaaban.controllers;

import com.example.cs4550f20serverjavaaaban.models.Widget;
import com.example.cs4550f20serverjavaaaban.services.WidgetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

  @Autowired
  WidgetService service;

  @GetMapping("/api/topics/{tid}/widgets")
  public List<Widget> findAllWidgetsForTopic(@PathVariable("tid") String topicId) {
    System.out.println("Topic id: " + topicId);
    return service.findAllWidgetsForTopic(topicId);
  }

  @GetMapping("/api/topics/{tid}/widgets/{wid}")
  public List<Widget> findWidgetForTopic(@PathVariable("tid") String topicId, @PathVariable("wid") Integer widgetId) {
    return service.findWidgetForTopic(topicId, widgetId);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  @GetMapping("/api/widgets/{wid}")
  public Widget findWidgetsById(@PathVariable("wid") Integer widgetId) {
  return service.findWidgetsById(widgetId);
  }

  @PostMapping("/api/widgets")
  public Widget createWidget(@RequestBody Widget widget) {
    return service.createWidget(widget);
  }

  @PostMapping("/api/topics/{tid}/widgets")
  public Widget createWidgetForTopic(@PathVariable("tid") String topicId,@RequestBody Widget widget) {
    if (topicId.equalsIgnoreCase("undefined")) {
      System.out.println("No topic id");
      return new Widget();
    }
    widget.setTopicId(topicId);
    return service.createWidget(widget);
  }

  @PutMapping("/api/topics/{tid}/widgets")
  public Widget createWidgetForTopicPut(@PathVariable("tid") String topicId,@RequestBody Widget widget) {
    widget.setTopicId(topicId);
    return service.createWidget(widget);
  }

  @DeleteMapping("/api/topics/{tid}/widgets/{wid}")
  public Widget deleteWidget(@PathVariable("wid") Integer widgetId) {
    return service.deleteWidget(widgetId);
  }

  // testing
//  @DeleteMapping("/api/widgets/{wid}")
//  public void deleteWidget(@PathVariable("wid") Integer widgetId) {
//    service.deleteWidget(widgetId);
//  }

  @PutMapping("/api/topics/{tid}/widgets/{wid}")
  public Widget updateWidget(@PathVariable("wid") Integer widgetId, @RequestBody Widget newWidget) {
    return service.updateWidget(widgetId, newWidget);
    //return service.updateWidget(widgetId, newWidget);
  }

//  //testing
//  @PutMapping("/api/widgets/{wid}")
//  public Widget updateWidget(@PathVariable("wid") Integer widgetId, @RequestBody Widget newWidget) {
//    return service.updateWidget(widgetId, newWidget);
//    //return service.updateWidget(widgetId, newWidget);
//  }

}
