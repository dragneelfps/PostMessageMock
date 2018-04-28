package com.example.sourabh.postmessagemock.mvcviews;

import com.example.sourabh.postmessagemock.mvcviews.RootView;

public interface MainScreenView extends RootView {
    void postMessage(String msg);
    int getMessageListViewItemLayout();

    void setPostMessageListener(PostMessageListener listener);

    interface PostMessageListener{
        void onPostMessage(String msg);
    }

}
