package com.innopolis.zelenyichai.smartbar.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.innopolis.zelenyichai.smartbar.BaseMessage;
import com.innopolis.zelenyichai.smartbar.MessageListAdapter;
import com.innopolis.zelenyichai.smartbar.R;

import java.util.ArrayList;

public class ChatFragment extends Fragment {

    private RecyclerView mMessageRecycler;
    private static MessageListAdapter mMessageAdapter;
    ArrayList<BaseMessage> messageList = new ArrayList<>();
    private int imageId;
    private String assistantName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_layout, container, false);
        mMessageRecycler = (RecyclerView) view.findViewById(R.id.reyclerview_message_list);
        mMessageAdapter = new MessageListAdapter(getActivity(), messageList);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMessageRecycler.setAdapter(mMessageAdapter);
        return view;
    }

    public void addMessage(Bundle args, String message){
        imageId = args.getInt("id");
        assistantName = args.getString("name");
        BaseMessage baseMessage = new BaseMessage();
        baseMessage.setSender(assistantName);
        baseMessage.setGetImageId(imageId);
        baseMessage.setMessage(message);
        messageList.add(baseMessage);
        mMessageAdapter.notifyDataSetChanged();
    }

    public ArrayList<BaseMessage> getMessageList() {
        return messageList;
    }
}
