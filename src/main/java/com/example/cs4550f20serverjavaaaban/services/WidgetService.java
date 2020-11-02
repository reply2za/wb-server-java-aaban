package com.example.cs4550f20serverjavaaaban.services;

import com.example.cs4550f20serverjavaaaban.models.Widget;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WidgetService {
  List<Widget> widgets = new ArrayList<Widget>();

  {
    widgets.add(new Widget("123", "HTML", "Widget 1", "topic123"));
    widgets.add(new Widget("234", "YOU_TUBE", "Widget 2", "topic123"));
    widgets.add(new Widget("345", "SLIDE", "Widget 3", "topic123"));
    widgets.add(new Widget("456", "HEADER", "Widget 4", "topic123"));
    widgets.add(new Widget("567", "HEADING", "Widget A", "5fa03fc68af83100175c1885"));
    widgets.add(new Widget("678", "PARAGRAPH", "Widget B", "5fa03fc68af83100175c1885"));
  }

  public List<Widget> findWidgetsForTopics(String tid) {
    List<Widget> widgets = new ArrayList<Widget>();
    for(Widget w: this.widgets) {
      if (w.getTopicId().equals(tid)) {
        widgets.add(w);
      }
    }
    return widgets;
  }


  public List<Widget> findAllWidgets() {
    return widgets;
  }

  public Widget findWidgetsById(String widgetId) {
    for (Widget w : widgets) {
      if(w.getId().equals(widgetId)) {
        return w;
      }
    }
    return null;
  }

  public Widget createWidget(Widget widget) {
    String newId = new Date().toString();
    widget.setId(newId);
    widgets.add(widget);
    return widget;
  }
  public Widget createWidget(String tid, Widget widget) {
    String newId = new Date().toString();
    widget.setId(newId);
    widget.setTopicId(tid);
    widgets.add(widget);
    return widget;
  }

  public Integer deleteWidget(String widgetId) {
    return null;
  }

  public Integer updateWidget(String widgetId, Widget newWidget) {
    return null;
  }
  // TODO: deleteWidget(), updateWidget()
}
