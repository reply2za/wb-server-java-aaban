package com.example.cs4550f20serverjavaaaban.services;

import com.example.cs4550f20serverjavaaaban.models.Widget;
import java.util.ArrayList;
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
  int idi = 0;

  public List<Widget> findAllWidgetsForTopic(String tid) {
    List<Widget> widgets = new ArrayList<Widget>();
    for(Widget w: this.widgets) {
      if (w.getTopicId().equals(tid)) {
        widgets.add(w);
      }
    }
    return widgets;
  }
  public List<Widget> findWidgetForTopic(String tid, String wid) {
    List<Widget> widgets = new ArrayList<Widget>();
    for(Widget w: this.widgets) {
      if (w.getTopicId().equals(tid)) {
        if (w.getId().equals(wid)) {
          widgets.add(w);
        }
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
    String newId = String.valueOf(idi);
    idi++;
    widget.setId(newId);
    widgets.add(widget);
    return widget;
  }
  public Widget createWidget(String tid, Widget widget) {
    String newId = String.valueOf(idi);
    idi++;
    System.out.println("newId:" + newId);
    widget.setId(newId);
    widget.setTopicId(tid);
    widgets.add(widget);
    return widget;
  }

  Widget dw;
  public Widget deleteWidget(String widgetId) {
    int i = 0;
    for (Widget w : widgets) {
      if (w.getId().equals(widgetId)) {
        dw = w;
        widgets.remove(i);
        System.out.println("Deleted: " + dw.getId() + " - " + dw.getName());
        return dw;
      }
      i++;
    }
    return null;
  }

  public Widget updateWidget(String widgetId, Widget newWidget) {
    int i = 0;
    for (Widget w : widgets) {
      if (w.getId().equals(widgetId)) {
        widgets.set(i,newWidget);
        return newWidget;
      }
      i++;
    }
    return null;
  }
  // TODO: deleteWidget(), updateWidget()
}
