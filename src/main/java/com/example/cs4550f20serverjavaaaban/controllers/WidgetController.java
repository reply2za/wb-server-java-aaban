package com.example.cs4550f20serverjavaaaban.controllers;

import com.example.cs4550f20serverjavaaaban.models.Widget;
import com.example.cs4550f20serverjavaaaban.services.WidgetService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
  WidgetService service = new WidgetService();

  @GetMapping("/api/topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic(@PathVariable("tid") String topicId) {
    return service.findWidgetsForTopics(topicId);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  @GetMapping("/api/widgets/{wid}")
  public Widget findWidgetsById(@PathVariable("wid") String widgetId) {
  return service.findWidgetsById(widgetId);
  }

  @PostMapping("/api/widgets")
  public Widget createWidget(@RequestBody Widget widget) {
    return service.createWidget(widget);
  }

  @PostMapping("/api/topics/{tid}/widgets")
  public Widget createWidgetForTopic(@PathVariable("tid") String topicId,@RequestBody Widget widget) {
    widget.setTopicId(topicId);
    return service.createWidget(topicId, widget);
  }

  @PutMapping("/api/topics/{tid}/widgets")
  public Widget createWidgetForTopicPut(@PathVariable("tid") String topicId,@RequestBody Widget widget) {
    widget.setTopicId(topicId);
    return service.createWidget(topicId, widget);
  }

  @DeleteMapping("/api/widgets/{wid}")
  public Integer deleteWidget(String widgetId) {
    return null;
  }

  @PutMapping("/api/widgets/{wid}")
  public Integer updateWidget(String widgetId, Widget newWidget) {
    return null;
  }
  // TODO: deleteWidget(), updateWidget()
}
