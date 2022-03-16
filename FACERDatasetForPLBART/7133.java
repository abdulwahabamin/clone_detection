    protected final void sendResult( String report ) {
        if( errMsg != null )
            sendProgress( report + "\n - " + errMsg, Commander.OPERATION_FAILED );
        else {
            sendProgress( report, Commander.OPERATION_COMPLETED_REFRESH_REQUIRED );
        }
    }

