/**
 * 
 */
package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ricki
 *
 */
public class Test {

	public static void main(String[] args) {
		/*Map resultMap = new HashMap();
		Map<String,Object> resultMapStr = new HashMap<String,Object>();
		System.out.println(resultMap.getClass());
		System.out.println(resultMapStr.getClass());
		System.out.println(resultMap.getClass().equals(resultMapStr.getClass()));
		resultMap.put("name", "ricki");
		HttpHeaders headers =  new HttpHeaders();
		headers.setDate((new Date().getTime()));
		headers.setContentLength(34);
		ResponseEntity response = new ResponseEntity(resultMap,headers,HttpStatus.OK);
		System.out.println(response);
		System.out.println(HttpStatus.OK);*/
		/*final Car car = Car.create( Car::new );
		System.out.println("car:"+car);
		final List< Car > cars = Arrays.asList( car );
		cars.forEach( Car::collide );*/
		/*CountDownLatch thread1Latch = new CountDownLatch(1);
		CountDownLatch thread2Latch = new CountDownLatch(1);
		
		Thread thread1 = new Thread(()->{
			System.out.println("I'm thread1");
			System.out.println("thread1已完成");
			thread1Latch.countDown();
		});
		
		Thread thread2 = new Thread(()->{
			try {
				System.out.println("等待thread1完成");
				thread1Latch.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("I'm thread2");
			System.out.println("thread2已完成");
			thread2Latch.countDown();
		});
		
		Thread thread3 = new Thread(()->{
			try {
				//System.out.println("等待thread2完成");
				//thread2Latch.await();
				System.out.println("等待thread2完成,如果10秒后未完成，则退出");
				thread2Latch.await(10,TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("I'm thread3");
		});*/
		ReentrantLock lock = new ReentrantLock();
		Condition thread1Cond = lock.newCondition();
		Condition thread2Cond = lock.newCondition();
		
		Thread thread1 = new Thread(()->{
			lock.lock();
			System.out.println("I'm thread1");
			System.out.println("thread1已完成");
			thread1Cond.signalAll();
			lock.unlock();
		});
		
		Thread thread2 = new Thread(()->{
			lock.lock();
			try {
				System.out.println("等待thread1完成");
				thread1Cond.await();
				System.out.println("I'm thread2");
				System.out.println("thread2已完成");
				thread2Cond.signalAll();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		});
		
		Thread thread3 = new Thread(()->{
			lock.lock();
			try {
				System.out.println("等待thread2完成");
				thread2Cond.await();
				//System.out.println("等待thread2完成,如果10秒后未完成，则退出");
				//thread2Cond.await(10,TimeUnit.SECONDS);
				System.out.println("I'm thread3");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
			
		});
		
		//thread1.start();
		thread2.start();
		thread3.start();
		thread1.start();
	}
	
}
