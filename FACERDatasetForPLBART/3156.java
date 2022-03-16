     public void setListItems(List<IconifiedText> lit, boolean filter) {
    	 mOriginalItems = lit;

    	 if (filter) {
    		 mItems = mFilter.synchronousFilter(lastFilter);
    	 } else {
    		 mItems = lit;
    	 }
     } 

