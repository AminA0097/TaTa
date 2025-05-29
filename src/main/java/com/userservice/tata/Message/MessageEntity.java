package com.userservice.tata.Message;

import com.userservice.tata.Annotation.EntityField;
import com.userservice.tata.Annotation.IsBoolean;
import com.userservice.tata.Bases.BaseEntity;
import com.userservice.tata.Doc.DocEntity;
import com.userservice.tata.User.UserEntity;
import com.userservice.tata.Util.convertToDatabaseColumn;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MESSEGAETABLE")
public class MessageEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MESSAGE_ID")
    private long messageId;

    @Column(name = "MESSAGE_TITLE",length = 1000)
    private String messageTitle;

    @ManyToOne
    @JoinColumn(name = "MESSAGE_SENDER")
    @EntityField()
    private UserEntity sender;

    @ManyToMany
    @JoinTable(
            name = "MESSAGE_RECEVIER_M2m",
            joinColumns = @JoinColumn(name = "MESSAGE_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID")
    )
    @EntityField()
    private List<UserEntity> receiver;

    @Column(name = "MESSAGE_IS_SEEN")
    @IsBoolean()
    @Convert(converter = convertToDatabaseColumn.class)
    private boolean isSeen;

    @Column(name = "MESSAGE_IS_SENT")
    @IsBoolean()
    @Convert(converter = convertToDatabaseColumn.class)
    private boolean isSent;

    @ManyToOne
    @JoinColumn(name = "DOC_Id")
    @EntityField()
    private DocEntity docEntity;

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public UserEntity getSender() {
        return sender;
    }

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

    public List<UserEntity> getReceiver() {
        return receiver;
    }

    public void setReceiver(List<UserEntity> receiver) {
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

    public DocEntity getDocEntity() {
        return docEntity;
    }

    public void setDocEntity(DocEntity docEntity) {
        this.docEntity = docEntity;
    }
}

