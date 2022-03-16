    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        //BLog.e("SAVE", "RESTORE instance state");
        isCreateStart=true;
        Bgo.clearBackStack(activity);
        State.sectionsClearBackstack();
        State.loadState(savedInstanceState);
        //isRestart=true;
        Device.hideKeyboard(this);
        //Device.updateRotation(this);


    }

