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

import com.mindorks.framework.mvp.data.db.model.Question;
import com.mindorks.framework.mvp.ui.base.MvpView;

import java.util.List;

/**
 * Created by janisharali on 27/01/17.
 */

public interface MainMvpView extends MvpView {

    void openLoginActivity();

    void showSettingFragment();

    void refreshQuestionnaire(List<Question> questionList);
}
