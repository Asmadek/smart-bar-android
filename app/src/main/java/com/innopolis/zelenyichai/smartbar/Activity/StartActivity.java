package com.innopolis.zelenyichai.smartbar.Activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.innopolis.zelenyichai.smartbar.Fragment.AssistentFragment;
import com.innopolis.zelenyichai.smartbar.R;

public class StartActivity extends Activity {

    private FragmentManager fragmentManager;
    private AssistentFragment assistentFragment;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bundle = new Bundle();
        fragmentManager = getFragmentManager();
        init();

    }

    private Bundle composeBundle(String name, int imageId, String description){
        bundle.putString("name", name);
        bundle.putInt("imageId", imageId);
        bundle.putString("description", description);
        return bundle;
    }

    private void init(){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        assistentFragment = new AssistentFragment();
        assistentFragment.setArguments(composeBundle("Илон Маск", R.mipmap.elon_round, "Космическое пойло"));
        fragmentTransaction.add(R.id.fragment_assistant1, assistentFragment);
        fragmentTransaction.commit();

        fragmentTransaction = fragmentManager.beginTransaction();
        assistentFragment = new AssistentFragment();
        assistentFragment.setArguments(composeBundle("Дейнерис Таргариен", R.mipmap.deyneris_round, "Лучшие коктейли Вестероса"));
        fragmentTransaction.add(R.id.fragment_assistant2, assistentFragment);
        fragmentTransaction.commit();

        fragmentTransaction = fragmentManager.beginTransaction();
        assistentFragment = new AssistentFragment();
        assistentFragment.setArguments(composeBundle("Зайка Побухайка", R.mipmap.zayac_round, "Дешевле не придумаешь"));
        fragmentTransaction.add(R.id.fragment_assistant3, assistentFragment);
        fragmentTransaction.commit();
    }

}
