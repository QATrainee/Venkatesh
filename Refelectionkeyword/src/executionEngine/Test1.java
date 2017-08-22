package executionEngine;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import keyword.Toolsqa.ActionKeywords;

public class Test1 {
	static Class Class1= ActionKeywords.class;
	public static void main(String[] args) throws ReflectiveOperationException, IllegalArgumentException, InvocationTargetException {
		
		ActionKeywords Keywords = new ActionKeywords();
		Method[] methods = Class1.getDeclaredMethods();
		System.out.println(methods.length);
		for(Method method : methods) {
			
			method.invoke(Keywords);
		}
}}
