package com.cmsDemo.app.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SubjectTeacher
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-20T11:36:07.743+05:30")


public class SubjectTeacher   {
  @JsonProperty("subject")
  private String subject = null;

  @JsonProperty("teacher")
  private Long teacher = null;

  public SubjectTeacher subject(String subject) {
    this.subject = subject;
    return this;
  }

  /**
   * Get subject
   * @return subject
  **/
  @ApiModelProperty(value = "")


  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public SubjectTeacher teacher(Long teacher) {
    this.teacher = teacher;
    return this;
  }

  /**
   * Get teacher
   * @return teacher
  **/
  @ApiModelProperty(value = "")


  public Long getTeacher() {
    return teacher;
  }

  public void setTeacher(Long teacher) {
    this.teacher = teacher;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubjectTeacher subjectTeacher = (SubjectTeacher) o;
    return Objects.equals(this.subject, subjectTeacher.subject) &&
        Objects.equals(this.teacher, subjectTeacher.teacher);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subject, teacher);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubjectTeacher {\n");
    
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    teacher: ").append(toIndentedString(teacher)).append("\n");
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

