
package com.smartgwt.client.docs;

/**
 * <h3>Date and Time Format and Storage</h3>
 * The Smart GWT system has the following features for handling Date and Time type values within DataSources and databound
 * components. <P> DataSources and databound components may define fields of type <code>date</code>, <code>time</code>, or
 * <code>datetime</code>. <P> Fields of type {@link com.smartgwt.client.types.FieldType date} are considered to be logical
 * Dates. System wide formatting for dates may be controlled via the  Date.setNormalDisplayFormat and 
 * Date.setShortDisplayFormat methods. <P> On the client date type fields are stored as JavaScript Date objects. When
 * formatted for display to the user, they are typically displayed without any time information. <P> When communicating
 * with a non Smart GWT server via an "xml" DataSource, date field values in requests will be serialized out as logical
 * date information only (omitting time) in the standard truncated <a target=_blank
 * href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema date format</a> - <code>YYYY-MM-DD</code>. Date values
 * received from the server in responses are expected to be in the same format, though if time information is included in
 * the returned date-string it will be understood.  This matches the default date serialization behavior for "json"
 * dataSources, though dates may also be communicated as a JavaScript date instantiation string  (EG: <code>new
 * Date(1238792738633)</code>). See {@link com.smartgwt.client.util.JSONEncoder#getDateFormat dateFormat}. <P> Fields of
 * type {@link com.smartgwt.client.types.FieldType datetime} are dates with full time information. System wide formatting
 * for datetimes may be controlled via the  Date.setShortDatetimeDisplayFormat method. Datetimes will be displayed to the
 * user in local time. (See timezone notes below). <P> On the client datetime type fields are stored as JavaScript Date
 * objects.  When communicating with a non Smart GWT server via an "xml" DataSource, datetime field values in requests will
 * be serialized out as full datetimes in UTC using the standard <a target=_blank
 * href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema date format</a> - <code>YYYY-MM-DDTHH:MM:SS</code>. Date
 * values received from the server in responses are expected to also be in XML Schema date format - and assumed to be in
 * UTC time unless an explicit timezone offset is specified on the datetime string
 * (EG:<code>2006-01-10T12:22:04-04:00</code>). As with dates, "json" format dataSources use the same XML Schema format by
 * default but may use JavaScript date instantiation strings instead. <P> Fields of type {@link
 * com.smartgwt.client.types.FieldType time} are logical time values. These are stored on the client as JavaScript date
 * objects, but only the time information is displayed to the user. Time formatting is handled by the String class APIs. By
 * default times are displayed to users in local time (see notes on timezones below). <br> When communicating with a non
 * Smart GWT server via an "xml" DataSource, time field values in requests will be serialized out as full times in UTC
 * using the standard <a target=_blank href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema date / time format</a>
 * - <code>HH:MM:SS</code>. Note that the flag {@link com.smartgwt.client.data.DataSource#serializeTimeAsDatetime
 * serializeTimeAsDatetime} may be set to serialize all times as full datetimes rather than just time strings. Time values
 * received from the server in responses are expected to be in the same format, in UTC, or with an explicit timezone offset
 * specified (for example <code>"22:01:45-01:00"</code>) <P> <b>Timezones:</b> By default date and time formatters display
 * values to the user in  local time, as derived from the native browser locale.  Developers may modify this behavior by
 * specifying an explicit display timezone via String. <br> Note that depending on the specific date being displayed, a
 * Daylight Savings Time offset may also be applied based on the browser locale. To disable this behavior set String to
 * false.<br> If a custom timezone is specified, it will be respected by all {@link
 * com.smartgwt.client.types.TimeDisplayFormat}s, and by the standard short {@link
 * com.smartgwt.client.types.DateDisplayFormat}s. However native JavaScript Date formatters,  including
 * <code>toLocaleString()</code> will not respect the specified timezone. Developers specifying a custom timezone may
 * therefore wish to modify the  Date.setNormalDisplayFormat to avoid using a native JS Date formatter function. <P> Note
 * that in addition to the system-wide date, datetime and time-formatting settings described above, databound components
 * also support applying custom display formats for date values. Typically this can be achieved via a custom
 * <code>dateFormatter</code> or <code>timeFormatter</code> at the field level (see {@link
 * com.smartgwt.client.data.DataSourceField#getDateFormatter dateFormatter},  {@link
 * com.smartgwt.client.data.DataSourceField#getTimeFormatter timeFormatter} and for example {@link
 * com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter dateFormatter}). Date formatting may also be configured
 * at the component level by setting the <code>dateFormatter</code>, <code>datetimeFormatter</code> and
 * <code>timeFormatter</code> attributes (See for example {@link com.smartgwt.client.widgets.grid.ListGrid#getDateFormatter
 * dateFormatter}, {@link com.smartgwt.client.widgets.grid.ListGrid#getTimeFormatter timeFormatter}, and {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getDatetimeFormatter datetimeFormatter}). <P> When communicating with the
 * Smart GWT server fields of type <code>date</code>, <code>datetime</code> and <code>time</code> are all automatically
 * translated to Java date objects on the server side.
 */
public interface DateFormatAndStorage {
}
