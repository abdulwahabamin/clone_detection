    @Override
    protected boolean setFrame(int l, int t, int r, int b)
    {
    	if(getDrawable()!=null){
    		float width = r - l; float height = b - t;
            Matrix matrix = getImageMatrix(); 
            float scaleFactor, scaleFactorWidth, scaleFactorHeight;
            scaleFactorWidth = (float)width/(float)getDrawable().getIntrinsicWidth();
            scaleFactorHeight = (float)height/(float)getDrawable().getIntrinsicHeight();    

            if(scaleFactorHeight > scaleFactorWidth) {
                scaleFactor = scaleFactorHeight;
            } else {
                scaleFactor = scaleFactorWidth;
            }

            matrix.setScale(scaleFactor, scaleFactor, 0, 0);
            setImageMatrix(matrix);    	
        }    	

        return super.setFrame(l, t, r, b);
    }

