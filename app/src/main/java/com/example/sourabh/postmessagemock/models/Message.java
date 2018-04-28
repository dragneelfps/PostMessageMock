package com.example.sourabh.postmessagemock.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private String mMessageText;
    private String mTimeText;

    public Message(String messageText, Date time){
        mMessageText = messageText;

        SimpleDateFormat sdfr = new SimpleDateFormat("HH:mm a");
        mTimeText = sdfr.format(time);
    }

    public String getMessageText() {
        return mMessageText;
    }

    public String getTimeText() {
        return mTimeText;
    }
}
