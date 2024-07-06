<?xml version="1.0"?>
<#import "root://activities/common/kotlin_macros.ftl" as kt>
<recipe>
    <#include "../common/recipe_manifest.xml.ftl" />
    <@kt.addAllKotlinDependencies />

    <dependency mavenUrl="com.android.support:appcompat-v7:${buildApi}.+"/>
    <dependency mavenUrl="com.android.support.constraint:constraint-layout:+" />
    <dependency mavenUrl="android.arch.lifecycle:extensions:+"/>
    <#if generateKotlin && useAndroidX>
        <dependency mavenUrl="androidx.lifecycle:lifecycle-viewmodel-ktx:+"/>
    </#if>
<instantiate from="root/src/app_package/View.${ktOrJavaExt}.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${folderName}/${className}MvpView.${ktOrJavaExt}" />
<instantiate from="root/src/app_package/Activity.${ktOrJavaExt}.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${folderName}/${activityClass}.${ktOrJavaExt}" />
<instantiate from="root/src/app_package/Presenter.${ktOrJavaExt}.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${folderName}/${className}Presenter.${ktOrJavaExt}" />
<instantiate from="root/src/app_package/MvpPresenter.${ktOrJavaExt}.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${folderName}/${className}MvpPresenter.${ktOrJavaExt}" />

<instantiate from="root/res/layout/activity.xml.ftl"
                  to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(activityLayout)}.xml" />

<open file="${srcOut}/${folderName}/${className}MvpPresenter.${ktOrJavaExt}"/>
<open file="${srcOut}/${folderName}/${className}MvpView.${ktOrJavaExt}"/>
<open file="${srcOut}/${folderName}/${className}Presenter.${ktOrJavaExt}"/>
<open file="${srcOut}/${folderName}/${activityClass}.${ktOrJavaExt}"/>
</recipe>