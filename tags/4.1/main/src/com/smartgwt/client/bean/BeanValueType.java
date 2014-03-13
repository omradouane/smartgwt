/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.bean;

import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.bean.types.*;
import com.smartgwt.client.types.ValueEnum;
import com.smartgwt.client.util.JSOHelper;

import com.smartgwt.client.core.BaseClass;
import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.core.Function;
import com.smartgwt.client.core.RefDataClass;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.data.RelativeDate;
import com.smartgwt.client.data.ResultSet;
import com.smartgwt.client.types.ValueEnum;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.BaseWidget;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// This is a superclass for generated classes that help deal with the value
// types used by BeanFactories ... that is, the types of the parameters which
// the setters take (as opposed to the types of the BeanFactories themselves).
//
// There are quite a few tasks which we need help with. Generally, these are
// things you would normally implement in Java with reflection, but the
// reflection capabilities in GWT are limited (for various reasons).
//
// 1. We need to do conversion from JavaScriptObjects supplied from the
// SmartClient side to Java-oriented objects. The routines in JSOHelper are
// close to what we need, but require some adaptation. (Note that this is now
// mostly implemented in BeanFactory -- see the comments there).
//
// 2. We need to do conversion from Java-oriented objects to JavaScriptObjects
// to supply back to SmartClient, or to set on config blocks. Again, the
// routines in JSOHelper are close, but require some adaptation.
//
// 3. We need to be able to detect whether a supplied value is assignable to
// the parameter type (for a setter). This is partly because we are ultimately
// calling the setters via JSNI function pointers, so we need to check type
// compatibility ourselves (rather than catching cast exceptions).
//
// 4. We need to be able to choose the best setter for a supplied value, where
// multiple setters are available that deal with different types.
//
// In some cases, achieving these tasks requires generating a subclass -- in
// other cases, we can write the subclass in advance. Generated subclasses are
// required in these cases:
//
// 1. When a method signature is an interface, GWT doesn't provide a way at
// run-time to know whether an arbtirary object implements that interface if
// all we have is the Class object (since Class.isAssignableFrom is not
// available, and instanceof requires the class literal). We can construct a
// partial implementation of isAssignableFrom using getSuperclass, but that
// doesn't help when it comes to interfaces. So, we need to generate a subclass
// for any interface used as a parameter type.
//
// 2. In some cases, we can construct the parameter from a JavaScriptObject.
// For instance, we can construct a Canvas from a SmartClient JSO.  In those
// cases, we need a generated newInstance function.
//
// 3. When parameters are arrays, we need to be able to do various things that
// require a generated subclass.
//
// The generation of subclasses is handled by com.smartgwt.rebind.BeanValueType,
// in conjunction with com.smartgwt.rebind.BeanClass.
//
// Finally, we provide routines that will convert a supplied Object to the
// BeanValueType, if possible. That way, we don't have to ensure that the
// provided type exactly matches the parameter type -- we can perform a variety
// of logical conversions.


/**
 * Class with static methods that help with various reflection-like tasks with
 * respect to values used by {@link BeanFactory BeanFactories} (that is, the
 * return types of getters, and the parameter types of setters).
 *
 * <p>The primary interface is through the static methods. In some cases,
 * generated subclasses are required in order to work around GWT's limited
 * reflection capabilities. Those classes are automatically generated by the by
 * the <code>BeanFactory</code> generator when necessary. If you want to use
 * <code>BeanValueType</code> outside of <code>BeanFactory</code>, then you'll
 * need to use the {@link BeanValueType.MetaFactory} interface to register
 * types.
 */
public abstract class BeanValueType<ValueType> {
    // The ValueType is the actual type required by the getter or setter.  If
    // the ValueType would be primitive, then it is the equivalent boxed type
    // instead, since you can't use primitive types in generics. 
    
    /**
    * Interface used to trigger the generation and registration of
    * reflection metadata for argument types.
    *
    * <p>In order to use {@link BeanValueType} to convert values to a type, you
    * need to create the correct kind of <code>BeanValueType</code> for each
    * type, which sometimes involves code generation.  This is all automatic
    * for types required by {@link BeanFactory}. However, if want to use
    * <code>BeanValueType</code> outside of <code>BeanFactory</code>, then you
    * can use <code>BeanValueType.MetaFactory</code> for specific types.
    * 
    * <p>Usage is most easily explained with an example. First, you define an
    * interface. (Note that it can be an inner interface.)
    *
    * <blockquote><pre>
    * public interface MyMetaFactory extends BeanValueType.MetaFactory {
    *     BeanValueType&lt;Integer[]&gt; getIntegerArrayValueType();
    *     BeanValueType&lt;Canvas&gt; findMeTheCanvasValueType();
    * }</pre></blockquote>
    *
    * ... and then you trigger the generation process:
    *
    * <blockquote><pre>
    * GWT.create(MyMetaFactory.class);</pre></blockquote>
    *
    * <p>Each function in the interface you define will result in the creation
    * of the <code>BeanValueType</code> for one type ... so, in this case, we
    * would end up with <code>BeanValueTypes</code> for Integer arrays and
    * Canvas. The rules are as follows:
    *
    * <ol>
    * <li>The interface must extend <code>BeanValueType.MetaFactory</code></li>
    * <li>The return type for each function must be <code>BeanValueType</code>,
    * with a generic type that is the type you want to be able to convert to.</li>
    * <li>The function must take no arguments.</li>
    * <li>The name of the function doesn't matter.</li>
    * </ol>
    *
    * <p>If you want, you can keep a reference to the results of the <code>GWT.create()</code>,
    * and call the functions:
    * 
    * <blockquote><pre>
    * MyMetaFactory metaFactory = GWT.create(MyMetaFactory.class);
    * BeanValueType&lt;Integer[]&gt; integerArrayType = myMetaFactory.getIntegerArrayValueType();
    * Integer[] intArray = integerArrayType.convertFrom(new String[] {"7", "8"});</pre></blockquote>
    *
    * <p>However, you don't have to do that ... you can ignore the results of
    * <code>GWT.create()</code> and just use the {@link BeanValueType} static
    * API:
    *
    * <blockquote><pre>
    * GWT.create(MyMetaFactory.class);
    * Integer[] intArray = BeanValueType.convertFrom(Integer[].class, new String[] {"7", "8"});</pre></blockquote>
    *
    * <p>Note that the call to <code>GWT.create()</code> must occur at run-time
    * before the types are used. However, you can modularize by creating some
    * types first and others later, as long as each <code>BeanValueType</code>
    * is created before being used.
    *
    * <p>If you just need to convert to basic types -- int, long, float,
    * double, boolean, Integer, Long, Float, Double, Boolean and String, then
    * you can call {@link BeanValueType#registerBasicValueTypes()} instead of
    * using <code>GWT.create()</code>. 
    */
    public static interface MetaFactory {
        // See com.smartgwt.client.BeanFactory.MetaFactory for comments on this approach
        // to triggering GWT.create()

    }

    /**
    * An enum used to indicate how well a BeanValueType can handle a
    * conversion. 
    *
    * Used to choose among multiple getters or setters, if available.
    */
    public enum Convertability {
        // Note that the order is important, because we are comparing based on the
        // ordinalValue()
        
        /**
         * The value cannot be converted to the type.
         */
        UNSUPPORTED,

        /** 
         * The value can be converted to the type, but other types might handle it better..
         */
        SUPPORTED,

        /** 
         * The value can be converted to the type, and this type is preferrable to others.
         */
        PREFERRED,

        /** 
         * The value is of this type, so conversion is exact.
         */
        EXACT
    }
    
    // -------------------------
    // Static Methods and Fields
    // -------------------------

    // Our cache for the generated subclass objects.
    private static Map<Class, BeanValueType<?>> beanValueTypes = new HashMap<Class, BeanValueType<?>>();

    // The BeanMethods look up their BeanValueType in the cache, based on their
    // valueType. Note that I can't equate the two <?>'s, because the primitive
    // value types have BeanValueTypes with a boxed ValueType.
    public static BeanValueType<?> getBeanValueType (Class<?> valueType) {
        return beanValueTypes.get(valueType);
    }

    // Each subclass of BeanValueType has a static registerValueType method.
    // The BeanFactory generator will take note of which BeanValueTypes
    // actually get used, and make sure that each of them is registered.  That
    // way, we avoid referring to code that might otherwise be dead code.  The
    // registerValueType methods will be called multiple times as various
    // BeanFactories initialize themselves. This is largely unaviodable, since
    // we don't have a panoptic view of all the BeanFactories that are going to
    // be generated at generation time -- thus, each generated BeanFactory has
    // to be complete in itself. However, we do have the registerValueType
    // methods check to see whether the valueType is already registered, so
    // that we don't construct a BeanValueType for the same valueType over and
    // over again.
    protected static void registerBeanValueType (BeanValueType beanValueType) {
        beanValueTypes.put(beanValueType.getValueType(), beanValueType);
    }

    /**
     * Registers <code>BeanValueTypes</code> for boolean, double, float, long, Boolean,
     * Double, Float, Long, Number, and String.
     *
     * <p>This is not automatic in order to allow for more dead-code elimination
     * if not being used. 
     *
     * <p>If you need <code>BeanValueTypes</code> for other types, you can register
     * them via the {@link BeanValueType.MetaFactory} interface.
     */
    public static void registerBasicValueTypes () {
        // Note that they will also register their primitive equivalents
        BooleanValueType.registerValueType();
        DoubleValueType.registerValueType();
        FloatValueType.registerValueType();
        LongValueType.registerValueType();
        IntegerValueType.registerValueType();

        NumberValueType.registerValueType();
        StringValueType.registerValueType();
    }
 
    // Convenience method to create exception object
    private static IllegalArgumentException noBeanValueTypeException (Class<?> klass) {
        return new IllegalArgumentException("No BeanValueType subclass has been generated for " + klass.getName());
    }

    /**
     * Can the value be assigned to the class? Or, to put it another way,
     * would <code>value instanceof Klass</code> return true (if we had
     * the class literal to work with)?
     *
     * @param klass The Class to be assigned to.
     * @param value The value to be assigned
     * @throws IllegalArgumentException If the Class represents an interface, 
     *                                  and no BeanValueType subclass has been 
     *                                  generated to handle it.
     */
    public static boolean isAssignableFrom (Class<?> klass, Object value) {
        // null can be assigned to anything
        if (value == null) return true;

        BeanValueType beanValueType = getBeanValueType(klass);
        if (beanValueType == null) {
            if (klass.isInterface()) {
                // If it's an interface, then our only hope is to use the
                // generated subclass. So, throw an exception if we can't find
                // one.
                throw noBeanValueTypeException(klass);
            } else {
                // If it's not an interface, then we don't need a subclass ...
                // we can use the class objects.
                return isAssignableFrom(klass, value.getClass());
            }
        } else {
            // If we have a subclass, just ask it.
            return beanValueType.isAssignableFrom(value);
        }
    }

    /**
     * Can objects of the possible sub-class be assigned to the possible super-class?
     * 
     * <p>Like <code>Class.assignableFrom()</code>.
     *
     * @param possibleSuperclass The possible super-class, or lhs of the assignment
     * @param possibleSubclass The possible sub-class, or rhs of the assignment
     * @throws IllegalArgumentException If one of the classes is an interface and the
     *                                  other is not. In that case, you need to use
     *                                  {@link #isAssignableFrom(Class<?>, Object)} with
     *                                  the value to be assigned.
     */
    public static boolean isAssignableFrom (Class<?> possibleSuperclass, Class<?> possibleSubclass) {
        // Method overloading gets confused with null, since null doesn't
        // really have a type.  We do get called with a null, when we really
        // want the other overloaded method. So, call it in that case.
        if (possibleSubclass == null) {
            return isAssignableFrom(possibleSuperclass, (Object) null);
        }

        // This method only works if both sides are interfaces, or neither side
        // is an interface. If only one side is an interface, then we can't
        // just walk the class hierarchy -- in fact, there is seemingly no way
        // to figure out whether a Class implements an Interface in GWT in the
        // abstract, aside from calling instanceof on a value.
        //
        // (In principle, we could, when generating the BeanValueType subclass
        // for the interface, generate a list of all classes which implement
        // the interface, and then use that to test with here. However, one
        // would have to check what effect that would have on dead code pruning
        // -- it would be unfortunate if that prevented otherwise dead code
        // from being pruned).
        if (possibleSuperclass.isInterface() != possibleSubclass.isInterface()) {
            throw new IllegalArgumentException(
                "Cannot use BeanValueType.isAssignableFrom(Class, Class) with interfaces, " +
                "unless both classes are interfaces. Use isAssignableFrom(Class, Object) instead."
            );
        }

        // While covariant, arrays don't have each other as supertypes ... the
        // supertype is always Object. So, we need to adopt a different
        // strategy.
        if (possibleSuperclass.isArray()) {           
            // If they are equal, we can quickly return true
            if (possibleSuperclass == possibleSubclass) return true;

            // If the possibleSubclass is not an array, then clearly false
            if (!possibleSubclass.isArray()) return false;

            // Otherwise, we need to check the component types
            return isAssignableFrom(possibleSuperclass.getComponentType(), possibleSubclass.getComponentType());
        }

        // Otherwise, we can iterate through getSuperclass and see what we
        // find.
        Class<?> iterator = possibleSubclass;
        while (iterator != null) {
            if (iterator == possibleSuperclass) return true;
            iterator = iterator.getSuperclass();
        }

        return false;
    }

    /**
     * Is the SmartClient object an instance (or subclass) of the SmartClient class?
     *
     * @param value The SmartClient object
     * @param scClassName The SmartClient class name (e.g. "ListGrid")
     */
    public static native boolean isA (JavaScriptObject value, String scClassName) /*-{
        if (!value) return false;
        if (!scClassName) return false;

        // Make sure the relevant isA function exists ...
        if ($wnd.isc.isA[scClassName]) {
            // Explicitly return true or false to avoid type problems
            return $wnd.isc.isA[scClassName](value) ? true : false;
        } else {
            return false;
        }
    }-*/;

    
    /**
     * Performs basic conversion from a JavaScriptObject to an equivalent Java
     * value, without taking into account any particularly desired Java types.
     *
     * <p>This is similar to {@link
     * com.smartgwt.client.util.JSOHelper#convertToJava(JavaScriptObject,boolean)
     * JSOHelper.convertToJava}, but has several differences which are needed
     * for {@link BeanFactory} to work properly. 
     *
     * Note that this method may return a {@link JavaScriptObject} -- either
     * the value itself, or possibly a new <code>JavaScriptObject</code>
     * constructed from a config block. In those cases, it may be that {@link
     * #convertFrom(Class,Object) convertFrom()} can still do some <i>further</i>
     * conversion on the return value, since it can take into account
     * opportunities for conversion that are specific to the desired type. In
     * other words, this is a <i>generic</i> conversion function.
     *
     * @param object A javascript value
     * @return A generic conversion to an <code>Object</code> (which may still be
     *         a <code>JavaScriptObject</code>).
     */
    public static native Object convertToJava (JavaScriptObject obj) /*-{
        // This is actually defined in the SGWTModule exported by BeanFactory,
        // because we need to be able to call it from there without hitting the
        // development-mode JSNI glue code first -- see the comments there.

        var sgwtModule = @com.smartgwt.client.bean.BeanFactory::getSGWTModule()();
        return sgwtModule.convertToJava(obj);
    }-*/;
    
    /**
     * How well could {@link #convertFrom(Class, Object) convertFrom} convert the value to the klass?
     *
     * <p>This is used to choose the best setter amongst multiple setters, if there are multiple setters
     * available.
     *
     * @param klass The desired class to convert to.
     * @param value The value to be converted.
     * @return A constant indicating how well the conversion could be performed.
     * @throws IllegalArgumentException If there is no BeanValueType subclass for the klass
     */
    public static Convertability convertabilityFrom (Class<?> klass, Object value) {
        BeanValueType beanValueType = getBeanValueType(klass);
        if (beanValueType == null) {
            throw noBeanValueTypeException(klass);
        } else {
            return beanValueType.convertabilityFrom(value);
        }
    }

    /**
     * Convert the value into an object of the class.
     *
     * <p>Note that not all conversions are actually supported ... you can check
     * with {@link #convertabilityFrom(Class,Object) convertabilityFrom()}. The target classes which are
     * supported are generally the classes which are used as value types in
     * properties of BeanFactories that have been generated. The values supported
     * depend on the target class.
     *
     * @param klass The class that you want to convert to.
     * @param value The value that you want to convert.
     * @return The converted value.
     * @throws IllegalArgumentException If there is no BeanValueType subclass for the klass,
     *                                  or if the BeanValueType is unable to convert the value.
     */
    public static Object convertFrom (Class<?> klass, Object value) {
        BeanValueType beanValueType = getBeanValueType(klass);
        if (beanValueType == null) {
            throw noBeanValueTypeException(klass);
        } else {
            return beanValueType.convertFrom(value);
        } 
    }
    
    // Note that we could add more convertTo... and convertabilityTo...
    // methods, depending on what we need. But String is the only obvious need.
    
    public static Convertability convertabilityToString (Class<?> klass) {
        BeanValueType beanValueType = getBeanValueType(klass);
        if (beanValueType == null) {
            // It's always at least supported, in the sense that we can always call toString()
            return Convertability.SUPPORTED;
        } else {
            return beanValueType.convertabilityToString();
        }
    }

    /**
     * Converts the value to a string.
     *
     * <p>Of course, you can always call {@link Object#toString()}. However, a
     * BeanValueType subclass might implement a different strategy.
     *
     * @param value The value to convert.
     * @return A string representing the value.
     */
    @SuppressWarnings("unchecked")
    public static String convertToString (Object value) {
        if (value == null) return null;
        
        BeanValueType beanValueType = getBeanValueType(value.getClass());
        if (beanValueType == null) {
            return value.toString();
        } else {
            // doConvertToString takes a ValueType, but that should be correct
            // since we got the correct beanValueType
            return beanValueType.doConvertToString(value);
        }
    }

    /**
     * Converts the value to a JavaScriptObject, and wraps it in a JavaScript array.
     * The wrapping avoids problems with declaring a return type for generic
     * Javascript values. The array is always a JavaScriptObject. If the
     * converted value were returned directly, then in development mode it
     * could be auto-converted back to a {@link java.lang.String}, or a
     * primitive numeric type, causing type errors no matter how the return
     * value is declared here.
     * 
     * @param value Value to convert
     * @return A JavaScriptObject wrapped in a Javascript array
     */
    public static JavaScriptObject wrapInJavascriptArray (Object value) {
        return convertToJavaScriptArray(new Object[] {value});
    }

    // We used to use JSOHelper.convertToJavaScriptArray here, but the
    // JSOHelper version does some things that don't work well in this context.
    // For instance, it converts Trees to multi-level Arrays, which is sensible
    // for many purposes, but we need to be able to round-trip from SC Tree ->
    // SGWT Tree -> SC Tree.
    public static JavaScriptObject convertToJavaScriptArray (Object[] array) {
        JavaScriptObject jsArray = JSOHelper.createJavaScriptArray();

        for (int i = 0; i < array.length; i++) {
            Object val = array[i];

            if (val == null) {
                JSOHelper.setArrayValue(jsArray, i, (JavaScriptObject) val);
            } else if (val instanceof String || val instanceof Character) {
                JSOHelper.setArrayValue(jsArray, i, val.toString());
            } else if (val instanceof Number) {
                if (val instanceof Long) {
                    JSOHelper.setArrayValue(jsArray, i, ((Long) val).longValue());
                } else {
                    JSOHelper.setArrayValue(jsArray, i, JSOHelper.doubleValue((Number) val));
                }
            } else if (val instanceof Boolean) {
                JSOHelper.setArrayValue(jsArray, i, ((Boolean) val).booleanValue());
            } else if (val instanceof Date) {
                JSOHelper.setArrayValue(jsArray, i, (Date) val);
            } else if (val instanceof ValueEnum) {
                JSOHelper.setArrayValue(jsArray, i, ((ValueEnum) val).getValue());
            } else if (val instanceof JavaScriptObject) {
                JSOHelper.setArrayValue(jsArray, i, (JavaScriptObject) val);
            } else if (val instanceof DataClass) {
                JSOHelper.setArrayValue(jsArray, i, ((DataClass) val).getJsObj());
            } else if (val instanceof BaseClass) {
                JSOHelper.setArrayValue(jsArray, i, ((BaseClass) val).getOrCreateJsObj());
            } else if (val instanceof BaseWidget) {
                JSOHelper.setArrayValue(jsArray, i, ((BaseWidget) val).getOrCreateJsObj());
            } else if (val instanceof Record) {
                JSOHelper.setArrayValue(jsArray, i, ((Record) val).getJsObj());
            } else if (val.getClass().isArray()) {
                if (val instanceof Object[]) {
                    // Recurse into our own version, rather than JSOHelper
                    JSOHelper.setArrayValue(jsArray, i, convertToJavaScriptArray((Object[]) val));
                } else if (val instanceof int[]) {
                    JSOHelper.setArrayValue(jsArray, i, JSOHelper.convertToJavaScriptArray((int[]) val));
                } else if (val instanceof double[]) {
                    JSOHelper.setArrayValue(jsArray, i, JSOHelper.convertToJavaScriptArray((double[]) val));
                } else if (val instanceof float[]) {
                    JSOHelper.setArrayValue(jsArray, i, JSOHelper.convertToJavaScriptArray((float[]) val));
                } else if (val instanceof boolean[]) {
                    JSOHelper.setArrayValue(jsArray, i, JSOHelper.convertToJavaScriptArray((boolean[]) val));
                } else if (val instanceof char[]) {
                    JSOHelper.setArrayValue(jsArray, i, JSOHelper.convertToJavaScriptArray((char[]) val));
                } else if (val instanceof byte[]) {
                    JSOHelper.setArrayValue(jsArray, i, JSOHelper.convertToJavaScriptArray((byte[]) val));
                } else if (val instanceof short[]) {
                    JSOHelper.setArrayValue(jsArray, i, JSOHelper.convertToJavaScriptArray((short[]) val));
                } else if (val instanceof long[]) {
                    JSOHelper.setArrayValue(jsArray, i, JSOHelper.convertToJavaScriptArray((long[]) val));
                } else {
                    assert false : val.getClass() + " should not be an array class.";
                    JSOHelper.setArrayValue(jsArray, i, (JavaScriptObject) null);
                }
            } else if (val instanceof List) {
                // Recurse into our own version of convertToJavaScriptArray (and below)
                JSOHelper.setArrayValue(jsArray, i, convertToJavaScriptArray(((List<?>) val).toArray()));
            } else if (val instanceof Iterator) {
            	List listVal = new ArrayList();
            	while (((Iterator) val).hasNext()) listVal.add(((Iterator) val).next());            	
            	JSOHelper.setArrayValue(jsArray, i, convertToJavaScriptArray(((List<?>) listVal).toArray()));
            } else if (val instanceof Set) {
                JSOHelper.setArrayValue(jsArray, i, convertToJavaScriptArray(((Set<?>) val).toArray()));
            } else if (val instanceof Map) {
                // Use our own version of convertMapToJavascriptObject
                JSOHelper.setArrayValue(jsArray, i, convertMapToJavascriptObject((Map) val));
            } else {
                throw new IllegalArgumentException(
                    "Could not convert from " + 
                    (val == null ? "null" : val.getClass().getName()) + 
                    " to JavaScriptObject"
                );
            }
        }

        return jsArray; 
    }
   
    // We used to rely on JSOHelper.convertMapToJavascriptObject, but we need
    // to make it use our convertToJavaScriptArray, among other small differences.
    public static JavaScriptObject convertMapToJavascriptObject (Map valueMap) {
        if (valueMap == null) return null;
        JavaScriptObject valueJS = JSOHelper.createObject();

        for (Iterator iterator = valueMap.keySet().iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();

            if (key == null) {
                SC.logWarn("JSO::convertMapToJavascriptObject : Map contains null key - dropping this entry.");
                continue;
            } else if (key.equals("__ref")) {
                SC.logWarn("JSO::convertMapToJavascriptObject : skipping __ref in map");
                continue;
            } else if (key.equals("__module")) {
                SC.logWarn("JSO::convertMapToJavascriptObject : skipping __module in map");
                continue;
            }

            Object value = valueMap.get(key);

            if (value == null) {
                JSOHelper.setNullAttribute(valueJS, key);
            } else if (value instanceof JavaScriptObject) {
                JSOHelper.setAttribute(valueJS, key, (JavaScriptObject) value);
            } else if (value instanceof Date) {
                JSOHelper.setAttribute(valueJS, key, ((Date) value));
            } else if (value instanceof Number) {
                JSOHelper.setAttribute(valueJS, key, JSOHelper.doubleValue((Number) value));
            } else if (value instanceof String || value instanceof Character) {
                JSOHelper.setAttribute(valueJS, key, value.toString());
            } else if (value instanceof Boolean) {
                JSOHelper.setAttribute(valueJS, key, ((Boolean) value).booleanValue());
            } else if (value.getClass().isArray()) {
                if (value instanceof Object[]) {
                    // Use our convertToJavaScriptArray
                    JSOHelper.setAttribute(valueJS, key, convertToJavaScriptArray((Object[]) value));
                } else if (value instanceof int[]) {
                    JSOHelper.setAttribute(valueJS, key, JSOHelper.convertToJavaScriptArray((int[]) value));
                } else if (value instanceof float[]) {
                    JSOHelper.setAttribute(valueJS, key, JSOHelper.convertToJavaScriptArray((float[]) value));
                } else if (value instanceof double[]) {
                    JSOHelper.setAttribute(valueJS, key, JSOHelper.convertToJavaScriptArray((double[]) value));
                } else if (value instanceof boolean[]) {
                    JSOHelper.setAttribute(valueJS, key, JSOHelper.convertToJavaScriptArray((boolean[]) value));
                } else if (value instanceof char[]) {
                    JSOHelper.setAttribute(valueJS, key, JSOHelper.convertToJavaScriptArray((char[]) value));
                } else if (value instanceof byte[]) {
                    JSOHelper.setAttribute(valueJS, key, JSOHelper.convertToJavaScriptArray((byte[]) value));
                } else if (value instanceof short[]) {
                    JSOHelper.setAttribute(valueJS, key, JSOHelper.convertToJavaScriptArray((short[]) value));
                } else if (value instanceof long[]) {
                    JSOHelper.setAttribute(valueJS, key, JSOHelper.convertToJavaScriptArray((long[]) value));
                } else {
                    assert false : value.getClass() + " should not be an array class.";
                    JSOHelper.setNullAttribute(valueJS, key);
                }
            } else if (value instanceof Map) {
                // Use our convertMapToJavascriptObject
            	JavaScriptObject innerMapJS = convertMapToJavascriptObject((Map) value);
            	JSOHelper.setAttribute(valueJS, key, innerMapJS);
            } else if (value instanceof List) {
                JSOHelper.setAttribute(valueJS, key, convertToJavaScriptArray(((List) value).toArray()));
            } else if (value instanceof Iterator) {
            	List listVal = new ArrayList();
            	while (((Iterator) value).hasNext()) listVal.add(((Iterator) value).next());            	
            	JSOHelper.setAttribute(valueJS, key, convertToJavaScriptArray(((List<?>) listVal).toArray()));
            } else if (value instanceof Set) {
                JSOHelper.setAttribute(valueJS, key, convertToJavaScriptArray(((Set<?>) value).toArray()));
            } else if (value instanceof DataClass) {
                JSOHelper.setAttribute(valueJS, key, ((DataClass) value).getJsObj());
            } else if (value instanceof BaseClass) {
                JSOHelper.setAttribute(valueJS, key, ((BaseClass) value).getOrCreateJsObj());
            } else if (value instanceof BaseWidget) {
                JSOHelper.setAttribute(valueJS, key, ((BaseWidget) value).getOrCreateJsObj());
            } else if (value instanceof Record) {
                JSOHelper.setAttribute(valueJS, key, ((Record) value).getJsObj());
            } else {
                throw new IllegalArgumentException(
                    "Could not convert from " + 
                    (value == null ? "null" : value.getClass().getName()) + 
                    " to JavaScriptObject"
                );
            }
        }

        return valueJS;
    }

    /**
     * Converts the value to a JavaScriptObject.
     * Note that not all values will convert to JavaScriptObject, becuase
     * the JSNI glue code will auto-convert them back. This returns
     * values only when they really do convert to JavaScriptObject (so,
     * not strings, or numbers).
     *
     * @param value Value to convert
     * @return A JavaScriptObject
     */
    public native static JavaScriptObject convertToJavaScriptObject (Object value) /*-{
        // Convert the value and wrap it in a jsArray
        var jsArray = @com.smartgwt.client.bean.BeanValueType::wrapInJavascriptArray(Ljava/lang/Object;)(value);

        // We need to make sure that it can actually be returned as a JavaScriptObject
        var jsValue = jsArray[0];

        if ($wnd.isc.isAn.Object(jsValue)) {
            return jsValue;
        } else {
            return null;
        }
    }-*/;
 
    // ---------------------------
    // Instance Fields and Methods
    // ---------------------------

    // We make the constructor protected, because construction should be
    // triggered by calling a registerValueType method in a subclass.
    protected BeanValueType () {
    }

    // Generated classes implement in order to return the value type. Note
    // that this would be the primitive type for primitive types (thus, the
    // type doesn't entirely correspond with the generic ValueType).
    protected abstract Class<?> getValueType ();
    // e.g. return java.lang.Map.class;
    
    // Generated classes implement 
    protected abstract boolean isAssignableFrom (Object value);
    // e.g. return value == null || value instanceof java.lang.Map;
    
    // Value to use if supplied with a null value. Subclasses for primitive
    // types implement with an appropriate value (e.g. 0 or false etc.).
    protected ValueType nullValue () {
        return null;
    }

    // Note that we could add more convertTo... and convertabilityTo...
    // methods, depending on what we need. But String is the only obvious need.
    
    // How well can a value of this type be converted to a string? Of course,
    // any type can be converted to a string, but if we have a choice of getters,
    // then some may be better than others.
    protected Convertability convertabilityToString () {
        // At worst, it will be supported, since we can always call toString().
        // Subclasses can return something else if they can do better.
        return Convertability.SUPPORTED;
    }

    // A default procedure ... subclasses may implement a better strategy.
    // Note that we have to use a distinct method name from the static method
    // convertToString, since the signature is the same.
    protected String doConvertToString (ValueType value) {
        return value == null ? null : value.toString();
    }

    // How well can the specified value be converted to this type? Used by
    // BeanProperty to select among multiple available setters for a property.
    // We distinguish between EXACT, PREFERRED, SUPPORTED and UNSUPPORTED. In
    // theory, we could make even finer distinctions, if necessary.
    public Convertability convertabilityFrom (Object value) {
        if (value == null) {
            // With null, we prefer non-primitive setters if available, since
            // less conversion would be involved.
            if (getValueType().isPrimitive()) {
                return Convertability.SUPPORTED;
            } else {
                return Convertability.PREFERRED;
            }
        } else {
            // If not null, we don't have any default conversions (since we
            // can't always convert from String). So, subclasses have to
            // indicate what they can handle.
            return Convertability.UNSUPPORTED;
        }
    }

    // This is the main entry point for converting from objects to our value type.
    public ValueType convertFrom (Object value) {
        if (value == null) {
            return nullValue();
        } else {
            throw conversionException(value);
        }
    }

    // Convenience function for conversion exceptions
    protected IllegalArgumentException conversionException (Object value) {
        return new IllegalArgumentException(
            "Could not convert from " + (value == null ? "null" : value.getClass().getName()) + 
            " to " + getValueType().getName()
        );
    }
}
