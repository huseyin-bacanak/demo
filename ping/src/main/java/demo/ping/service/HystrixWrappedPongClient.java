package demo.ping.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import demo.ping.domain.Message;
import demo.ping.domain.MessageAcknowledgement;
import demo.ping.feign.PongClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("hystrixPongClient")
public class HystrixWrappedPongClient implements PongClient{
  @Autowired
  @Qualifier("pongClient")
  private PongClient feignPongClient;

  @Override
  @HystrixCommand(fallbackMethod="fallBackCall")
  public MessageAcknowledgement sendMessage(Message message) {
    return this.feignPongClient.sendMessage(message);
  }

  public MessageAcknowledgement fallBackCall(Message message) {
    MessageAcknowledgement fallback = new MessageAcknowledgement(message.getId(), message.getPayload(), "FAILED SERVICE CALL! - FALLING BACK");
    return fallback;
  }
}
