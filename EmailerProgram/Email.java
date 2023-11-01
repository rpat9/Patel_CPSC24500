package EmailerProgram;

/**
 * This Email program contains the basics elements/attributes of Email and will
 * be used by other classes to create objects of Email.
 */

public class Email {

  private String recipient1;
  private String recipient2;
  private String subject;
  private String body;
  private String status;

  /**
   * This is the default constructor which sets everything to default values.
   */
  public Email() {
    recipient1 = "";
    recipient2 = "";
    subject = "";
    body = "";
    status = "not sent";
  }

  /**
   * This constructor sets everything the way the user wants it.
   * 
   * @param rep1 This is the first recipient.
   * @param rep2 This is the second recipient.
   * @param sub  This is the subject of the email.
   * @param bod  This is the body of the email.
   */
  public Email(String rep1, String rep2, String sub, String bod) {
    recipient1 = rep1;
    recipient2 = rep2;
    subject = sub;
    body = bod;
    status = "not sent";
  }

  /**
   * This method changes the first recipient.
   * 
   * @param rep1 This is the new first recipient.
   */
  public void setRecipient1(String rep1) {
    recipient1 = rep1;
  }

  /**
   * This method changes the second recipient.
   * 
   * @param rep2 This is the new second recipient.
   */
  public void setRecipient2(String rep2) {
    recipient2 = rep2;
  }

  /**
   * This method changes the body.
   * 
   * @param bod This is the new body.
   */
  public void setBody(String bod) {
    body = bod;
  }

  /**
   * This method changes the subject.
   * 
   * @param sub This is the new subject.
   */
  public void setSubject(String sub) {
    subject = sub;
  }

  /**
   * This method changes the status.
   * 
   * @param sta This is the new status.
   */
  public void setStatus(String sta) {
    status = sta;
  }

  /**
   * This method updates the status to "sent" when user chooses to send the
   * emails.
   */
  public void send() {
    setStatus("sent");
  }

  /**
   * This method provides access to the first recipient varaible.
   * 
   * @return The first recipient is returned.
   */
  public String getRecipient1() {
    return recipient1;
  }

  /**
   * This method provides access to the second recipient variable.
   * 
   * @return The second recipient is returned.
   */
  public String getRecipient2() {
    return recipient2;
  }

  /**
   * This method proivdes access to the subject.
   * 
   * @return The subject is returned.
   */
  public String getSubject() {
    return subject;
  }

  /**
   * This method provides access to the body.
   * 
   * @return The body is returned.
   */
  public String getBody() {
    return body;
  }

  /**
   * This method provides access to the status.
   * 
   * @return The status is returned.
   */
  public String getStatus() {
    return status;
  }

  /**
   * This method provides a string representation of the email with every element.
   */
  @Override
  public String toString() {
    return recipient1 + "," + recipient2 + "\t" + subject + "\t" + body + "\t" + status;
  }
}