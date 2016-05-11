package org.msyu.javautil.primitives;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BoxTypeMappingTest {

	@Test
	public void typeBoxMapping() {
		assertEquals(BoxTypeMapping.BOX_BY_TYPE.get(Integer.TYPE), Integer.class);
		assertEquals(BoxTypeMapping.TYPE_BY_BOX.get(Integer.class), Integer.TYPE);
	}

}
