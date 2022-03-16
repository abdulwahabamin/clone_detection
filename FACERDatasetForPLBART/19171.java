	private int[] getTrueDeviceResolution() {
    	
    	int[] resolution = new int[2];
    	try {
    		Display display = getWindowManager().getDefaultDisplay();   
    		
        	Method mGetRawH = Display.class.getMethod("getRawHeight");
        	Method mGetRawW = Display.class.getMethod("getRawWidth");
        	
        	int rawWidth = (Integer) mGetRawW.invoke(display);
        	int rawHeight = (Integer) mGetRawH.invoke(display);
        	
        	resolution[0] = rawWidth;
        	resolution[1] = rawHeight;
        	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return resolution;
    }

