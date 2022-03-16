	@Override
	public void reqItemsSize( SparseBooleanArray cis ) {
        try {
        	FileItem[] list = bitsToFilesEx( cis );
    		if( worker != null && worker.reqStop() )
   		        return;
    		notify( Commander.OPERATION_STARTED );
    		worker = new CalcSizesEngine( workerHandler, list );
    		worker.setName( TAG + ".CalcSizesEngine" );
       		worker.start();
		}
        catch(Exception e) {
		}
	}

