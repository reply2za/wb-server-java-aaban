package com.example.cs4550f20serverjavaaaban.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "widgets")
public class Widget {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String type; // the type of widget
  private String name;
  //private Integer widgetOrder;
  private String src;
  private String html;
  private String className;
  private Integer height;
  private Integer width;
  private String topicId;
  private String text;
  private String headingText;
  //private String style;

  public Widget(Integer id, String type, String name, String topicId) {
    this.name = name;
    this.id = id;
    this.type = type;
    this.topicId = topicId;
  }


  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }


  public Widget(Integer id, String type, String name) {
    this.id = id;
    this.type = type;
    this.name = name;
  }

  public Widget() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getHeadingText() {
    return headingText;
  }

  public void setHeadingText(String headingText) {
    this.headingText = headingText;
  }


  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getHtml() {
    return html;
  }

  public void setHtml(String html) {
    this.html = html;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

}
