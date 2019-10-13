public class ProducerConsumerUsingBlockingQueue{
  
  public static void main(String[] args){
    
    BlockingQueue q = nwe BlockingQueue();
    Produer producer = new Producer(q);
    Consumer consumer = new Consumer(q);
    
    
  }
    

}

class Consumer implements Runnable {

private BlockingQueue q;

public Consumer(BlockingQueue sharedQ){
  this.q=sharedQ;
}

public void consume(){

  while(true){
  for(int i=0;i<=10;i++){
    System.out.println( "Consuming : "+q.take());
    try{
    Thread.sleep(200);
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  }
}
  
 public void run(){
  produce();
 }
  

}
class Producer implements Runnable {


private BlockingQueue q;

public Producer(BlockingQueue sharedQ){
  this.q=sharedQ;
}

public void produce(){

  while(true){
  for(int i=0;i<=10;i++){
    System.out.println("Producing item = " + i);
    q.offer(i);
  }
    try{
    Thread.sleep(200);
    }
    catch(Exception e){
      ;
    }
  }
}
  

}
