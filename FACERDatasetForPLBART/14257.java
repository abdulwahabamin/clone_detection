    public static void notifyWidgets(String what){ 
        try {
        	mService.notifyChange(what);
        } catch (Exception e) {
        }
    }

