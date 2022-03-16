        @Override
        public void run() {
            String msg = null;
            if(	!getList( true ) ) {
                Log.w( TAG, "su failed. let's try just sh" );
                errMsg = null;
                msg = commander.getContext().getString( R.string.no_root );
                if( !getList( false ) )
                    error( commander.getContext().getString( R.string.cant_cd, src.getPath() ) );
            }
            doneReading( msg, pass_back_on_done );
        }

