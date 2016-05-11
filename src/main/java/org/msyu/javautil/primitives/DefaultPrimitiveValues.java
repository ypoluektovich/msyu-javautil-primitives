package org.msyu.javautil.primitives;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DefaultPrimitiveValues {

	private DefaultPrimitiveValues() {
		throw new AssertionError("do not instantiate utility classes");
	}

	public static final Void VOID_0 = null;
	public static final boolean BOOLEAN_0 = false;
	public static final byte BYTE_0 = 0;
	public static final short SHORT_0 = 0;
	public static final int INTEGER_0 = 0;
	public static final long LONG_0 = 0;
	public static final float FLOAT_0 = 0;
	public static final double DOUBLE_0 = 0;
	public static final char CHARACTER_0 = 0;

	private static final Map<Class<?>, Object> VALUE_BY_TYPE;

	static {
		Map<Class<?>, Object> vbc = new HashMap<>();
		vbc.put(Void.TYPE, VOID_0);
		vbc.put(Boolean.TYPE, BOOLEAN_0);
		vbc.put(Byte.TYPE, BYTE_0);
		vbc.put(Short.TYPE, SHORT_0);
		vbc.put(Integer.TYPE, INTEGER_0);
		vbc.put(Long.TYPE, LONG_0);
		vbc.put(Float.TYPE, FLOAT_0);
		vbc.put(Double.TYPE, DOUBLE_0);
		vbc.put(Character.TYPE, CHARACTER_0);
		VALUE_BY_TYPE = Collections.unmodifiableMap(vbc);
	}

	public static Object getDefaultValueFor(Class<?> clazz, boolean handleBoxTypes) {
		if (handleBoxTypes && BoxTypeMapping.isBox(clazz)) {
			clazz = BoxTypeMapping.TYPE_BY_BOX.get(clazz);
		}
		return VALUE_BY_TYPE.get(clazz);
	}

}
