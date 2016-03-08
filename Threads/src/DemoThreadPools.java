import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoThreadPools {

	static class MakePizzaTask implements Callable<String> {

		static int no = 1;
		
		@Override
		public String call() {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " Napravih q");
			return (no++) + " Pizza s kartofi i brokoli i ananas";
		}

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		CompletionService<String> pool = new ExecutorCompletionService<String>(threadPool);
		

		List<Future<String>> bydeshtiPizzi = new ArrayList<Future<String>>();
		
		
		for (int i = 1; i <= 100; i++) {
//			Future<String> bydeshtaPizza = threadPool.submit(new MakePizzaTask());
//			bydeshtiPizzi.add(bydeshtaPizza);
			
			pool.submit(new MakePizzaTask());
		}
		
		///... sled vreme...
		int i = 0;
		for (i=1; i<=100;i++) {
//			System.out.println("Eto kvo iskam :" + (++i) );
//			System.out.println(" Dadoha mi : " + pizza.get() );
			
			System.out.println(pool.take().get());
		}

		threadPool.shutdown();
	}
}
