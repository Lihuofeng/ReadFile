package com.bees360;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public class Test {

	public static void main(String[] args) {
		Map<String, String> envs = System.getenv();
		for(Entry<String, String> env: envs.entrySet()) {
			System.out.println(env.getKey() + ": " + env.getValue());
		}
		
//		System.out.println("==================");
//		System.out.println(System.getenv("BEES360"));
//		System.out.println(System.getenv("MAVEN_HOME"));
		
		File f = new File("/var/bees360/www/projects/${projectId}/");
		f.mkdirs();
		Long[] t= {};
		Long minNum = Collections.max(Arrays.asList(t));
		System.out.println("t:"+t);
		System.out.println("minNum:"+minNum);
	}
}
