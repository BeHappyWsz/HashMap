package hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
/**
 * 
 * @author wsz
 * @date 2017年12月12日
  			耗时单位ms
 ----------------------------------
      数据量     5W      50W     500W
 ----------------------------------  
 method1   8       25   203-180-178
 ----------------------------------
 method2   11      24   201-198-187
 ----------------------------------
 method3   10      21   145-137-136
 ----------------------------------
 method4   9       21   151-135-136
 ----------------------------------
 
 */
public class Demo1 {

	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String, Object>();
		long size = 10000000L;
		for(int i = 0; i < size ;i++) {
			map.put(String.valueOf(i), i);
		}
		
		method1(map);
		method2(map);
		method3(map);
		method4(map);
	}
	
	public static void method1(Map<String, Object> map) {
		getTime();
		Set<String> keySet = map.keySet();//键集合
		Iterator<String> it = keySet.iterator();//迭代器
		while(it.hasNext()) {
			String key = it.next();
			Object value = map.get(key);
//			System.out.println(key+"_"+value);
		}
		getTime();
	}
	
	public static void method2(Map<String,Object> map) {
		getTime();
		for(String key : map.keySet()) {
			Object value = map.get(key);
//			System.out.println(key+"_"+value);
		}
		getTime();
	}
	
	public static void method3(Map<String,Object> map) {
		getTime();
		Set<Entry<String, Object>> entrySet = map.entrySet();
		Iterator<Entry<String, Object>> it = entrySet.iterator();
		while(it.hasNext()) {
			Entry<String, Object> next = it.next();
			String key = next.getKey();
			Object value = next.getValue();
//			System.out.println(key+"_"+value);
		}
		getTime();
	}
	
	public static void method4(Map<String,Object> map) {
		getTime();
		for(Map.Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
//			System.out.println(key+"_"+value);
		}
		getTime();
	}
	
	public static void getTime() {
		System.out.println(System.currentTimeMillis());
	}
}
