package com.example.cs4550f20serverjavaaaban.repositories;

import com.example.cs4550f20serverjavaaaban.models.Widget;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {

  @Query(value = "SELECT * FROM widgets where topic_id=:tid", nativeQuery = true)
  public List<Widget> findWidgetsByTopicId(@Param("tid") String topicId);

}

