package org.msyu.javautil.primitives;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class BoxTypeMapping {

	private BoxTypeMapping() {
		throw new AssertionError("do not instantiate utility classes");
	}

	public static final Set<Class<?>> BOXES;

	public static final Map<Class<?>, Class<?>> BOX_BY_TYPE;

	public static final Map<Class<?>, Class<?>> TYPE_BY_BOX;

	public static final Set<Class<?>> TYPES;

	static {
		BOXES = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
				Void.class,
				Boolean.class,
				Byte.class, Short.class, Integer.class, Long.class,
				Float.class, Double.class,
				Character.class
		)));
		Map<Class<?>, Class<?>> bbt = new HashMap<>();
		Map<Class<?>, Class<?>> tbb = new HashMap<>();
		for (Class<?> box : BOXES) {
			Class<?> type;
			try {
				type = (Class<?>) box.getDeclaredField("TYPE").get(null);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				/* These shouldn't happen IRL */
				continue;
			}
			bbt.put(type, box);
			tbb.put(box, type);
		}
		BOX_BY_TYPE = Collections.unmodifiableMap(bbt);
		TYPE_BY_BOX = Collections.unmodifiableMap(tbb);
		TYPES = BOX_BY_TYPE.keySet();
	}

	public static boolean isPrimitive(Class<?> cls) {
		return TYPES.contains(cls);
	}

	public static boolean isBox(Class<?> cls) {
		return BOXES.contains(cls);
	}

	public static boolean isPrimitiveOrBox(Class<?> cls) {
		return isPrimitive(cls) || isBox(cls);
	}

}
