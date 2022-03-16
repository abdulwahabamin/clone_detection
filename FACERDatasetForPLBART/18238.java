    /**
     * Public method that provides access to the onProgressUpdate() method.
     * Used to update the progress bar from a different class/activity.
     * 
     * @param progressParams 
     */
    public void callOnProgressUpdate(String... progressParams) {
    	publishProgress(progressParams);
    }

