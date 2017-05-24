/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.mindorks.framework.mvp.ui.main.rating;

import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.mindorks.framework.mvp.R;
import com.mindorks.framework.mvp.di.component.ActivityComponent;
import com.mindorks.framework.mvp.ui.base.BaseDialog;
import com.mindorks.framework.mvp.utils.AppUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by janisharali on 21/03/17.
 */

public class RateUsDialog extends BaseDialog implements RatingDialogMvpView {

    private static final String TAG = "RateUsDialog";

    @Inject
    RatingDialogMvpPresenter<RatingDialogMvpView> mPresenter;

    @BindView(R.id.rating_bar_feedback)
    RatingBar mRatingBar;

    @BindView(R.id.et_message)
    EditText mMessage;

    @BindView(R.id.view_rating_message)
    View mRatingMessageView;

    @BindView(R.id.view_play_store_rating)
    View mPlayStoreRatingView;

    @BindView(R.id.btn_submit)
    Button mSubmitButton;


    public static RateUsDialog newInstance() {
        RateUsDialog fragment = new RateUsDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_rate_us, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {

            component.inject(this);

            setUnBinder(ButterKnife.bind(this, view));

            mPresenter.onAttach(this);
        }

        return view;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }


    @Override
    public void openPlayStoreForRating() {
        AppUtils.openPlayStoreForCorrectify(getContext());
    }

    @Override
    public void showPlayStoreRatingView() {
        mPlayStoreRatingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showRatingMessageView() {
        mRatingMessageView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void setUp(View view) {

        mRatingMessageView.setVisibility(View.GONE);
        mPlayStoreRatingView.setVisibility(View.GONE);

        LayerDrawable stars = (LayerDrawable) mRatingBar.getProgressDrawable();
        stars.getDrawable(2)
                .setColorFilter(ContextCompat.getColor(getContext(), R.color.yellow), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(0)
                .setColorFilter(ContextCompat.getColor(getContext(), R.color.shadow), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(1)
                .setColorFilter(ContextCompat.getColor(getContext(), R.color.shadow), PorterDuff.Mode.SRC_ATOP);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onRatingSubmitted(mRatingBar.getRating(), mMessage.getText().toString());
            }
        });

    }

    @OnClick(R.id.btn_later)
    void onLaterClick() {
        mPresenter.onLaterClicked();
    }

    @OnClick(R.id.btn_rate_on_play_store)
    void onPlayStoreRateClick() {
        mPresenter.onPlayStoreRatingClicked();
    }

    @Override
    public void disableRatingStars() {
        mRatingBar.setIsIndicator(true);
    }

    @Override
    public void hideSubmitButton() {
        mSubmitButton.setVisibility(View.GONE);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}