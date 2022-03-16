		@Override
	    public boolean onScale(ScaleGestureDetector detector) {
			float mScaleFactor = (float)Math.min(Math.max(.95f, detector.getScaleFactor()), 1.05);
		 	float origScale = saveScale;
	        saveScale *= mScaleFactor;
	        if (saveScale > maxScale) {
	        	saveScale = maxScale;
	        	mScaleFactor = maxScale / origScale;
	        } else if (saveScale < minScale) {
	        	saveScale = minScale;
	        	mScaleFactor = minScale / origScale;
	        }
        	right = width * saveScale - width - (2 * redundantXSpace * saveScale);
            bottom = height * saveScale - height - (2 * redundantYSpace * saveScale);
        	if (origWidth * saveScale <= width || origHeight * saveScale <= height) {
        		matrix.postScale(mScaleFactor, mScaleFactor, width / 2, height / 2);
            	if (mScaleFactor < 1) {
            		matrix.getValues(m);
            		float x = m[Matrix.MTRANS_X];
                	float y = m[Matrix.MTRANS_Y];
                	if (mScaleFactor < 1) {
        	        	if (Math.round(origWidth * saveScale) < width) {
        	        		if (y < -bottom)
            	        		matrix.postTranslate(0, -(y + bottom));
        	        		else if (y > 0)
            	        		matrix.postTranslate(0, -y);
        	        	} else {
	                		if (x < -right) 
	        	        		matrix.postTranslate(-(x + right), 0);
	                		else if (x > 0) 
	        	        		matrix.postTranslate(-x, 0);
        	        	}
                	}
            	}
        	} else {
            	matrix.postScale(mScaleFactor, mScaleFactor, detector.getFocusX(), detector.getFocusY());
            	matrix.getValues(m);
            	float x = m[Matrix.MTRANS_X];
            	float y = m[Matrix.MTRANS_Y];
            	if (mScaleFactor < 1) {
    	        	if (x < -right) 
    	        		matrix.postTranslate(-(x + right), 0);
    	        	else if (x > 0) 
    	        		matrix.postTranslate(-x, 0);
    	        	if (y < -bottom)
    	        		matrix.postTranslate(0, -(y + bottom));
    	        	else if (y > 0)
    	        		matrix.postTranslate(0, -y);
            	}
        	}
	        return true;
	        
	    }

