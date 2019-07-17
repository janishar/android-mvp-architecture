<?xml version="1.0"?>
<recipe>
	<#include "../common/recipe_manifest.xml.ftl" /><#if generateLayout>
	<#include "activity_layout_recipe.xml.ftl" />
	<open file="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />
</#if>
<instantiate from="src/app_package/View.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${folderName}/${className}MvpView.java" />
<instantiate from="src/app_package/Activity.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${folderName}/${activityClass}.java" />
<instantiate from="src/app_package/Presenter.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${folderName}/${className}Presenter.java" />
<instantiate from="src/app_package/MvpPresenter.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${folderName}/${className}MvpPresenter.java" />
<open file="${srcOut}/${folderName}/${className}MvpPresenter.java"/>
<open file="${srcOut}/${folderName}/${className}MvpView.java"/>
<open file="${srcOut}/${folderName}/${className}Presenter.java"/>
<open file="${srcOut}/${folderName}/${activityClass}.java"/></recipe>