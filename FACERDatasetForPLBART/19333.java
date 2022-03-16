    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
    	super.onSaveInstanceState(savedInstanceState);
    	savedInstanceState.putBoolean("CALLED_FROM_FOOTER", true);
    	savedInstanceState.putBoolean("CALLED_FROM_NOTIF", true);
    }

