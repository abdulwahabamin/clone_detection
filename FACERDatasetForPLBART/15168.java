    public static void releaseEqualizer(){
    	if(mEqualizer != null){
    		mEqualizer.release();
    	}
    	if(mBoost != null){
    		mBoost.release();
    	}
    }

