        @Override
        public void run() {
            if( !execute() )
                counter = 0;
            sendResult( counter > 0 ? Utils.getOpReport( commander.getContext(), counter, R.string.deleted ) : "" );
        }

