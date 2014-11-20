package com.example.reflectiontest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ReflectionTest reflection = new ReflectionTest();
		//getConstructors(reflection);
		try{
			//getConstructors();
			//getConstructor();
			//getMethods();
			//getMethod();
			//getFields();
			//getField();
			//setField();
			loadMethod("com.example.reflectiontest.ReflectionTest" , "abc" , new Object[]{10, "wubo"});
		} catch (Exception e){
			e.printStackTrace();
		}
		

	}
	
	//public static void getConstructors(ReflectionTest reflection){
	public static void getConstructors() throws ClassNotFoundException{
		//Class<? extends ReflectionTest> rClass = reflection.getClass();
		Class rClass = Class.forName("com.example.reflectiontest.ReflectionTest");
		String className = rClass.getName();
		String classSimpleName = rClass.getSimpleName();
		System.out.println("simple name : " + classSimpleName);
		
		try{
			Constructor[] constructors = rClass.getConstructors();
			for(int i = 0; i < constructors.length; i++){
				int modifier = constructors[i].getModifiers();
				System.out.print(Modifier.toString(modifier) + " " + className + " ( ");
				Class[] parameters = constructors[i].getParameterTypes();
				for(int j = 0; j < parameters.length; j++){
					System.out.print(parameters[j].getName());
					if(j+1 < parameters.length){
						System.out.print(", ");
					}
				}
				System.out.println(")");
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void getConstructor() throws ClassNotFoundException{
		Class<?> rClass = Class.forName("com.example.reflectiontest.ReflectionTest");
		String className = rClass.getName();
		try{
			Constructor constructor = rClass.getConstructor(int.class, String.class);
			int modifier = constructor.getModifiers();
			System.out.print(Modifier.toString(modifier) + " " + className + " ( ");
			Class[] parameters = constructor.getParameterTypes();
			for(int j = 0; j < parameters.length; j++){
				System.out.print(parameters[j].getName());
				if(j+1 < parameters.length){
					System.out.print(", ");
				}
			}
			System.out.println(")");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void getMethods() throws ClassNotFoundException{
		Class<?> rClass = Class.forName("com.example.reflectiontest.ReflectionTest");
		String className = rClass.getName();
		
		Method[] methods = rClass.getDeclaredMethods();
		
		for(int i = 0; i< methods.length; i++){
			int modifier = methods[i].getModifiers();
			System.out.print(Modifier.toString(modifier) + " ");
			
			String returnType = methods[i].getReturnType().getName();
			System.out.print(returnType + " ");
			
			System.out.print(methods[i].getName() + " ( ");
			
			Class[] parameters = methods[i].getParameterTypes();
			for(int j = 0; j < parameters.length; j++){
				System.out.print(parameters[j].getName());
				if(j+1 < parameters.length){
					System.out.print(", ");
				}
			}
			System.out.println(")");
		}
	}
	
	public static void getMethod() throws ClassNotFoundException{
		Class<?> rClass = Class.forName("com.example.reflectiontest.ReflectionTest");
		String className = rClass.getName();
		
		try{
			Method method = rClass.getDeclaredMethod("abc", int.class, String.class);
			
			int modifier = method.getModifiers();
			System.out.print(Modifier.toString(modifier) + " ");
			
			String returnType = method.getReturnType().getName();
			System.out.print(returnType + " ");
			
			System.out.print(method.getName() + " ( ");
			
			Class[] parameters = method.getParameterTypes();
			for(int j = 0; j < parameters.length; j++){
				System.out.print(parameters[j].getName());
				if(j+1 < parameters.length){
					System.out.print(", ");
				}
			}
			System.out.println(")");
		} catch (Exception e){
			e.printStackTrace();
		}

	}
	
	public static void getFields()throws ClassNotFoundException{
		Class<?> rClass = Class.forName("com.example.reflectiontest.ReflectionTest");
		String className = rClass.getName();
		
		try{
			Object rObject = rClass.newInstance();	
			
			Field [] fields = rClass.getDeclaredFields();
			for(int i = 0; i <fields.length; i++){
				int modifier = fields[i].getModifiers();
				Class type = fields[i].getType();
				
				String name = fields[i].getName();
				fields[i].setAccessible(true);
				Object value = fields[i].get(rObject);
				if(value == null){
					System.out.println(Modifier.toString(modifier) + " " + type.getSimpleName() + " " + name);
					
				} else {
					System.out.println(Modifier.toString(modifier) + " " + type.getSimpleName() + " " + name + " = " + value.toString());
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}		
	}
	
	public static void getField()throws ClassNotFoundException{
		Class<?> rClass = Class.forName("com.example.reflectiontest.ReflectionTest");
		String className = rClass.getName();
		
		try{
			Object rObject = rClass.newInstance();	
			
			Field field = rClass.getDeclaredField("bInt");
			int modifier = field.getModifiers();
			Class type = field.getType();
			
			String name = field.getName();
			field.setAccessible(true);
			Object value = field.get(rObject);
			if(value == null){
				System.out.println(Modifier.toString(modifier) + " " + type.getSimpleName() + " " + name);
				
			} else {
				System.out.println(Modifier.toString(modifier) + " " + type.getSimpleName() + " " + name + " = " + value.toString());
			}
		} catch (Exception e){
			e.printStackTrace();
		}		
	}
	
	public static void setField()throws ClassNotFoundException{
		Class<?> rClass = Class.forName("com.example.reflectiontest.ReflectionTest");
		String className = rClass.getName();
		
		try{
			Object rObject = rClass.newInstance();	
			
			Field field = rClass.getDeclaredField("bInt");
			int modifier = field.getModifiers();
			Class type = field.getType();
			
			String name = field.getName();
			field.setAccessible(true);
			field.set(rObject, 10);
			Object value = field.get(rObject);
			if(value == null){
				System.out.println(Modifier.toString(modifier) + " " + type.getSimpleName() + " " + name);
				
			} else {
				System.out.println(Modifier.toString(modifier) + " " + type.getSimpleName() + " " + name + " = " + value.toString());
			}
		} catch (Exception e){
			e.printStackTrace();
		}		
	}
	
	public static void loadMethod(String className, String methodName, Object[] paramters)throws ClassNotFoundException{
		Class<?> rClass = Class.forName(className);
		
		try{
			Constructor constructor = rClass.getConstructor(null);
			Object object = constructor.newInstance(null);
			//String className = rClass.getName();
			Class[] paramTypes = getParamTypes(rClass, methodName);
			
			Method method = rClass.getDeclaredMethod(methodName, paramTypes);
			method.setAccessible(true);
			method.invoke(object, paramters);			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static Class[] getParamTypes(Class rClass, String methodName){
		Class[] returnValue = null;
		
		Method[] methods = rClass.getDeclaredMethods();
		for(int i = 0; i < methods.length; i++){
			if(methods[i].getName().equals(methodName))
			{
				returnValue = methods[i].getParameterTypes();
				break;
			}
		}
		return returnValue;
	}
}
