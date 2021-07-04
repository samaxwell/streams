package com.sean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Message {

    private Integer id;
    private String content;
    private Boolean isReady; // accepts: [0,1,true,false,"true","false"]
    private List<String> recipients;
    private Double priority;

    public void printMessage() {
        System.out.println(
                "MESSAGE-ID: \t" + this.id + "\n" +
                "MESSAGE-BODY: \t" + this.content + "\n" +
                "MESSAGE-ISREADY: \t" + this.isReady + "\n" +
                "MESSAGE-RECIPIENTS: \t" + this.recipients + "\n" +
                "MESSAGE-PRIORITY: \t" + this.priority +
                "\n"
        );
    }
}

/*
Kafka Message:
    {
      "id": 1,
      "content" : "Here is a message",
      "isReady": true,
      "recipients": [
         "sam",
         "man"
      ],
      "priority": 1.0123456789
    }
*/

