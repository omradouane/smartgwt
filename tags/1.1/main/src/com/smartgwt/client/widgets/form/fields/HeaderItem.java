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
    * FormItem for showing a header within a DynamicForm.&#010 <p>&#010 Set the <code>defaultValue</code> of this item to the HTML you want to embed in the form.

    */
public class HeaderItem extends FormItem {

    public static HeaderItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (HeaderItem) obj;
        } else {
            return new HeaderItem(jsObj);
        }
    }


    public HeaderItem(){
        setType("HeaderItem");
    }

    public HeaderItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public HeaderItem(String name) {
        setName(name);
        setType("HeaderItem");
    }

    public HeaderItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("HeaderItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
    * Header text
    *
    * @param defaultValue defaultValue Default value is "Header"
    */
    public void setDefaultValue(String defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }
    /**
     * Header text
     *
     *
     * @return String
     *
     */
    public String getDefaultValue()  {
        return getAttributeAsString("defaultValue");
    }

    /**
    * Don't show a separate title cell for headers
    *
    * @param showTitle showTitle Default value is false
    */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle);
    }
    /**
     * Don't show a separate title cell for headers
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }

    /**
    * Base CSS class for this item
    *
    * @param textBoxStyle textBoxStyle Default value is "headerItem"
    */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }
    /**
     * Base CSS class for this item
     *
     *
     * @return String
     *
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }

    /**
    * by default, headers span all remaining columns
    *
    * @param colSpan colSpan Default value is "*"
    */
    public void setColSpan(int colSpan) {
        setAttribute("colSpan", colSpan);
    }
    /**
     * by default, headers span all remaining columns
     *
     *
     * @return int
     *
     */
    public int getColSpan()  {
        return getAttributeAsInt("colSpan");
    }

    /**
    * these items are in a row by themselves by default
    *
    * @param startRow startRow Default value is true
    */
    public void setStartRow(Boolean startRow) {
        setAttribute("startRow", startRow);
    }
    /**
     * these items are in a row by themselves by default
     *
     *
     * @return Boolean
     *
     */
    public Boolean getStartRow()  {
        return getAttributeAsBoolean("startRow");
    }

    /**
    * these items are in a row by themselves by default
    *
    * @param endRow endRow Default value is true
    */
    public void setEndRow(Boolean endRow) {
        setAttribute("endRow", endRow);
    }
    /**
     * these items are in a row by themselves by default
     *
     *
     * @return Boolean
     *
     */
    public Boolean getEndRow()  {
        return getAttributeAsBoolean("endRow");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

}


