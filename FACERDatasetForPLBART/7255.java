		@Override
		public boolean completed( long size ) throws InterruptedException {
			if( curFileLen > 0 ) {
			    curFileDone += size;
			    long cur_time = System.currentTimeMillis();
			    long time_delta = cur_time - startTime;
			    int  speed = time_delta == 0 ? 0 : (int)( 1000 * size / time_delta ); 
				sendProgress( progressMessage, (int)( curFileDone * 100 / curFileLen ), -1, speed );
				startTime = cur_time;
			}
			//Log.v( TAG, progressMessage + " " + size );
    		if( isStopReq() ) {
    			error( ctx.getString( R.string.canceled ) );
    			return false;
    		}
            Thread.sleep( 1 );
    		return true;
		}

