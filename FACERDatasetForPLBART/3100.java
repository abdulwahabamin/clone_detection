     /**
      * Jump to some location by clicking on a 
      * directory button.
      * 
      * This resets the counter for "back" actions.
      * 
      * @param aDirectory
      */
     private void jumpTo(final File aDirectory) {
    	 mStepsBack = 0;
    	 browseTo(aDirectory);
     }

