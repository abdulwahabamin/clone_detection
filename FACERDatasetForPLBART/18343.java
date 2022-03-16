	@Override
	public void onReceive(Context context, Intent intent) {
		
		mApp = (Common) context.getApplicationContext();

 	    if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
	        int state = intent.getIntExtra("state", -1);
	        switch (state) {
	        case 0:
	            //Headset unplug event.
	        	mApp.getService().pausePlayback();
	            break;
	        case 1:
	            //Headset plug-in event.
	        	mApp.getService().startPlayback();
	            break;
	        default:
	            //No idea what just happened.
	        }

		}
	    
	}

