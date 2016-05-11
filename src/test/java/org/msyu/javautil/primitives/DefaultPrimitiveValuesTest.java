package org.msyu.javautil.primitives;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DefaultPrimitiveValuesTest {

	@Test
	public void getDefaultValueForPrimitive() {
		assertEquals(DefaultPrimitiveValues.getDefaultValueFor(Float.TYPE, false), 0f);
	}

	@Test
	public void getDefaultValueForBoxUnhandled() {
		assertEquals(DefaultPrimitiveValues.getDefaultValueFor(Float.class, false), null);
	}

	@Test
	public void getDefaultValueForBoxHandled() {
		assertEquals(DefaultPrimitiveValues.getDefaultValueFor(Float.class, true), 0f);
	}

	@Test
	public void getDefaultValueForObject() {
		assertEquals(DefaultPrimitiveValues.getDefaultValueFor(String.class, true), null);
	}

}
