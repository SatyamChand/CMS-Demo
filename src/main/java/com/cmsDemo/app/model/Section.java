package com.cmsDemo.app.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Section
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-20T11:36:07.743+05:30")


public class Section   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("head")
  private Long head = null;

  @JsonProperty("subjects")
  @Valid
  private List<Object> subjects = null;

  public Section id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Section head(Long head) {
    this.head = head;
    return this;
  }

  /**
   * Get head
   * @return head
  **/
  @ApiModelProperty(value = "")


  public Long getHead() {
    return head;
  }

  public void setHead(Long head) {
    this.head = head;
  }

  public Section subjects(List<Object> subjects) {
    this.subjects = subjects;
    return this;
  }

  public Section addSubjectsItem(Object subjectsItem) {
    if (this.subjects == null) {
      this.subjects = new ArrayList<Object>();
    }
    this.subjects.add(subjectsItem);
    return this;
  }

  /**
   * Get subjects
   * @return subjects
  **/
  @ApiModelProperty(value = "")


  public List<Object> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<Object> subjects) {
    this.subjects = subjects;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Section section = (Section) o;
    return Objects.equals(this.id, section.id) &&
        Objects.equals(this.head, section.head) &&
        Objects.equals(this.subjects, section.subjects);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, head, subjects);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Section {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    head: ").append(toIndentedString(head)).append("\n");
    sb.append("    subjects: ").append(toIndentedString(subjects)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

