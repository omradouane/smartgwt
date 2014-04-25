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
 
package com.smartgwt.client.widgets.form.fields.events;

import com.google.gwt.event.shared.EventHandler;

public interface EditorEnterHandler extends EventHandler {
    /**
     * Notification method fired when the user enters this formItem. Differs from {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addFocusHandler FormItem.focus} in that while <code>focus</code> and
     * <code>blur</code> may fire multiple as the user navigates sub elements of an item (such as interacting with a pick
     * list), <code>editorEnter</code> will typically fire once when the user  starts to edit this item as a whole, and once
     * when the user moves onto a different item or component
     *
     * @param event the event
     */
    void onEditorEnter(com.smartgwt.client.widgets.form.fields.events.EditorEnterEvent event);
}