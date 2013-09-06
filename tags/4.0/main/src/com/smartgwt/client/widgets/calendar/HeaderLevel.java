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
 
package com.smartgwt.client.widgets.calendar;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * Defines one level of headers shown above the event area in a {@link com.smartgwt.client.widgets.calendar.Timeline}.
 */
public class HeaderLevel extends RefDataClass {

    public static HeaderLevel getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);


        if(obj != null) {
            obj.setJsObj(jsObj);
            return (HeaderLevel) obj;
        } else {
            return new HeaderLevel(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }



    public HeaderLevel(){
        
    }

    public HeaderLevel(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        
    }

    public HeaderLevel(TimeUnit unit) {
        setUnit(unit);
        
    }

    public HeaderLevel(TimeUnit unit, String[] titles) {
        setUnit(unit);
		setTitles(titles);
        
    }


    // ********************* Properties / Attributes ***********************


    /**
     * If set, the width for each of the spans in this headerLevel.  Note that this setting only  has an effect on the
     * innermost headerLevel.
     *
     * @param headerWidth headerWidth Default value is null
     */
    public void setHeaderWidth(Integer headerWidth) {
        setAttribute("headerWidth", headerWidth);
    }

    /**
     * If set, the width for each of the spans in this headerLevel.  Note that this setting only  has an effect on the
     * innermost headerLevel.
     *
     * @return Integer
     */
    public Integer getHeaderWidth()  {
        return getAttributeAsInt("headerWidth");
    }


    /**
     * Optional sparse array of titles for the spans on this headerLevel.  If a given span in this headerLevel has a
     * corresponding entry in this array, it will be used as the span's title. <P>  If not specified, default titles are
     * generated (eg "Q1" for unit "quarter") and then passed into the {@link
     * com.smartgwt.client.widgets.calendar.HeaderLevel#titleFormatter formatter function}, if one has been installed, for
     * further customization.
     *
     * @param titles . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setTitles(String... titles) {
        setAttribute("titles", titles);
    }

    /**
     * Optional sparse array of titles for the spans on this headerLevel.  If a given span in this headerLevel has a
     * corresponding entry in this array, it will be used as the span's title. <P>  If not specified, default titles are
     * generated (eg "Q1" for unit "quarter") and then passed into the {@link
     * com.smartgwt.client.widgets.calendar.HeaderLevel#titleFormatter formatter function}, if one has been installed, for
     * further customization.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String[] getTitles()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("titles"));
    }


    /**
     * Unit of time shown at this level of header.
     *
     * @param unit unit Default value is null
     */
    public void setUnit(TimeUnit unit) {
        setAttribute("unit", unit == null ? null : unit.getValue());
    }

    /**
     * Unit of time shown at this level of header.
     *
     * @return TimeUnit
     */
    public TimeUnit getUnit()  {
        return EnumUtil.getEnum(TimeUnit.values(), getAttribute("unit"));
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}

