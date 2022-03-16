        @Override
        public void run() {
            if( !execute() )
                counter = 0;
            if( quiet )
                sendResult( null );
            else
                sendResult( counter > 0 ? Utils.getOpReport( commander.getContext(), counter, move ? R.string.moved : R.string.copied ) : "" );
        }

