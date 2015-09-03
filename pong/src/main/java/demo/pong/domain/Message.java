package demo.pong.domain;

/**
 * Created by huseyin.bacanak on 02.09.2015.
 */
public class Message {
  private String id;
  private String payload;

  public Message() {

  }

  public Message(String id, String payload) {
    this.id = id;
    this.payload = payload;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }
}
