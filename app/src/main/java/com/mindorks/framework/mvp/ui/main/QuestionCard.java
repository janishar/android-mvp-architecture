/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.mindorks.framework.mvp.ui.main;

import android.util.Log;
import android.widget.TextView;

import com.mindorks.framework.mvp.R;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

/**
 * Created by janisharali on 28/01/17.
 */

@NonReusable
@Layout(R.layout.card_layout)
public class QuestionCard {

    @View(R.id.question_caption)
    TextView mTextView;

    String question;

    public QuestionCard(String question) {
        this.question = question;
    }

    @Click(R.id.btn_answer1)
    public void onClickQ1() {
        String message = String.format(
                "The question is: %s. The answer is: %s.",
                mTextView.getText().toString(),
                "ANSWER1");
        Log.i("PlaceholderView", message);
    }

    @Click(R.id.btn_answer2)
    public void onClickQ2() {
        String message = String.format(
                "The question is: %s. The answer is: %s.",
                mTextView.getText().toString(),
                "ANSWER2");
        Log.i("PlaceholderView", message);
    }

    @Click(R.id.btn_answer3)
    public void onClickQ3() {
        String message = String.format(
                "The question is: %s. The answer is: %s.",
                mTextView.getText().toString(),
                "ANSWER3");
        Log.i("PlaceholderView", message);
    }

    @Resolve
    private void onResolved() {
        mTextView.setText(this.question);
    }
}
