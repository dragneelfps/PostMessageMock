package com.example.sourabh.postmessagemock;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sourabh.postmessagemock.models.Message;
import com.example.sourabh.postmessagemock.mvcviews.MainScreenView;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainScreenViewImp implements MainScreenView {

    private View mRootView;
    @BindView(R.id.messages_list) RecyclerView mMessageListView;
    @BindView(R.id.message) EditText mMessageText;
    @BindView(R.id.post_btn) Button mPostButton;

    private MessageListAdapter mAdapter;
    private PostMessageListener mPostMessageListener;


    public MainScreenViewImp(LayoutInflater inflater, final Context context){
        mRootView = inflater.inflate(R.layout.main_layout, null, false);
        ButterKnife.bind(this, mRootView);
        mMessageListView.setLayoutManager(new LinearLayoutManager(context));
        ArrayList<Message> dummyList = new ArrayList<>();
        dummyList.add(new Message("This is confidential", new Date()));
        mAdapter = new MessageListAdapter(dummyList, this);

        mMessageListView.setAdapter(mAdapter);

        mPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postMessage(mMessageText.getText().toString());
            }
        });
    }

    @Override
    public void postMessage(String msg) {
        Log.d("debug",msg);
        Message newMessage = new Message(msg, new Date());
        mAdapter.updateMessageList(newMessage);
        mMessageText.setText("");
        mMessageText.clearFocus();
        if(mPostMessageListener != null){
            mPostMessageListener.onPostMessage(msg);
        }
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public int getMessageListViewItemLayout() {
        return R.layout.message_item;
    }

    @Override
    public void setPostMessageListener(PostMessageListener listener) {
        mPostMessageListener = listener;
    }
}
