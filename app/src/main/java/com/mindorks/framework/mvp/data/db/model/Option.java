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

package com.mindorks.framework.mvp.data.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by janisharali on 28/01/17.
 */

@Entity(nameInDb = "options")
public class Option {

    @Expose
    @SerializedName("id")
    @Id(autoincrement = true)
    private Long id;

    @Expose
    @SerializedName("option_text")
    @Property(nameInDb = "option_text")
    private String optionText;

    @Expose
    @SerializedName("question_id")
    @Property(nameInDb = "question_id")
    private Long questionId;

    @Expose
    @SerializedName("is_correct")
    @Property(nameInDb = "is_correct")
    private boolean isCorrect;

    @Expose
    @SerializedName("created_at")
    @Property(nameInDb = "created_at")
    private String createdAt;

    @Expose
    @SerializedName("updated_at")
    @Property(nameInDb = "updated_at")
    private String updatedAt;

    @Generated(hash = 435722130)
    public Option(Long id, String optionText, Long questionId, boolean isCorrect,
                  String createdAt, String updatedAt) {
        this.id = id;
        this.optionText = optionText;
        this.questionId = questionId;
        this.isCorrect = isCorrect;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Generated(hash = 104107376)
    public Option() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean getIsCorrect() {
        return this.isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}