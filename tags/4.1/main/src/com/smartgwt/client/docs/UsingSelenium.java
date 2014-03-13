
package com.smartgwt.client.docs;

/**
 * <h3>Using Selenium</h3>
 * <a href='http://seleniumhq.org/' onclick="window.open('http://seleniumhq.org/');return
 * false;">Selenium</a> is a powerful and popular tool which can be used  to test your Smart GWT
 * applications.  Selenium executes tests against your running application in a browser emulating
 * user interaction  and asserting various conditions. Selenium provides a record/playback tool
 * for authoring tests without  learning a test scripting language. You must be familiar with <a
 * href='http://seleniumhq.org/' onclick="window.open('http://seleniumhq.org/');return
 * false;">Selenium</a> and use of <a href='http://seleniumhq.org/projects/ide/'
 * onclick="window.open('http://seleniumhq.org/projects/ide/');return false;">Selenium IDE</a>
 * before proceeding.  Refer to the documentation on the Selenium site. <P> Selenium supports the
 * concept of <a href='http://seleniumhq.org/docs/02_selenium_ide.html#locating-elements'
 * onclick="window.open('http://seleniumhq.org/docs/02_selenium_ide.html#locating-elements');return
 * false;">Locators</a> in order to specify the element you'd like a given Selenium command to
 * target. For example Selenium supports XPath based locators and DOM ID based locators. XPath
 * based locators are extremely fragile due to complexity of certain  highly nested DOM elements
 * you need access to combined with the fact that XPath support varies across browsers and  so
 * your tests might not work across different browsers.  <P> Use of Selenium with Smart GWT
 * applications is no different than using Selenium to write and run test cases with  any other
 * application with the exception of one caveat: Smart GWT occasionally renders a different DOM
 * structure  depending on the browser for performance or rendering the UI such that it appears
 * identical across various browsers.  As a result using DOM ID or DOM XPath based locators with
 * Smart GWT applications is not advisable.  <P> Instead Smart GWT supports a new Selenium locator
 * which is an XPath-like string used by Selenium to robustly identify  DOM elements within a
 * Smart GWT application. Smart GWT locators for Selenium are prefixed by "scLocator=" and have a 
 * readable XPath-like value even for cells in ListGrid's or TreeGrids. Typically these locators
 * will not be hand-written and  are generated by <a href='http://seleniumhq.org/projects/ide/'
 * onclick="window.open('http://seleniumhq.org/projects/ide/');return false;">Selenium IDE</a>,
 * Selenium's test recording tool. One primary locator is based on the ID of the Smart GWT widget
 * and has the syntax <b>ID=&lt;Canvas ID&gt;</b>. This simplifies the task of  writing tests if
 * you know the ID of the Canvas. For reference, the scLocator syntax for ListGrid cells and
 * DynamicForm  FormItems can be found at the end of this document. <P> <b>Setup Instructions</b>
 * <P> Smart GWT ships with two Selenium user extension Javascript files:  <P> <ul> <li>
 * user-extensions.js <li> user-entensions-ide.js </ul> <P> These extensions (found in the  
 * <code>selenium/</code> directory) augment the Selenium tools to support Smart GWT locators. To
 * integrate these extensions with Selenium,  follow the steps below: <P> <ul> <li> Confirm that
 * the Selenium IDE has been installed. <li> Copy the user extension files listed above to a
 * common location on your test client machine. <li> Open the Selenium IDE and click the Options
 * ==&gt; Options... menu item. On the General tab enter the path to these extension  files in the
 * corresponding fields: Selenium Core extensions and Selenium IDE extensions. Refer to the
 * Selenium Documention  on <a
 * href='http://seleniumhq.org/docs/08_user_extensions.html#using-user-extensions-with-selenium-ide'
 * onclick="window.open('http://seleniumhq.org/docs/08_user_extensions.html#using-user-extensions-with-selenium-ide');return
 * false;">user extensions</a>  for more information. <li> Close and restart Selenium IDE to load
 * the new extensions. </ul> <P> That's it, we're done configuring the environment. <P> Note:
 * Tests recorded using Selenium IDE can be played back using <a
 * href='http://seleniumhq.org/projects/remote-control/'
 * onclick="window.open('http://seleniumhq.org/projects/remote-control/');return false;">Selenium
 * Remote Control</a>. The <code>user-extensions-ide.js</code> file is not required for playback
 * of Smart GWT-aware tests using Selenium RC, but the  <code>user-extensions.js</code> is.
 * Instructions for using <code>user-extensions.js</code> with Selenium RC can be found  <a
 * href='http://seleniumhq.org/docs/08_user_extensions.html#using-user-extensions-with-selenium-rc'
 * onclick="window.open('http://seleniumhq.org/docs/08_user_extensions.html#using-user-extensions-with-selenium-rc');return
 * false;">here</a>. <P> <b>Recording Selenium tests with Selenium IDE</b> <P> Once you have your
 * application running in Firefox, open Selenium IDE from the Tools ==&gt; Selenium IDE menu
 * option. If the Selenium IDE is in record mode, then clicking or carrying out other operations
 * like typing in a text field with automatically record the  appropriate Selenium commands with
 * the Smart GWT locator. In most cases there's no need for you to manually enter the locator, 
 * the recorder does this for you! In fact, not only do the provided user extension files record
 * your clicks, drag operations, and  typing in the browser--they also try to ensure that your
 * script executes each operaton only when the Smart GWT widgets it depends  upon exist and are
 * ready to be interacted with.  This ensures that when the test script is executed, then even if
 * one or more triggered  operations are asynchronous (delayed), it behaves as expected. <P> In
 * the screenshot below, note the <b>waitForElementClickable()</b> operation above the click
 * operation; it was added automatically by our  user extensions as the click itself was recorded:
 * <P> <img src="skin/user-guide-images-selenium/selenium-ide-example.png" width="1017px"
 * height="853px"> <P> Sometimes users may also want finer grain control of what Selenium command
 * is created instead of having the Selenium IDE recorder  do this automatically. For example if
 * you want to verify the value of a particular cell in a ListGrid. Instead of typing in the 
 * command "verifyTable" and manually enter the Smart GWT Locator (scLocator), you can simply
 * right click on the table cell or any  other Smart GWT widget and the most suitable Selenium
 * commands will appear in the context menu along with the scLocator path for  the clicked
 * element. See image below. <P> <img
 * src="skin/user-guide-images-selenium/selenium-ide-example-verifyText.png" width="1211px"
 * height="737px"> <P> <b>Solving Ordering Issues in Selenium Scripts</b> <P> Fundamentally, the
 * reason we add <b>waitForElementClickable()</b> calls before each click is to deal with
 * asynchronous Smart GWT operations. Many operations on widgets or the network are asynchronous,
 * and a correctly coded test should wait for such operations to  complete as opposed to inserting
 * an arbitrary delay or using Selenium's <b>setSpeed()</b> function. Using such delays runs the
 * risk of  the test failing if replay occurs on a loaded machine or slow network, and also makes
 * the test run slower than needed.  <P> Asynchronous operations include: <P> <ul> <li> any actual
 * network operation, <li> any DataSource operation (even for a clientOnly DataSource), <li> any
 * situation where a widget can be marked "dirty" (see notes at <b>Canvas.isDirty()</b>), and then
 * asynchronously  redraw itself - this includes API calls like <b>ListGrid.setData()</b>,
 * <b>Canvas.setContents()</b> as well as user interactions like  ListGrid sort or filter,
 * regardless of whether the data is already present, <li> re-layout that occurs as a result of a
 * size change or new member being added to a Layout or subclass of Layout (eg SectionStack,
 * Window) </ul> <P> The following operations are synchronous and don't require waiting: <P> <ul>
 * <li>draw()ing any widget that has no parent - but note adding a widget to an already-drawn
 * Layout is asynchronous, as above </ul> <P> You may encounter cases where you have to manually
 * insert a <b>waitForElementClickable()</b> or <b>waitForElementNotPresent()</b> to get a script
 * to behave properly.  Looking at the Smart GWT Showcase Example (Grids / Filtering / Advanced
 * Filter), suppose  we wanted to filter by country names containing "Za" and wait for the filter
 * step to complete before proceeding.  Since the  ListGrid initially contains many entries and
 * Zaire is not among them, it is not visible and thus we can solve the original  problem by
 * manually adding a <b>waitForElementClickable()</b> on the locator for Zaire's ListGrid entry:
 * <P>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>scLocator=//ListGrid[ID="filterGrid"]/body/row[pk=216||countryCode=CG||215]/col[fieldName=countryCode||0]</b>
 * <P> Before the filter operation is issued, the locator is not clickable because the record is
 * not visible: <P> <img src="skin/user-guide-images-selenium/manual-wait-clickable-before.png"
 * width="767px" height="327px"> <P> When the filter operation completes, Zaire and the other
 * search results become visible and the <b>waitForElementClickable()</b>  returns successfully
 * allowing the next script command to execute: <P> <img
 * src="skin/user-guide-images-selenium/manual-wait-clickable-after.png" width="763px"
 * height="328px"> <P> Finally, suppose you wanted to do another filter operation to look only at
 * countries (from the previous search results) with  populations under 30 million.   Since Zaire
 * is above this limit, it will be missing from the search results and you could  wait for the
 * filter operation to complete by adding a <b>waitForElementNotPresent()</b> on same locator that
 * we previously used  for <b>waitForElementClickable()</b>. It will return true and allow the
 * script to proceed when the filter operation completes: <P> <img
 * src="skin/user-guide-images-selenium/manual-wait-not-present.png" width="762px" height="317px">
 * <P> <b>Waiting on Pending ListGrid Operations</b> <P> There are cases where
 * <b>waitForElementClickable()/waitForElementNotPresent()</b> will not work--for example if
 * you're performing  a sort that's rearranging existing elements on the screen, or if you're
 * performing a filter operation where you're not sure of the results and thus cannot use the
 * approach from the previous section.  In such a situation, you may need to add a 
 * <b>waitForGridDone()</b> command into your script to ensure the pending operations are complete
 * before you hit the next command. <P> The <b>waitForGridDone()</b> command guarantees it will
 * not complete successfully unless all of the following potential pending  operations on the
 * widget are complete: <P> <ul> <li> any fetch or filter operation (the result of applying
 * criteria), <li> any sort operation (the result of apply sort specifiers), <li> the flush of
 * pending FilterEditor criteria to the parent ListGrid, and <li> the saving of any newly edited
 * rows. </ul> <P> This command should be able to block a Selenium script until the ListGrid
 * specified in the locator reaches a stable drawn state with  no pending activity.  So for a
 * ListGrid names 'filterGrid', all you'd need to add to ensure all pending operations on it have
 * completed is the command: <P>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>waitForGridDone("//ListGrid[ID='filterGrid']");</b> <P> <P>
 * <b>Waiting on All Pending Network Operations</b> <P> Because of the
 * <b>waitForElementClickable</b> commands which are automatically inserted during recording, your
 * scripts will automatically wait for the completion of any network operations that block
 * interactivity (via showPrompt, which is enabled by  default). However in some cases you may
 * want to wait for all pending network operations to complete, even if they don't block user
 * interactivity. <P> To do this, use <b>RPCManager.requestsArePending()</b> in combination with
 * <b>waitForCondition()</b>. So, the JavaScript in your <b>waitForCondition()</b> operation would
 * be: <P>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>!selenium.browserbot.getCurrentWindow().isc.RPCManager.requestsArePending()</b>
 * <P> When the call returns, you'd know that any previously initiated network operations--such as
 * filter/sort operations on DataSources--are  complete. <P> <b>Automatically Waiting on All
 * Pending Network Operations</b> <P> If you need the functionality from the section above to wait
 * on all pending network operations, but don't want to add extra calls to
 * <b>waitForCondition()</b>, you may switch on automatic enforcement of the condition that
 * <b>isc.RPCManager.requestsArePending()</b> is false.  There are two ways to do this: <P> <ul>
 * <li> Set the property <b>isc.AutoTest.implicitNetworkWait</b> to true on the page under test
 * after the ISC modules are loaded, or <li> Add the Selenium command
 * <b>setImplicitNetworkWait(true)</b> to your selenium script in Selenium IDE. </ul> <P> Like
 * other Selenium IDE commands with a single argument, you'll want to use
 * <b>setImplicitNetworkWait()</b> by passing <b>true</b> (or <b>false</b>) in the Target field of
 * the Selenium IDE GUI (right under command). Without any modifications, the default value  for
 * <b>isc.AutoTest.implicitNetworkWait</b> of <b>false</b> will prevail. <P> <b>Capturing Logs</b>
 * <P> Capturing of client and server-side logs can be switched on by providing appropriate
 * options to {@link com.smartgwt.client.docs.TestRunner}, but a few Selenium commands are
 * provided to provide direct control over logging on a per-script basis.  If server logging has
 * been configured as "some," then server logs won't be captured for a given script unless you add
 * the captureServerLogs() Selenium command after the open command; switching the mode to "all"
 * will force server logs to be collected for all Selenium scripts, and no captureServerLogs()
 * command is then required. <P> To configure logging levels, you can use the commands
 * <b>setClientLogLevel(category, level)</b>, or <b>setServerLogLevel(category, level)</b>.  For
 * example: <ul> <li><b>setClientLogLevel("AutoTest","ERROR")</b>, or
 * <li><b>setServerLogLevel("com.isomorphic.rpc.RPCManager", "INFO")</b> </ul> Note that when
 * entering the above examples into Selenium IDE, you need neither parentheses nor quotes, as
 * everything is considered a string and there are fixed slots for each. <P> <b>Disabling the
 * Selenium Smart GWT URL Query String</b> <P> By default, our user extensions automatically add a
 * special URL variable, <b>sc_selenium</b>, to open command urls to allow  JavaScript to detect
 * it's being driven by Selenium in case special logic should be used.  In the unlikely event that
 * this causes a  problem with your code or page loading and you don't need the feature, you may
 * eliminate this special URL variable by changing
 * <b>Selenium.prototype.use_url_query_sc_selenium</b> from <b>true</b> to <b>false</b> in
 * user-extensions.js. <P> <hr> <P> <b><u>Common scLocator syntax</u></b> <P> For more information
 * on how locators are formed and how to influence them, see the {@link
 * com.smartgwt.client.util.AutoTest AutoTest} class in  the Smart GWT JavaDoc.  <P> <b><u>List
 * Grid cells</u></b> <P> <b>//ListGrid[ID="itemList"]/body/row[itemID=1996||itemName=Sugar White
 * 1KG||SKU=85201400||1]/col[fieldName=SKU||1]</b> <P> <ul> <li> This assumes the ListGrid has an
 * explicit ID <li> the 'body' part might be 'frozenBody' if the field in question was frozen <li>
 * row[......] identifies the row (record) <li> itemID= - that's the primary key field from the
 * dataSource the grid is bound to <li> itemName= - that's the title field value for the record
 * <li> SKU=... - that's the cell the user clicked's value <li> 1 - that's the index of the row
 * (rowNum) <li> col[.....] - identifies the column in the grid <li> fieldName=... - field name
 * for the field the user clicked <li> 1 - that's the index of the column </ul> <P> <b><u>Form
 * Items</u></b> <P>
 * <b>//DynamicForm[ID="autoTestForm"]/item[name=textField||title=textField||value=test||index=0||Class=TextItem]/element</b>
 * <P> This example is the data element (text entry box) for a text field  <P> <ul> <li> this form
 * has an explicit ID <li> item[...] identifies the item <li> name (field name, if set) <li> title
 * (title, if set) <li> value (current value if set) <li> index (index in the form items array)
 * <li> Class (SC class of the item - in this case TextItem) after the "/" we identify the part of
 * the item in question options here include: <li> "element" - the data element <li> "canvas" -
 * for CanvasItems - points to the canvas embedded in the item <li> in this case the xpath might
 * continue to contain, for example children of the canvas or elements within it (cells in a
 * listGrid, etc) <li> "textbox" - the "text box" - this is the area where content is written out
 * for items without a 'data element' - like header items <li> "[icon=&lt;...&gt;]" - the icon
 * element -- "&lt;...&gt;" would contain the "name" of the icon </ul> <P> <hr> <P> <b><u>Best
 * Practices</u></b> <P> <ul> <li> <b>Maximize the test browser window to avoid offscreen
 * widgets</b>: Some browsers will not respond to events on widgets  that are not visible in the
 * browser pane (scrolled out of view or clipped off). To avoid having to manually add script
 * commands to  scroll such widgets into view, it's recommended to use Selenium's
 * <b>windowMaximize()</b> command which will force the browser to  occupy the entire screen. <P>
 * Note that currently some browsers will respond to events on offscreen widgets (IE will, Firefox
 * will not) however, web standards  are unclear on whether this should be allowed and the
 * behavior may change in the future, so best practice is to maximize for all  browsers. <P> <li>
 * <b>Use setID() judiciously to ensure stable locators run-to-run</b>: When setID() is not used
 * to supply a unique component ID, locators will sometimes incorporate automatically generated
 * IDs which have a sequence number (eg isc_Object_355). If your test  has unpredictable execution
 * order (for example, two simultaneous network operations take place and either may complete
 * first,  and both generate UI components on completion) then these IDs will not be stable from
 * run-to-run. They will likewise not be stable  if you test part of an app and then embed it in a
 * larger app and try to use the same script. <P> Use setID() selectively to avoid this problem.
 * Generally, it makes sense to use setID() on all top-level (parentless) widgets - at  this
 * point, locators for children that do not have a unique ID will be based on the parent's ID plus
 * a relative path. This relative  path will not incorporate auto-generated IDs and will generally
 * continue to work even if the interior layout of the parent is  significantly rearranged (such
 * as adding a new intervening container widget). </ul> <P> <hr> <P> <b><u>Known
 * Limitations</u></b> <ul> <li> Selenium intermittently fails to generate an scLocator with the
 * "type" command on some FormItems. If this occurs, you can  manually enter an scLocator into the
 * target field, or use the drop down to select an alternative locator strategy (such as locating 
 * a text input element by name). <li> Support for multi-select for SelectItems with selection
 * mode "grid" (non-default) </ul> <P>
 */
public interface UsingSelenium {
}
