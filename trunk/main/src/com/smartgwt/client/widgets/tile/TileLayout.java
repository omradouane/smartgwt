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
 
package com.smartgwt.client.widgets.tile;



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
    * Lays out a series of components, calls "tiles", in a grid with multiple tiles per row.

    */
public class TileLayout extends Canvas {

    public static TileLayout getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (TileLayout) obj;
        } else {
            return new TileLayout(jsObj);
        }
    }


    public TileLayout(){
        
    }

    public TileLayout(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.TileLayout.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * Size of each tile in pixels.  Depending on the ${isc.DocUtils.linkForRef('type:LayoutPolicy')}, <code>tileSize</code>&#010 may be taken as a maximum, minimum or exact size of tiles, or may be irrelevant.&#010 <P>&#010 Width and height may be separately set via {@link com.smartgwt.client.widgets.tile.TileLayout#getTileHeight tileHeight} and {@link com.smartgwt.client.widgets.tile.TileLayout#getTileWidth tileWidth}.
    * sets the height and width of tiles&#010
    *
    * @param tileSize size. Default value is 50
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setTileSize(int tileSize)  throws IllegalStateException {
        setAttribute("tileSize", tileSize, false);
    }
    /**
     * Size of each tile in pixels.  Depending on the ${isc.DocUtils.linkForRef('type:LayoutPolicy')}, <code>tileSize</code>&#010 may be taken as a maximum, minimum or exact size of tiles, or may be irrelevant.&#010 <P>&#010 Width and height may be separately set via {@link com.smartgwt.client.widgets.tile.TileLayout#getTileHeight tileHeight} and {@link com.smartgwt.client.widgets.tile.TileLayout#getTileWidth tileWidth}.
     *
     *
     * @return int
     *
     */
    public int getTileSize()  {
        return getAttributeAsInt("tileSize");
    }

    /**
    * Width of each tile in pixels.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileSize tileSize}.
    * sets the width of tiles&#010
    *
    * @param tileWidth width. Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setTileWidth(Integer tileWidth)  throws IllegalStateException {
        setAttribute("tileWidth", tileWidth, false);
    }
    /**
     * Width of each tile in pixels.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileSize tileSize}.
     *
     *
     * @return Integer
     *
     */
    public Integer getTileWidth()  {
        return getAttributeAsInt("tileWidth");
    }

    /**
    * Height of each tile in pixels.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileSize tileSize}.
    * sets the height of tiles&#010
    *
    * @param tileHeight height. Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setTileHeight(Integer tileHeight)  throws IllegalStateException {
        setAttribute("tileHeight", tileHeight, false);
    }
    /**
     * Height of each tile in pixels.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileSize tileSize}.
     *
     *
     * @return Integer
     *
     */
    public Integer getTileHeight()  {
        return getAttributeAsInt("tileHeight");
    }

    /**
    * Margin in between tiles.  Can be set on a per-axis basis with {@link com.smartgwt.client.widgets.tile.TileLayout#getTileHMargin tileHMargin} and&#010 {@link com.smartgwt.client.widgets.tile.TileLayout#getTileVMargin tileVMargin}.
    * sets the width of tiles&#010
    *
    * @param tileMargin margin. Default value is 10
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setTileMargin(int tileMargin)  throws IllegalStateException {
        setAttribute("tileMargin", tileMargin, false);
    }
    /**
     * Margin in between tiles.  Can be set on a per-axis basis with {@link com.smartgwt.client.widgets.tile.TileLayout#getTileHMargin tileHMargin} and&#010 {@link com.smartgwt.client.widgets.tile.TileLayout#getTileVMargin tileVMargin}.
     *
     *
     * @return int
     *
     */
    public int getTileMargin()  {
        return getAttributeAsInt("tileMargin");
    }

    /**
    * Horizontal margin in between tiles.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileMargin tileMargin}.
    * sets the width of tiles&#010
    *
    * @param tileHMargin width. Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setTileHMargin(Integer tileHMargin)  throws IllegalStateException {
        setAttribute("tileHMargin", tileHMargin, false);
    }
    /**
     * Horizontal margin in between tiles.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileMargin tileMargin}.
     *
     *
     * @return Integer
     *
     */
    public Integer getTileHMargin()  {
        return getAttributeAsInt("tileHMargin");
    }

    /**
    * Vertical margin in between tiles.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileMargin tileMargin}.
    * sets the width of tiles&#010
    *
    * @param tileVMargin width. Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setTileVMargin(Integer tileVMargin)  throws IllegalStateException {
        setAttribute("tileVMargin", tileVMargin, false);
    }
    /**
     * Vertical margin in between tiles.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileMargin tileMargin}.
     *
     *
     * @return Integer
     *
     */
    public Integer getTileVMargin()  {
        return getAttributeAsInt("tileVMargin");
    }

    /**
    * A margin left around the outside of all tiles.
    *
    * @param layoutMargin layoutMargin Default value is 5
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setLayoutMargin(int layoutMargin)  throws IllegalStateException {
        setAttribute("layoutMargin", layoutMargin, false);
    }
    /**
     * A margin left around the outside of all tiles.
     *
     *
     * @return int
     *
     */
    public int getLayoutMargin()  {
        return getAttributeAsInt("layoutMargin");
    }

    /**
    * If this widget has padding specified (as {@link com.smartgwt.client.widgets.Canvas#getPadding padding} or in the&#010 CSS style applied to this layout), should it show up as space outside the members,&#010 similar to layoutMargin?&#010 <P>&#010 If this setting is false, padding will not affect member positioning (as CSS padding&#010 normally does not affect absolutely positioned children).  Leaving this setting true&#010 allows a designer to more effectively control layout purely from CSS.&#010 <P>&#010 Note that {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin} if specified, takes precidence over this value.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param paddingAsLayoutMargin paddingAsLayoutMargin Default value is true
    */
    public void setPaddingAsLayoutMargin(Boolean paddingAsLayoutMargin) {
        setAttribute("paddingAsLayoutMargin", paddingAsLayoutMargin, true);
    }
    /**
     * If this widget has padding specified (as {@link com.smartgwt.client.widgets.Canvas#getPadding padding} or in the&#010 CSS style applied to this layout), should it show up as space outside the members,&#010 similar to layoutMargin?&#010 <P>&#010 If this setting is false, padding will not affect member positioning (as CSS padding&#010 normally does not affect absolutely positioned children).  Leaving this setting true&#010 allows a designer to more effectively control layout purely from CSS.&#010 <P>&#010 Note that {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin} if specified, takes precidence over this value.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getPaddingAsLayoutMargin()  {
        return getAttributeAsBoolean("paddingAsLayoutMargin");
    }

    /**
    * If set, tiles animate to their new positions when a tile is added, removed, or reordered via&#010 drag and drop.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param animateTileChange animateTileChange Default value is true
    */
    public void setAnimateTileChange(Boolean animateTileChange) {
        setAttribute("animateTileChange", animateTileChange, true);
    }
    /**
     * If set, tiles animate to their new positions when a tile is added, removed, or reordered via&#010 drag and drop.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAnimateTileChange()  {
        return getAttributeAsBoolean("animateTileChange");
    }
             
    /**
    * Direction of tiling.  See also ${isc.DocUtils.linkForRef('type:TileLayoutPolicy')}.
    *
    * @param orientation orientation Default value is "horizontal"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setOrientation(Orientation orientation)  throws IllegalStateException {
        setAttribute("orientation", orientation.getValue(), false);
    }
    /**
     * Direction of tiling.  See also ${isc.DocUtils.linkForRef('type:TileLayoutPolicy')}.
     *
     *
     * @return Orientation
     *
     */
    public Orientation getOrientation()  {
        return (Orientation) EnumUtil.getEnum(Orientation.values(), getAttribute("orientation"));
    }

    /**
    * Number of tiles to show in each line.  Auto-derived from {@link com.smartgwt.client.widgets.tile.TileLayout#getTileSize tileSize} for some layout&#010 modes.  See ${isc.DocUtils.linkForRef('type:TileLayoutPolicy')}.
    *
    * @param tilesPerLine tilesPerLine Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setTilesPerLine(Integer tilesPerLine)  throws IllegalStateException {
        setAttribute("tilesPerLine", tilesPerLine, false);
    }
    /**
     * Number of tiles to show in each line.  Auto-derived from {@link com.smartgwt.client.widgets.tile.TileLayout#getTileSize tileSize} for some layout&#010 modes.  See ${isc.DocUtils.linkForRef('type:TileLayoutPolicy')}.
     *
     *
     * @return Integer
     *
     */
    public Integer getTilesPerLine()  {
        return getAttributeAsInt("tilesPerLine");
    }
             
    /**
    * Normal ${isc.DocUtils.linkForRef('type:Overflow')} settings can be used on TileLayouts, for example, an&#010 overflow:auto TileLayout will scroll if members exceed its specified size, whereas an&#010 overflow:visible TileLayout will grow to accomodate members.
    *
    * @param overflow overflow Default value is "visible"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setOverflow(Overflow overflow)  throws IllegalStateException {
        setAttribute("overflow", overflow.getValue(), false);
    }
    /**
     * Normal ${isc.DocUtils.linkForRef('type:Overflow')} settings can be used on TileLayouts, for example, an&#010 overflow:auto TileLayout will scroll if members exceed its specified size, whereas an&#010 overflow:visible TileLayout will grow to accomodate members.
     *
     *
     * @return Overflow
     *
     */
    public Overflow getOverflow()  {
        return (Overflow) EnumUtil.getEnum(Overflow.values(), getAttribute("overflow"));
    }

    /**
    * With ${isc.DocUtils.linkForRef('type:LayoutPolicy')}:"fit", should margins be expanded so that tiles fill the&#010 available space in the TileLayout on the breadth axis?
    *
    * @param expandMargins expandMargins Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setExpandMargins(Boolean expandMargins)  throws IllegalStateException {
        setAttribute("expandMargins", expandMargins, false);
    }
    /**
     * With ${isc.DocUtils.linkForRef('type:LayoutPolicy')}:"fit", should margins be expanded so that tiles fill the&#010 available space in the TileLayout on the breadth axis?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getExpandMargins()  {
        return getAttributeAsBoolean("expandMargins");
    }

    /**
    * When ${isc.DocUtils.linkForRef('type:LayoutPolicy')} is "flow", should we automatically start a new line when there's&#010 not enough room to fit the next tile on the same line?&#010 <P>&#010 If set to false, a new line will only be started if a tile specifies tile.startLine or&#010 tile.endLine.
    *
    * @param autoWrapLines autoWrapLines Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setAutoWrapLines(Boolean autoWrapLines)  throws IllegalStateException {
        setAttribute("autoWrapLines", autoWrapLines, false);
    }
    /**
     * When ${isc.DocUtils.linkForRef('type:LayoutPolicy')} is "flow", should we automatically start a new line when there's&#010 not enough room to fit the next tile on the same line?&#010 <P>&#010 If set to false, a new line will only be started if a tile specifies tile.startLine or&#010 tile.endLine.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoWrapLines()  {
        return getAttributeAsBoolean("autoWrapLines");
    }
             
    /**
    * Indicates what to do with data dragged into another DataBoundComponent. See&#010          DragDataAction type for details.
    *
    * @param dragDataAction dragDataAction Default value is Canvas.MOVE
    */
    public void setDragDataAction(DragDataAction dragDataAction) {
        setAttribute("dragDataAction", dragDataAction.getValue(), true);
    }
    /**
     * Indicates what to do with data dragged into another DataBoundComponent. See&#010          DragDataAction type for details.
     *
     *
     * @return DragDataAction
     *
     */
    public DragDataAction getDragDataAction()  {
        return (DragDataAction) EnumUtil.getEnum(DragDataAction.values(), getAttribute("dragDataAction"));
    }

    // ********************* Methods ***********************

        /**
         * Retrieve a tile by index.  &#010 <P>&#010 The TileLayout consistently uses this method to access tiles, in order to allow subclasses&#010 to create tiles on demand.&#010&#010
         * @param index index of the tile
         *
         * @return the tile
         */
        public native Canvas getTile(int index) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var ret = self.getTile(index);
            if(ret == null || ret === undefined) return null;
            var retVal = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            if(retVal == null) {
                retVal = @com.smartgwt.client.widgets.Canvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            }
            return retVal;
        }-*/;

        /**
         * Add a tile to the layout, dynamically.&#010&#010
         * @param tile new tile to add
         */
        public native void addTile(Canvas tile) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.addTile(tile.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        }-*/;

        /**
         * Add a tile to the layout, dynamically.&#010&#010
         * @param tile new tile to add
     * @param index position where the tile should be added.  Defaults to adding the tile at the end.
         */
        public native void addTile(Canvas tile, int index) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.addTile(tile.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), index);
        }-*/;










    // ********************* Static Methods ***********************





    /**
     * List of tiles to lay out.
     *
     * @param tiles tiles Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTiles(Canvas... tiles) throws IllegalStateException {
        setAttribute("tiles", tiles, false);
    }

    /**
     * Policy for laying out tiles.  See ${isc.DocUtils.linkForRef('type:TileLayoutPolicy')} for options.
     *
     * @param layoutPolicy layoutPolicy Default value is ""
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLayoutPolicy(TileLayoutPolicy layoutPolicy) throws IllegalStateException {
        setAttribute("layoutPolicy", layoutPolicy.getValue(), false);
    }

    /**
     * Remove a tile from the layout.
     *
     * @param tileIndex index or String ID of the tile
     * @return whether a tile was found and removed
     */
    public native boolean removeTile(int tileIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return !!self.removeTile(tileIndex);
    }-*/;

    /**
     * Remove a tile from the layout.
     *
     * @param tileID index or String ID of the tile
     * @return whether a tile was found and removed
     */
    public native boolean removeTile(String tileID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return !!self.removeTile(tileID);
    }-*/;

    /**
     * Remove a tile from the layout.
     *
     * @param tile index or String ID of the tile
     * @return whether a tile was found and removed
     */
    public native boolean removeTile(Canvas tile) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var tileJS = tile.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return !!self.removeTile(tileJS);
    }-*/;

    /**
     * Forces layout out the tiles
     */
    public native void layoutTiles() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.layoutTiles();
    }-*/;

}



