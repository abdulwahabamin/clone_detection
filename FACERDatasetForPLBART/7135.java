    protected final void doneReading( String msg, String cookie ) {
        if( errMsg != null )
            sendProgress( errMsg, Commander.OPERATION_FAILED, cookie );
        else {
            sendProgress( msg, Commander.OPERATION_COMPLETED, cookie );
        }
    }

