     public void setListItems(List<IconifiedText> lit, boolean filter, File parentFile, MimeTypes mimeTypes) {
    	 mOriginalItems = lit;
    	 this.parentFile = parentFile;
    	 mMimeTypes = mimeTypes;
    	 
    	 if (filter) {
    		 mItems = mFilter.synchronousFilter(lastFilter);
    	 } else {
    		 mItems = lit;
    	 }
     } 

