    @Override
    public void onDestroyActionMode(ActionMode mode) {
        //BLog.e("ACTION MODE onDestroyActionMode");
        if(isActionModeShowing) {
            //BLog.e("ACTION MODE BACK CALLING PREVIOUS FRAGMENT");
            Bgo.goPreviousFragment(activity);
        }

    }

