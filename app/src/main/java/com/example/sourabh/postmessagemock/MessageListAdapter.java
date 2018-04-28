package com.example.sourabh.postmessagemock;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sourabh.postmessagemock.models.Message;
import com.example.sourabh.postmessagemock.mvcviews.MainScreenView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.VH> {
    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.message_text)
        TextView messageTextView;

        @BindView(R.id.posted_time)
        TextView postedTimeView;

        VH(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    private ArrayList<Message> mMessagesList;
    private MainScreenView mContainerView;

    MessageListAdapter(ArrayList<Message> messagesList, MainScreenView containerView){
        mMessagesList = messagesList;
        mContainerView = containerView;
    }

    void updateMessageList(Message newMessage){
        mMessagesList.add(newMessage);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(mContainerView.getMessageListViewItemLayout(), parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.messageTextView.setText(mMessagesList.get(position).getMessageText());
        holder.postedTimeView.setText(mMessagesList.get(position).getTimeText());
    }

    @Override
    public int getItemCount() {
        return mMessagesList.size();
    }
}
