	/**
	 * Cancels any downloads, shuts down the executor pool,
	 * and then purges the caches.
	 */
	public void cancel(){
		cancel = true;
		
		// We could also terminate it immediately,
		// but that may lead to synchronization issues.
		if(!mExecutor.isShutdown()){
			mExecutor.shutdown();
		}
		
		stopPurgeTimer();
		
		mContext = null;
		clearCaches();
	}

