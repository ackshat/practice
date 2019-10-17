package dsalgo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinMaxIncDO1{
	
	
	
	  public static void main(String[] args) {
		  
		  MinMaxIncDO1 o = new MinMaxIncDO1();
		  
		  
		  o.inc1("hello");
		  o.inc1("hello");
		  o.inc1("hello");
		  o.inc1("hello");
		  o.inc1("hello1");
		  o.inc1("hello1");		  o.inc1("hello1");		  o.inc1("hello2");
		  o.inc1("hell");
		  o.inc1("hello1");
		 
		 
		  System.out.println(o.fMap);
		  System.out.println("min: "+o.min());
		  System.out.println("max: "+o.max());
		  
		  o.dec1("hello");
		  o.dec1("hello1");
		  o.dec1("hello");
		  o.dec1("hello1");
		 o.dec1("hello");
		 /* o.dec1("hello1");
		  o.dec1("hello");
		  o.dec1("hello1");*/
		  
		  System.out.println(o.fMap);
		  System.out.println("min: "+o.min());
		  System.out.println("max: "+o.max());
		  
	  }

	  private Map<String, Integer> fMap = new HashMap<>();
	    private Map<Integer, Set<String>> rMap = new HashMap<>();
	    
	    private int cMin=0, cMax = 0;
	    
	    public void inc1(String k){
	    	
	      int f = fMap.getOrDefault(k,0);
	      if(f>0){
	        rMap.get(f).remove(k);
	        if(rMap.get(f).size()==0){
	          rMap.remove(f);
	          if(cMin==f)  cMin = f+1;
	        }
	      }else {
	    	  cMin = 1;
	      }
	      Set<String> s = rMap.getOrDefault(f+1, new HashSet<String>());
	      s.add(k);
	      rMap.put(f+1, s);
	      fMap.put(k,f+1);
	     
	      if(f+1> cMax) cMax = f+1;
	      
	    }
	    
	    public void dec1(String k){
	      Integer f = fMap.getOrDefault(k,0);
	      if(f==0) return;
	      
	      Set<String> s  = rMap.get(f);
	      s.remove(k);
	      
	      if(s.size()==0){
	    	  rMap.remove(f);
	    	  if(cMax==f) cMax = f-1;
	      }
	      if(f>1) {
	    	 fMap.put(k, f-1);
	      }
	      else {
	    	  fMap.remove(k);
	      }
	      Set<String> s2 = rMap.getOrDefault(f-1, new HashSet<>());
	      s2.add(k);
	      rMap.put(f-1, s2);
	      
	      if(cMin==f) cMin = f-1;
	    }
	    
	    public Set<String> max(){
	      return rMap.get(cMax);
	    }
	    public Set<String> min(){
	      return rMap.get(cMin);
	    }

	}
