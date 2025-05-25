package com.userservice.tata.Message;

import com.userservice.tata.Annotation.IsBoolean;
import com.userservice.tata.Bases.BaseEntity;
import com.userservice.tata.Util.convertToDatabaseColumn;
import jakarta.persistence.*;

@Entity
@Table(name = "MESSEGAETABLE")
public class MessageEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MESSAGE_ID")
    private long messageId;
    @Column(name = "MESSAGE_CONTENT",length = 1000)
    private String messageContent;
    @Column(name = "MESSAGE_SENDER")
    private String sender;
    @Column(name = "MESSAGE_RECIVER")
    private String receiver;
    @Convert(converter = convertToDatabaseColumn.class)
    @Column(name = "MESSAGE_IS_SEEN")
    @IsBoolean()
    private boolean isSeen;
    @Convert(converter = convertToDatabaseColumn.class)
    @Column(name = "MESSAGE_IS_SENT")
    @IsBoolean()
    private boolean isSent;

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen) {
        isSeen = seen;
    }

    public boolean isSent() {
        return isSent;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }
}

