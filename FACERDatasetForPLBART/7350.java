    private final boolean checkReadyness()   
    {
        if( worker != null ) {
        	notify( ctx.getString( R.string.busy ), Commander.OPERATION_FAILED );
        	return false;
        }
    	return true;
    }

