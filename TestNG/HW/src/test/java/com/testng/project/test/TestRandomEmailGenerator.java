package com.testng.project.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.testng.project.RandomEmailGenerator;

public class TestRandomEmailGenerator {

	@Test
	public void testGenerate() {
		RandomEmailGenerator obj = new RandomEmailGenerator();
		String email = obj.generate();
		Assert.assertNotNull(email);
		//Assert.assertEquals(email, "test@test.com");
	}

}
