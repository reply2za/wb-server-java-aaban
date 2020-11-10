package com.example.cs4550f20serverjavaaaban.services;

import com.example.cs4550f20serverjavaaaban.models.Widget;
import com.example.cs4550f20serverjavaaaban.repositories.WidgetRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {
  @Autowired
  WidgetRepository widgetRepository;

  List<Widget> widgets = new ArrayList<Widget>();
  {
    widgets.add(new Widget(123, "HTML", "Widget 1", "topic123"));
    widgets.add(new Widget(234, "YOU_TUBE", "Widget 2", "topic123"));
    widgets.add(new Widget(345, "SLIDE", "Widget 3", "topic123"));
    widgets.add(new Widget(456, "HEADER", "Widget 4", "topic123"));
    widgets.add(new Widget(567, "HEADING", "Widget A", "5fa1c3650df073001729c70e"));
    widgets.add(new Widget(678, "PARAGRAPH", "Widget B", "5fa1c3650df073001729c70e"));
  }

  int idi = 0;

  public List<Widget> findAllWidgetsForTopic(String tid) {
    return widgetRepository.findWidgetsByTopicId(tid);
//    List<Widget> widgets = new ArrayList<Widget>();
//    for(Widget w: this.widgets) {
//      if (w.getTopicId().equals(tid)) {
//        widgets.add(w);
//      }
//    }
//    return widgets;
  }

  public List<Widget> findWidgetForTopic(String tid, Integer wid) {
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
    return (List<Widget>) widgetRepository.findAll();
    //    return widgets;
  }

  public Widget findWidgetsById(Integer widgetId) {
    return widgetRepository.findById(widgetId).get();
//    for (Widget w : widgets) {
//      if(w.getId().equals(widgetId)) {
//        return w;
//      }
//    }
//    return null;
  }

  public Widget createWidget(Widget widget) {
    // topic id is set in controller
    return widgetRepository.save(widget);
//    Integer newId = 321;
//    idi++;
//    widget.setId(newId);
//    widgets.add(widget);
//    return widget;
  }

//  Widget dw;
  public Widget deleteWidget(Integer widgetId) {
    Widget w = widgetRepository.findById(widgetId).get();
    widgetRepository.deleteById(widgetId);
    return w;
//    int i = 0;
//    for (Widget w : widgets) {
//      if (w.getId().equals(widgetId)) {
//        dw = w;
//        widgets.remove(i);
//        System.out.println("Deleted: " + dw.getId() + " - " + dw.getName());
//        return dw;
//      }
//      i++;
//    }
//    return null;
  }

  public Widget updateWidget(Integer widgetId, Widget newWidget) {
    Widget widget = widgetRepository.findById(widgetId).get();
    // make the changes that we want
    //widget.setName(newWidget.getName());
    // put the changed widget into the database
    return widgetRepository.save(newWidget);
//    int i = 0;
//    for (Widget w : widgets) {
//      if (w.getId().equals(widgetId)) {
//        widgets.set(i,newWidget);
//        return newWidget;
//      }
//      i++;
//    }
//    return null;
  }
}
