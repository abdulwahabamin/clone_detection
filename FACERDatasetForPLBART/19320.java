        @Override
        public int getCount() {
        	
        	try {
            	if (mApp.getService().getPlaybackIndecesList()!=null) {
            		return mApp.getService().getPlaybackIndecesList().size();
            	} else {
            		mApp.getService().stopSelf();
            		return 0;
            	}
        	} catch (Exception e) {
        		e.printStackTrace();
        		return 0;
        	}

        }

