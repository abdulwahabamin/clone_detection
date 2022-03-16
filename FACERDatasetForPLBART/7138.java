    protected final int askOnFileExist( String msg, Commander commander ) throws InterruptedException {
        if( ( file_exist_behaviour & Commander.APPLY_ALL ) != 0 )
            return file_exist_behaviour & ~Commander.APPLY_ALL;
        int res;
        synchronized( commander ) {
            sendProgress( msg, Commander.OPERATION_SUSPENDED_FILE_EXIST );
            while( ( res = commander.getResolution() ) == Commander.UNKNOWN )
                commander.wait();
        }
        if( res == Commander.ABORT ) {
            error( commander.getContext().getString( R.string.interrupted ) );
            return res;
        }
        if( ( res & Commander.APPLY_ALL ) != 0 )
            file_exist_behaviour = res;
        return res & ~Commander.APPLY_ALL;
    }

