package com.innopolis.zelenyichai.smartbar.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.innopolis.zelenyichai.smartbar.BaseMessage;
import com.innopolis.zelenyichai.smartbar.R;

import java.util.ArrayList;

public class DrinksFragment extends Fragment implements View.OnClickListener{

    private CardView cardView;
    ArrayList<BaseMessage> messageList = new ArrayList<>();
    int counter = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drinks_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        cardView = view.findViewById(R.id.rocket_card);
        cardView.setOnClickListener(this);
    }

    public void setMessageList(ArrayList<BaseMessage> messageList) {
        this.messageList  = messageList;
    }

    @Override
    public void onClick(View v) {
        ChatFragment chatFragment = (ChatFragment) getActivity().getFragmentManager().findFragmentById(R.id.fragment_bar_chat);
        BaseMessage baseMessage1 = new BaseMessage();
        BaseMessage baseMessage2 = new BaseMessage();
        BaseMessage baseMessage3 = new BaseMessage();
        baseMessage1.setSender("you");
        baseMessage1.setMessage("Жахнем твой коктейль!");
        chatFragment.addMessage(baseMessage1);
        if(counter < 2){
            baseMessage2.setSender("Илон Маск");
            baseMessage2.setMessage("Отличный выбор!");
            baseMessage2.setGetImageId(R.mipmap.elon_round);
            chatFragment.addMessage(baseMessage2);
            baseMessage3.setMessage("Полёт нормальный!");
            baseMessage3.setGetImageId(R.mipmap.elon_round);
            baseMessage3.setSender("Илон Маск");
            chatFragment.addMessage(baseMessage3);
            counter++;
        } else {
            baseMessage2.setSender("Илон Маск");
            baseMessage2.setMessage("Неплохой выбор.");
            baseMessage2.setGetImageId(R.mipmap.elon_round);
            chatFragment.addMessage(baseMessage2);
            baseMessage3.setMessage("Но, думаю, твой топливный бак на сегодня заполнен. Еще стаканчик и ты рискуешь увидеть марсиан ;)");
            baseMessage3.setSender("Илон Маск");
            baseMessage3.setGetImageId(R.mipmap.elon_round);
            chatFragment.addMessage(baseMessage3);
        }
    }
}
