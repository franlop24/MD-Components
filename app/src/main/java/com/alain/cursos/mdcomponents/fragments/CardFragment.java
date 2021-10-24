package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.chip.Chip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class CardFragment extends Fragment {

    public static final String TAG = "Card";

    private static Component mInstance;

    Unbinder mUnbinder;
    @BindView(R.id.imgCardLarge)
    ImageView imgCardLarge;
    @BindView(R.id.chpSecond)
    Chip chpSecond;
    @BindView(R.id.chpThird)
    Chip chpThird;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_cards_template);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }


    public CardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop();
        Glide.with(this)
                .load("https://cdn.computerhoy.com/sites/navi.axelspringer.es/public/styles/2400/" +
                        "public/media/image/2020/08/hamburguesa-2028707.jpg?itok=YeexorXR")
                .apply(options)
                .into(imgCardLarge);

        chpSecond.setOnCheckedChangeListener((compoundButton, isCheched) -> {
            if(isCheched){
                Toast.makeText(getActivity(), "Checked", Toast.LENGTH_SHORT).show();
            }
        });

        chpThird.setOnCloseIconClickListener(view1 -> chpThird.setVisibility(View.GONE));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @OnClick(R.id.chpFirst)
    public void onClick() {
        Toast.makeText(getActivity(), "First Chip", Toast.LENGTH_SHORT).show();
    }
}