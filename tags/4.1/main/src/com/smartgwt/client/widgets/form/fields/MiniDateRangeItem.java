/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
package com.smartgwt.client.widgets.form.fields;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Provides a compact interface for editing a date range, by providing a formatted, read-only display of the current
 * selected date range with an icon to launch a {@link com.smartgwt.client.widgets.DateRangeDialog}  to edit the range.
 */
@BeanFactory.FrameworkClass
public class MiniDateRangeItem extends StaticTextItem {

    public static MiniDateRangeItem getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);

		if(obj != null && JSOHelper.getAttribute(jsObj,"__ref")==null) {
            return com.smartgwt.client.util.ObjectFactory.createFormItem("MiniDateRangeItem",jsObj);

        } else
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (MiniDateRangeItem) obj;
        } else {
            return new MiniDateRangeItem(jsObj);
        }
    }


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc.MiniDateRangeItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        $wnd.isc.MiniDateRangeItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.MiniDateRangeItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public MiniDateRangeItem(){
        setAttribute("editorType", "MiniDateRangeItem");
    }

    public MiniDateRangeItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public MiniDateRangeItem(String name) {
        setName(name);
                setAttribute("editorType", "MiniDateRangeItem");
    }


    public MiniDateRangeItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "MiniDateRangeItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * If this attribute is set to true, the pop up date range dialog will automatically validate the user-entered <i>"to"</i>
     * and <i>"from"</i> values on  <code>"OK"</code>-click, and refuse to dismiss if these items contain invalid values.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getAutoValidate autoValidate}
     *
     * @param autoValidate New auto-validate setting.. Default value is true
     */
    public void setAutoValidate(Boolean autoValidate) {
        setAttribute("autoValidate", autoValidate);
    }

    /**
     * If this attribute is set to true, the pop up date range dialog will automatically validate the user-entered <i>"to"</i>
     * and <i>"from"</i> values on  <code>"OK"</code>-click, and refuse to dismiss if these items contain invalid values.
     *
     * @return Boolean
     */
    public Boolean getAutoValidate()  {
        return getAttributeAsBoolean("autoValidate");
    }

    /**
     * MiniDateRangeItems are marked as canFocus:true, and set up with properties such that focus will always go to the icon to
     * launch the dateRange dialog. Set canFocus to false to  suppress this behavior.
     *
     * @param canFocus  Default value is true
     */
    public void setCanFocus(Boolean canFocus) {
        setAttribute("canFocus", canFocus);
    }

    /**
     * MiniDateRangeItems are marked as canFocus:true, and set up with properties such that focus will always go to the icon to
     * launch the dateRange dialog. Set canFocus to false to  suppress this behavior.
     *
     * @return Boolean
     */
    public Boolean getCanFocus()  {
        return getAttributeAsBoolean("canFocus");
    }

    /**
     * Format for displaying dates to the user.   <P> If this attribute is unset, the display value is formatted intelligently
     * according to the dates involved.  For example, if both dates appear in the same month, the value will be  formatted as 
     * <P><code>Month date1 - date2, Year</code>  <P>and, if in different months of the same year,  <P><code>Month1 date1 -
     * Month2 date2, Year</code>. <P>If either date-value is unset, the display-value is formatted according to  {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getFromDateOnlyPrefix fromDateOnlyPrefix} and  {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getToDateOnlyPrefix toDateOnlyPrefix}.
     *
     * @param dateDisplayFormat  Default value is null
     */
    public void setDateDisplayFormat(DateDisplayFormat dateDisplayFormat) {
        setAttribute("dateDisplayFormat", dateDisplayFormat == null ? null : dateDisplayFormat.getValue());
    }

    /**
     * Format for displaying dates to the user.   <P> If this attribute is unset, the display value is formatted intelligently
     * according to the dates involved.  For example, if both dates appear in the same month, the value will be  formatted as 
     * <P><code>Month date1 - date2, Year</code>  <P>and, if in different months of the same year,  <P><code>Month1 date1 -
     * Month2 date2, Year</code>. <P>If either date-value is unset, the display-value is formatted according to  {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getFromDateOnlyPrefix fromDateOnlyPrefix} and  {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getToDateOnlyPrefix toDateOnlyPrefix}.
     *
     * @return DateDisplayFormat
     */
    public DateDisplayFormat getDateDisplayFormat()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateDisplayFormat"));
    }

    /**
     * The text to prepend to the formatted date when only a {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getFromDate fromDate} is supplied.
     *
     * @param fromDateOnlyPrefix  Default value is "Since"
     */
    public void setFromDateOnlyPrefix(String fromDateOnlyPrefix) {
        setAttribute("fromDateOnlyPrefix", fromDateOnlyPrefix);
    }

    /**
     * The text to prepend to the formatted date when only a {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getFromDate fromDate} is supplied.
     *
     * @return String
     */
    public String getFromDateOnlyPrefix()  {
        return getAttributeAsString("fromDateOnlyPrefix");
    }

    /**
     * Icon that launches a {@link com.smartgwt.client.widgets.DateChooser} for choosing an absolute date.
     *
     * @param pickerIcon  Default value is null
     */
    public void setPickerIcon(FormItemIcon pickerIcon) {
        setAttribute("pickerIcon", pickerIcon.getJsObj());
    }

    /**
     * Icon that launches a {@link com.smartgwt.client.widgets.DateChooser} for choosing an absolute date.
     *
     * @return FormItemIcon
     */
    public FormItemIcon getPickerIcon()  {
        return new FormItemIcon(getAttributeAsJavaScriptObject("pickerIcon"));
    }

    /**
     * The prompt to show when the mouse is hovered over the {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getPickerIcon pickerIcon}.
     *
     * @param pickerIconPrompt  Default value is "Show Date Chooser"
     */
    public void setPickerIconPrompt(String pickerIconPrompt) {
        setAttribute("pickerIconPrompt", pickerIconPrompt);
    }

    /**
     * The prompt to show when the mouse is hovered over the {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getPickerIcon pickerIcon}.
     *
     * @return String
     */
    public String getPickerIconPrompt()  {
        return getAttributeAsString("pickerIconPrompt");
    }

    /**
     * Pop-up {@link com.smartgwt.client.widgets.DateRangeDialog} for entering a date range.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return DateRangeDialog
     */
    public DateRangeDialog getRangeDialog()  {
        return (DateRangeDialog)DateRangeDialog.getByJSObject(getAttributeAsJavaScriptObject("rangeDialog"));
    }

    /**
     * Allow miniDateRangeItems' values to show up in the form's values array, or if  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria} is called, for the
     * criterion to be included in the returned AdvancedCriteria object
     *
     * @param shouldSaveValue  Default value is true
     */
    public void setShouldSaveValue(Boolean shouldSaveValue) {
        setAttribute("shouldSaveValue", shouldSaveValue);
    }

    /**
     * Allow miniDateRangeItems' values to show up in the form's values array, or if  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria} is called, for the
     * criterion to be included in the returned AdvancedCriteria object
     *
     * @return Boolean
     */
    public Boolean getShouldSaveValue()  {
        return getAttributeAsBoolean("shouldSaveValue");
    }

    /**
     * Base CSS class name for a form item's text box element. <P> NOTE: See the {@link
     * com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special skinning considerations.
     *
     * @param textBoxStyle  See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle} . Default value is "textItem"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class name for a form item's text box element. <P> NOTE: See the {@link
     * com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special skinning considerations.
     *
     * @return  See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle} 
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }

    /**
     * The text to prepend to the formatted date when only a {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getToDate toDate} is supplied.
     *
     * @param toDateOnlyPrefix  Default value is "Before"
     */
    public void setToDateOnlyPrefix(String toDateOnlyPrefix) {
        setAttribute("toDateOnlyPrefix", toDateOnlyPrefix);
    }

    /**
     * The text to prepend to the formatted date when only a {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getToDate toDate} is supplied.
     *
     * @return String
     */
    public String getToDateOnlyPrefix()  {
        return getAttributeAsString("toDateOnlyPrefix");
    }

    // ********************* Methods ***********************
	/**
     * Whether the {@link com.smartgwt.client.widgets.DateRangeDialog} opened when the  {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getPickerIcon pickerIcon} is clicked should display  {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem}s or {@link com.smartgwt.client.widgets.form.fields.DateItem}s.
     *
     * @return true
     */
    public native Boolean allowRelativeDates() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.allowRelativeDates();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Overridden to return true: dateRangeItems always generate AdvancedCriteria.
     *
     * @return true
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native Boolean hasAdvancedCriteria() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.hasAdvancedCriteria();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties of the class instance passed to this function.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param miniDateRangeItemProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(MiniDateRangeItem miniDateRangeItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},miniDateRangeItemProperties.@com.smartgwt.client.core.RefDataClass::getJsObj()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.MiniDateRangeItem.addProperties(properties);
    }-*/;

    // ***********************************************************


    /**
     * Initial value for the "from" date.
     * Sets the {@link DateRangeItem#getFromDate fromDate} for this DateRangeItem.
     *
     * @param fromDate the date from which this item should start it's range. Default value is today
     */
    public void setFromDate(java.util.Date fromDate) {
        setAttribute("fromDate", fromDate);
    }

    /**
     * Initial value for the "from" date.
     *
     *
     * @return java.util.Date
     */
    public java.util.Date getFromDate()  {
        if(!isCreated()) {
            return getAttributeAsDate("fromDate");
        } else {
            DateRange dateRange = getValue();
            return dateRange == null ? null : dateRange.getStartDate();
        }
    }

    /**
     * Initial value for the "to" date.
     * Sets the {@link DateRangeItem#getToDate toDate} for this DateRangeItem.
     *
     * @param toDate the date at which this item should end it's range. Default value is today
     */
    public void setToDate(java.util.Date toDate) {
        setAttribute("toDate", toDate);
    }

    /**
     * Initial value for the "to" date.
     *
     *
     * @return java.util.Date
     */
    public java.util.Date getToDate()  {
        if(!isCreated()) {
            return getAttributeAsDate("toDate");
        } else {
            DateRange dateRange = getValue();
            return dateRange == null ? null : dateRange.getEndDate();
        }
    }

    /**
     * Retrieves the current value of this dateRangeItem.  The return value is a
     * {@link com.smartgwt.client.data.DateRange} object that excludes start and end values if they aren't set.
     *
     * @return the current value of this item
     */
    public native DateRange getValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var valueJS = self.getValue();
        var dateRangeJ = @com.smartgwt.client.widgets.form.fields.DateRangeItem::convertToDateRange(Lcom/google/gwt/core/client/JavaScriptObject;)(valueJS);
        return dateRangeJ;
    }-*/;

    private static native DateRange convertToDateRange(JavaScriptObject valueJS)/*-{
        if(valueJS == null) return null;
        var startJS = valueJS.start;
        var endJS = valueJS.end;

        var dateRangeJ = @com.smartgwt.client.data.DateRange::new()();
        if(startJS == null || startJS === undefined) {
            //do nothing as null is the default
        } else {
            if($wnd.isc.isA.Date(startJS)) {
                var start = @com.smartgwt.client.util.JSOHelper::toDate(D)(startJS.getTime());
                dateRangeJ.@com.smartgwt.client.data.DateRange::setStartDate(Ljava/util/Date;)(start);
            } else if($wnd.isc.isA.String(startJS)) {
                var start = @com.smartgwt.client.data.RelativeDate::new(Ljava/lang/String;)(startJS);
                dateRangeJ.@com.smartgwt.client.data.DateRange::setRelativeStartDate(Lcom/smartgwt/client/data/RelativeDate;)(start);
            } else if(startJS.value) {
                var start = @com.smartgwt.client.data.RelativeDate::new(Lcom/google/gwt/core/client/JavaScriptObject;)(startJS);
                dateRangeJ.@com.smartgwt.client.data.DateRange::setRelativeStartDate(Lcom/smartgwt/client/data/RelativeDate;)(start);
            }
        }
        if(endJS == null || endJS === undefined) {
            //do nothing as null is the default
        } else {
            if($wnd.isc.isA.Date(endJS)) {
                var end = @com.smartgwt.client.util.JSOHelper::toDate(D)(endJS.getTime());
                dateRangeJ.@com.smartgwt.client.data.DateRange::setEndDate(Ljava/util/Date;)(end);
            } else if($wnd.isc.isA.String(endJS)) {
                var end = @com.smartgwt.client.data.RelativeDate::new(Ljava/lang/String;)(endJS);
                dateRangeJ.@com.smartgwt.client.data.DateRange::setRelativeEndDate(Lcom/smartgwt/client/data/RelativeDate;)(end);
            } else if(endJS.value) {
                var end = @com.smartgwt.client.data.RelativeDate::new(Lcom/google/gwt/core/client/JavaScriptObject;)(endJS);
                dateRangeJ.@com.smartgwt.client.data.DateRange::setRelativeEndDate(Lcom/smartgwt/client/data/RelativeDate;)(end);
            }
        }
        return dateRangeJ;
    }-*/;

    /**
     * Sets the value for this dateRangeItem.  The value parameter is a  {@link com.smartgwt.client.data.DateRange DateRange} object
     * that optionally includes both start and end values.
     *
     * @param value the new value for this item
     */
    public native void setValue(DateRange value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var valueJS = value.@com.smartgwt.client.core.JsObject::getJsObj()();
        if(self.setValue) {
            self.setValue(valueJS);
        } else {
            self.defaultValue = valueJS;
        }
    }-*/;

    /**
     * The default <code>getCriterion()</code> implementation returns the Criterion entered in the fields shown in the  {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getRangeDialog rangeDialog}. <P> If both dates are entered, a
     * Criterion with an "and" {@link com.smartgwt.client.types.OperatorId operator}  and both "greaterOrEqual" and
     * "lessOrEqual" sub-criteria will be returned.  If either date is omitted, only the "greaterOrEqual" (from date) or
     * "lessOrEqual" (to date)  Criterion is returned.
     * @param getter provides a method to get a criterion object based on this field's current edited value(s).
     *
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCriterionGetter
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public void setCriterionGetter(FormItemCriterionGetter getter) {
        super.setCriterionGetter(getter);
    }

}


