    public static boolean getLogOutputPaths(MLog.LogOutputPaths out, String currentName) {
    	String dir = LogToES.getLogPath();
    	if (dir == null || currentName == null) {
    		return false;
    	}
    	out.dir = dir;
    	String current = null;
    	synchronized (mLock) {
			current = mPath;
		}
    	if (current == null) {
    		current = createFile(dir, currentName).getAbsolutePath();
    	}
    	out.currentLogFile = current;
    	
    	// get latest.
    	File folder = new File(dir);
    	File[] files = folder.listFiles();
    	if (files != null) {
    		long maxBackupTime = 0;
            long tempTime;
    		String dest = null;
    		for (File e : files) {
                tempTime = getLogFileBackupTime(e);
    			if (tempTime > maxBackupTime) {
                    maxBackupTime = tempTime;
    				dest = e.getAbsolutePath();
    			}
    		}
    		out.latestBackupFile = dest;
    	}
    	
    	return true;
    }

