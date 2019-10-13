public class ProducerConsumerUsingBlockingQueue{
  
  

}

class Consumer implements Runnable {

private BlockingQueue q;

public Consumer(BlockingQueue sharedQ){
  this.q=sharedQ;
}

public void consume(){

  for(int i=0;i<=10;i++){
    System.out.println(q.take());
  }

}

}
class Producer implements Runnable {


private BlockingQueue q;

public Producer(BlockingQueue sharedQ){
  this.q=sharedQ;
}

public void produce(){

  for(int i=0;i<=10;i++){
    
    System.out.println("Producing item = " + i);
    q.offer(i);
  }

}
  

}
