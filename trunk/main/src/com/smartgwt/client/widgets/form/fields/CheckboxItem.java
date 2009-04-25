/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.client.widgets.form.fields;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * Checkbox form item, implemented with customizeable checkbox images

    */
public class CheckboxItem extends FormItem {

    public static CheckboxItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (CheckboxItem) obj;
        } else {
            return new CheckboxItem(jsObj);
        }
    }


    public CheckboxItem(){
        setType("CheckboxItem");
    }

    public CheckboxItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public CheckboxItem(String name) {
        setName(name);
        setType("CheckboxItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
    * Base CSS class for this item's title text
    *
    * @param textBoxStyle textBoxStyle Default value is "labelAnchor"
    */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }
    /**
     * Base CSS class for this item's title text
     *
     *
     * @return String
     *
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }

    /**
    * CheckboxItem has special behavior for titles, see {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getLabelAsTitle labelAsTitle}.
    *
    * @param showTitle showTitle Default value is true
    */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle);
    }
    /**
     * CheckboxItem has special behavior for titles, see {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getLabelAsTitle labelAsTitle}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }

    /**
    * By default a checkboxItem sets {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowTitle showTitle}:true, and so takes up two cells with the&#010 default ${isc.DocUtils.linkForRef('type:TitleOrientation')} of "left" (see {@link com.smartgwt.client.docs.FormLayout 'form layout&#010 overview'}).  However, the title cell is left blank by default, and the title specified&#010 by {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitle title} is shown inside the formItem's cell instead, in an element&#010 called the "label".&#010 <P>&#010 To instead show the title in it's original location, set <code>labelAsTitle:true</code>.&#010 You can also set {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowLabel showLabel}:false to suppress the label and/or title altogether.
    *
    * @param labelAsTitle labelAsTitle Default value is null
    */
    public void setLabelAsTitle(Boolean labelAsTitle) {
        setAttribute("labelAsTitle", labelAsTitle);
    }
    /**
     * By default a checkboxItem sets {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowTitle showTitle}:true, and so takes up two cells with the&#010 default ${isc.DocUtils.linkForRef('type:TitleOrientation')} of "left" (see {@link com.smartgwt.client.docs.FormLayout 'form layout&#010 overview'}).  However, the title cell is left blank by default, and the title specified&#010 by {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitle title} is shown inside the formItem's cell instead, in an element&#010 called the "label".&#010 <P>&#010 To instead show the title in it's original location, set <code>labelAsTitle:true</code>.&#010 You can also set {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowLabel showLabel}:false to suppress the label and/or title altogether.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getLabelAsTitle()  {
        return getAttributeAsBoolean("labelAsTitle");
    }

    /**
    * Should we should the label text next to the checkbox item.
    *
    * @param showLabel showLabel Default value is true
    */
    public void setShowLabel(Boolean showLabel) {
        setAttribute("showLabel", showLabel);
    }
    /**
     * Should we should the label text next to the checkbox item.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowLabel()  {
        return getAttributeAsBoolean("showLabel");
    }

    /**
    * URL for the image to display when this checkbox is selected, or checked.&#010 This is the base image name - if <code>showValueIconOver</code> et al are set, the&#010 state (<code>"Over"</code>, <code>"Down"</code> and <code>"Disabled"</code>) will be&#010 added to this name as the user intereacts with the checkbox, as well as the &#010 <code>".gif"</code> extension
    *
    * @param checkedImage checkedImage Default value is "[SKIN]/DynamicForm/checked.gif"
    */
    public void setCheckedImage(String checkedImage) {
        setAttribute("checkedImage", checkedImage);
    }
    /**
     * URL for the image to display when this checkbox is selected, or checked.&#010 This is the base image name - if <code>showValueIconOver</code> et al are set, the&#010 state (<code>"Over"</code>, <code>"Down"</code> and <code>"Disabled"</code>) will be&#010 added to this name as the user intereacts with the checkbox, as well as the &#010 <code>".gif"</code> extension
     *
     *
     * @return String
     *
     */
    public String getCheckedImage()  {
        return getAttributeAsString("checkedImage");
    }

    /**
    * URL for the image to display when this checkbox is not selected, or unchecked
    *
    * @param uncheckedImage uncheckedImage Default value is "[SKIN]/DynamicForm/unchecked.gif"
    */
    public void setUncheckedImage(String uncheckedImage) {
        setAttribute("uncheckedImage", uncheckedImage);
    }
    /**
     * URL for the image to display when this checkbox is not selected, or unchecked
     *
     *
     * @return String
     *
     */
    public String getUncheckedImage()  {
        return getAttributeAsString("uncheckedImage");
    }

    /**
    * URL for the image to display when this checkbox is unset. Note that if &#010 {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowUnsetImage showUnsetImage} is false or {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getAllowEmptyValue allowEmptyValue} is false&#010 the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUncheckedImage uncheckedImage} will be used for null values rather than this&#010 image.
    *
    * @param unsetImage unsetImage Default value is "[SKIN]/DynamicForm/unsetcheck.gif"
    */
    public void setUnsetImage(String unsetImage) {
        setAttribute("unsetImage", unsetImage);
    }
    /**
     * URL for the image to display when this checkbox is unset. Note that if &#010 {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowUnsetImage showUnsetImage} is false or {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getAllowEmptyValue allowEmptyValue} is false&#010 the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUncheckedImage uncheckedImage} will be used for null values rather than this&#010 image.
     *
     *
     * @return String
     *
     */
    public String getUnsetImage()  {
        return getAttributeAsString("unsetImage");
    }

    /**
    * By default checkboxes allow the user to toggle between true and false values only.&#010 Setting this property to true will allow the user to toggle between three values - &#010 <code>true</code>, <code>false</code> and unset.
    *
    * @param allowEmptyValue allowEmptyValue Default value is false
    */
    public void setAllowEmptyValue(Boolean allowEmptyValue) {
        setAttribute("allowEmptyValue", allowEmptyValue);
    }
    /**
     * By default checkboxes allow the user to toggle between true and false values only.&#010 Setting this property to true will allow the user to toggle between three values - &#010 <code>true</code>, <code>false</code> and unset.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAllowEmptyValue()  {
        return getAttributeAsBoolean("allowEmptyValue");
    }

    // ********************* Methods ***********************


    // ********************* Static Methods ***********************




    /**
    * Determines what image to display when the value for this checkbox is unset. Set to true to display the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUnsetImage unsetImage} for null values, or false to use the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUncheckedImage uncheckedImage} for both null and explicitly unchecked values. <P> If this attribute is not set, the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUnsetImage unsetImage} for null values if  {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getAllowEmptyValue allowEmptyValue} is true for this item, otherwise the unchecked image will be used.
    *
    * @param showUnsetImage showUnsetImage Default value is IRA
    */
    public void setShowUnsetImage(Boolean showUnsetImage) {
        setAttribute("showUnsetImage", showUnsetImage);
    }

}




