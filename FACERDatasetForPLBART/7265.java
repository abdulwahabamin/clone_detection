        @Override
        public void run() {
        	int total = delFiles( mList, "" );
        	sendResult( Utils.getOpReport( ctx, total, R.string.deleted ) );
            super.run();
        }

