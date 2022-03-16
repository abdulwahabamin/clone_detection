    protected void removeNightView(){
        if(mNightView!=null) {
            mWindowManager.removeViewImmediate(mNightView);
            mNightView = null;
        }
    }

