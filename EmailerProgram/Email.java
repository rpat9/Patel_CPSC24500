package EmailerProgram;

/**
 * This Email program contains the basics elements/attributes of Email and will
 * be used by other classes to create objects of Email.
 */

// FOR ME:
/*
 * The class specifies storage for a list of recipients, a subject, a body, and
 * a send status. It has getters and setters, a default
 * and a non default constructor, a toString function that enables us to easily
 * present the details of an email to the screen, and another String returning
 * function th at allows us to easily write a one line tab delimited summary of
 * each email. The Email class must also have a send() function that sets the
 * send status to true instead of false.
 */

public class Email {

  private String recipient1;
  private String recipient2;
  private String subject;
  private String body;
  private String status;

  public Email() {
    recipient1 = "";
    recipient2 = "";
    subject = "";
    body = "";
    status = "not sent";
  }

  public Email(String rep1, String rep2, String sub, String bod) {
    recipient1 = rep1;
    recipient2 = rep2;
    subject = sub;
    body = bod;
    status = "not sent";
  }

  public void setRecipient1(String rep1) {
    recipient1 = rep1;
  }

  public void setRecipient2(String rep2) {
    recipient2 = rep2;
  }

  public void setBody(String bod) {
    body = bod;
  }

  public void setSubject(String sub) {
    subject = sub;
  }

  public void setStatus(String sta) {
    status = sta;
  }

  public void send() {
    setStatus("sent");
  }

  public String getRecipient1() {
    return recipient1;
  }

  public String getRecipient2() {
    return recipient2;
  }

  public String getSubject() {
    return subject;
  }

  public String getBody() {
    return body;
  }

  public String getStatus() {
    return status;
  }

  @Override
  public String toString() {
    return recipient1 + "," + recipient2 + "\t" + subject + "\t" + body + "\t" + status;
  }

}