    public void clearAllCaches(){
    	try{
    		ImageUtils.deleteDiskCache(mContext);
    		memCache.clearMemCache();
    	}
    	catch(Exception e){}
    }

