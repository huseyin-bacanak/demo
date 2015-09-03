package demo.pong.controller;

import demo.pong.domain.Message;
import demo.pong.domain.MessageAcknowledgement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PongController {

  //@Value("${reply.message}")
  private String message="default message";

  @RequestMapping(value = "/message", method = RequestMethod.POST)
  public Resource<MessageAcknowledgement> pongMessage(@RequestBody Message input) {
    return new Resource<>(
            new MessageAcknowledgement(input.getId(), input.getPayload(), message));
  }



}
