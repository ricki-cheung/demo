/**
 * 
 */
package com.example.demo;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.RecursiveTask;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Ricki
 *
 */
public class Test {

	public static void main(String[] args) {
		User user = new User();
		Function<User,String> f = User::getName;
		System.out.println(f.apply(user));
		Function<User,String> f2 = User::getAlias;
		System.out.println(f2.apply(user));
		
		/*Function<User,String> f3 = user::getName;
		System.out.println(f3.apply(user));*/
		/*Parent parent = new Child();
		Child  child = (Child)parent;*/
		/*System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);*/
		//Map<String,String> map = new HashMap<String,String>();
		/*Map<String,String> map = new ConcurrentHashMap<String,String>();
		
        int num = 1000000;
        for(int i = 0;i < num ; i++) {
        	map.put(i+"", i+"");
        }
        
        //map = Collections.synchronizedMap(map);
        
        
        Set<Entry<String,String>> set = map.entrySet();
        Iterator<Entry<String, String>> it = set.iterator();
        Date startDate = new Date();
        while(it.hasNext()) {
        	Entry<String, String> entry = it.next();
        	System.out.println("entry key:"+entry.getKey()+",entry value:"+entry.getValue());
        }
        Date endDate = new Date();
        System.out.println("用时1:"+((endDate.getTime()-startDate.getTime())/1000));*/
        //User user = new User();
        Supplier<String> f3 = user::getName;
		System.out.println(f3.get());
		//ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		/*executorService.execute(new MyThread("thread-1"));
		executorService.execute(new MyThread("thread-2"));
		executorService.execute(new MyThread("thread-3"));
		executorService.execute(new MyThread("thread-4"));*/
		/*List<Future> list = new ArrayList<Future>();
		Future future1 = executorService.submit(new MyCallable("callable-1"));
		list.add(future1);
		Future future2 = executorService.submit(new MyCallable("callable-2"));
		list.add(future2);
		Future future3 = executorService.submit(new MyCallable("callable-3"));
		list.add(future3);
		Future future4 = executorService.submit(new MyCallable("callable-4"));
		list.add(future4);
		
		try {
			while(list.size() > 0) {
				for(int i = 0; i < list.size();) {
					Future future = list.get(i);
					if(future.isDone()) {
						System.out.println(future.get()+" is Done");
						list.remove(i);
					}else {
						i++;
					}
					System.out.println(list.size());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*ForkJoinPool forkJoinPool = new ForkJoinPool();
	    MyForkJoinTask task = new MyForkJoinTask(0, 200000L);
	    // 将一个大的任务提交到池中
	    ForkJoinTask<Long> result = forkJoinPool.submit(task);
	    long res = 0;
	    try {
	      // 等待运算结果
	      res = result.get();
	      System.out.println("sum = " + res);
	    } catch (InterruptedException | ExecutionException e) {
	      e.printStackTrace();
	    }*/

		String str = null;
		System.out.println("reuslt:"+(str+""));
	}
	
}

class MyThread implements Runnable{
	
	private String name;
	
	public MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("my name is:"+name);
	}
	
}

class MyForkJoinTask extends RecursiveTask<Long>{

	/**
	   * 阀值
	   */
	  static final int THRESHOLD = 10000;
	  long start;
	  long end;

	  public MyForkJoinTask(long start, long end) {
	    this.start = start;
	    this.end = end;
	  }

	  /**
	   * 有返回值的
	   * @return
	   */
	  @Override
	  protected Long compute() {

	    long sum = 0;
	    // 当阀值小于10000则不分解了
	    boolean canCompute = (end - start) < THRESHOLD;
	    if (canCompute) {
	      for (long i = start; i <= end; i++) {
	        sum += i;
	      }
	    } else {
	      // 2000
	      long step = (end - start) / 100;
	      ArrayList<MyForkJoinTask> subTasks = new ArrayList<>();
	      long pos = start;
	      for (int i = 0; i < 100; i++) {
	        long lastOne = pos + step;
	        if (lastOne > end) {
	          lastOne = end;
	        }
	        //0-2000 个计算任务 * 100
	        MyForkJoinTask subTask = new MyForkJoinTask(pos, lastOne);
	        pos += step + 1;
	        subTasks.add(subTask);
	        subTask.fork();// fork
	      }

	      for (MyForkJoinTask t : subTasks) {
	        sum += t.join();
	      }
	    }
	    return sum;

	  }
	
}

class MyCallable implements Callable<String>{
	
	private String name;
	
	public MyCallable(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(10000);
		return name;
	}

	
}


class User{
	String name;
	static String alias;
	
	public User() {
		System.out.println("c this:"+this);
		name = "ricki cheung";
	}
	
	public String getName() {
		System.out.println(this);
		return name;
	}
	
	public static String getAlias(User user) {
		return user.alias;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}