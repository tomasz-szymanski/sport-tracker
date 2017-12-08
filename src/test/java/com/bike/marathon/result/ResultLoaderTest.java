package com.bike.marathon.result;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResultLoaderTest {

	@Autowired
	private ResultLoader resultLoader;

	@Test
	public void loadResultsToDBTest() throws IOException {
		resultLoader.loadResultsToDB();
	}
}