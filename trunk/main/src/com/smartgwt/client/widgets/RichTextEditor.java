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
 
package com.smartgwt.client.widgets;



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
    * RichTextEditing component.  Provides a rich-text editing area along with UI for executing&#010 rich-text commands on the text.<br>&#010 The HTML generated from this component may vary by browser, and, as with any HTML &#010 value created on the client, we recommend values be sanitized on the server before &#010 storing and displaying to other users.<br>&#010 Note: This component has limited support on the Safari browser.

    */
public class RichTextEditor extends VLayout {

    public static RichTextEditor getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (RichTextEditor) obj;
        } else {
            return new RichTextEditor(jsObj);
        }
    }


    public RichTextEditor(){
        
    }

    public RichTextEditor(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.RichTextEditor.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * Initial value for the edit area.    Use <code>getValue()</code> and &#010 <code>setValue()</code> to update at runtime.
    * Updates the current value of the edit area.&#010
    *
    * @param value value Default value is ""
    */
    public void setValue(String value) {
        setAttribute("value", value, true);
    }
    /**
     * Initial value for the edit area.    Use <code>getValue()</code> and &#010 <code>setValue()</code> to update at runtime.
     *
     *
     * @return Retrieves the current value of the edit area.&#010
     *
     */
    public String getValue()  {
        return getAttributeAsString("value");
    }

    // ********************* Methods ***********************

        /**
         * Display a warning if Rich Text Editing is not fully supported in this browser.&#010 Default behavior logs a warning to the devloper console - Override this if a user-visible&#010 warning is required &#010
         */
        public native void doWarn() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.doWarn();
        }-*/;

        /**
         * Does this browser support the full RichTextEditor feature set.&#010 Returns false for browsers in which some features are not natively supported&#010 - currently Safari and Opera.&#010
         *
         * @return false if this browser doesn't fully support RichTextEditing
         */
        public native Boolean richEditorSupported() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.richEditorSupported();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;



    // ********************* Static Methods ***********************




    /**
     * An array of control group names specifying which groups of controls should be included in the editor toolbar.
     *
     * @param controlGroups the control groups. default is {"fontControls", "formatControls", "styleControls",
     *                      "colorControls"}
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setControlGroups(String... controlGroups) {
        setAttribute("controlGroups", controlGroups, false);
    }

}



