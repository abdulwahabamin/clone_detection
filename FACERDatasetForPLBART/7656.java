        LoaderThread( Context ctx_, Uri u_ ) {
            ctx = ctx_;
            u = u_;
            setName( "PictureLoader" );
            //setPriority( Thread.MAX_PRIORITY );
            preExecute();
        }

