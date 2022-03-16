    public final void cancelDialog() {
        if( dialogObj != null && dialogObj.isShowing() )
            dialogObj.cancel();
        progressCounter = 0;
        progressAcSpeed = 0;
    }

