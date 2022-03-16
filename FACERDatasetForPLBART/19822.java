    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }
 
        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            onChangeListener.onStartTrackingTouch(this);
            setPressed(true);
            setSelected(true);
            break;
        case MotionEvent.ACTION_MOVE:
            super.onTouchEvent(event);
            int progress = getMax() - (int) (getMax() * event.getY() / getHeight());
             
            // Ensure progress stays within boundaries
            if(progress < 0) {progress = 0;}
            if(progress > getMax()) {progress = getMax();}
            setProgress(progress);  // Draw progress
            if(progress != lastProgress) {
                // Only enact listener if the progress has actually changed
                lastProgress = progress;
                onChangeListener.onProgressChanged(this, progress, true);
            }
             
            onSizeChanged(getWidth(), getHeight() , 0, 0);
            setPressed(true);
            setSelected(true);
            break;
        case MotionEvent.ACTION_UP:
            onChangeListener.onStopTrackingTouch(this);
            setPressed(false);
            setSelected(false);
            break;
        case MotionEvent.ACTION_CANCEL:
            super.onTouchEvent(event);
            setPressed(false);
            setSelected(false);
            break;
        }
        return true;
    }

