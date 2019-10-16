class MinMaxIncDO1{

  private Map<String, Integer> fMap = new HashMap<>();
    private Map<Integer, Set<String>> rMap = new HashMap<>();
    
    private int cMin=0. cMax = 0;
    
    public void inc1(String k){
      
      int f = fMap.getOrDefault(k,0);
      if(f>0){
        rMap.get(f).remove(k);
      }
      rMap.getOrDefault(f+1, new HashSet<>()).add(k);
      fMap.put(k,f+1);
      
      if(f+1> cMax) cMax = f+1;
      
    }
    
    public void min(String k){
      int f = fMap.getOrDefault(k,0);
      if(f==0) return;
      
      rMap.get(f).remove(k);
      if(rMap.get(f).size()==0) rMap.remove(f);
      
      if(f-1 == 0 ){
        fMap.remove(k);
      }
      else{
      fMap.put(k,f-1);
      rMap.getOrDefault(f-1,new HashSet<>()).add(k);
      }
      if (f-1 >0  && f-1 < cMin ) cMin = f-1;
      
    }
    public Set<String> max(){
      return rMap.get(cMax);
    }
    public Set<String> min(){
      return rMap.get(cMin);
    }

}
