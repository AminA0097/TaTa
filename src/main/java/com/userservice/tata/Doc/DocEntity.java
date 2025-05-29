package com.userservice.tata.Doc;

import com.userservice.tata.Annotation.EntityField;
import com.userservice.tata.Bases.BaseEntity;
import com.userservice.tata.User.UserEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "DOCTABLE")
public class DocEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DOC_ID")
    private long docId;

    @Column(name = "DOC_NAME")
    private String docTitle;

    @Column(name = "DOC_ROOT")
    private String docRoot;

    @Column(name = "DOC_TYPE")
    private String docType;

    @Lob
    @Column(name = "DOC_CONTENT")
    byte[] messageContent;

    @ManyToOne
    @JoinColumn(name = "OWNER_USER_Id")
    @EntityField()
    private UserEntity ownerUserId;

    public long getDocId() {
        return docId;
    }

    public void setDocId(long docId) {
        this.docId = docId;
    }

    public String getDocTitle() {
        return docTitle;
    }

    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    }

    public String getDocRoot() {
        return docRoot;
    }

    public void setDocRoot(String docRoot) {
        this.docRoot = docRoot;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public byte[] getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(byte[] messageContent) {
        this.messageContent = messageContent;
    }

    public UserEntity getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(UserEntity ownerUserId) {
        this.ownerUserId = ownerUserId;
    }
}
