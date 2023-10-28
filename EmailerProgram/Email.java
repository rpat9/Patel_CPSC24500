package EmailerProgram;

import java.util.ArrayList;

/**
 * a class that represents an individual email communication. An email has a
 * list of recipients, a subject, a body, and a status that indicates whether it
 * has been sent.
 */

public class Email {

  private String recepient1;
  private String recepient2;
  private String subject;
  private String body;
  private ArrayList<String> email = new ArrayList<String>();
  private boolean status = false;

  public Email() {

  }

  public Email(String recepient1, String recepient2, String subject, String body) {
    this.recepient1 = recepient1;
    this.recepient2 = recepient2;
    this.subject = subject;
    this.body = body;
  }

  public void doEmail() {

  }

  public String getRecepient1() {
    return recepient1;
  }

  public String getRecepient2() {
    return recepient2;
  }

  public String getSubject() {
    return subject;
  }

  public String getBody() {
    return body;
  }

  public boolean getStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public void setRecepient1(String recepient1) {
    this.recepient1 = recepient1;
  }

  public void setRecepient2(String recepient2) {
    this.recepient2 = recepient2;
  }

}