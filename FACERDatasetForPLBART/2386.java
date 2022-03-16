     /** 
      * This function browses up one level 
      * according to the field: currentDirectory 
      */ 
     private void upOneLevel(){
    	 if (mStepsBack > 0) {
    		 mStepsBack--;
    	 }
         if(currentDirectory.getParent() != null) 
               browseTo(currentDirectory.getParentFile()); 
     } 

