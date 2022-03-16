    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {

        //BLog.e("ACTION MODE CREATE !!!!!!!");
        if(this.menu==null) {
            this.menu = menu;
            MenuInflater mf = activity.getMenuInflater();
            mf.inflate(useRmenu, menu);
        }
        //isActionModeShowing=true;
        return true;
    }

