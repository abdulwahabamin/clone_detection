    @Override
    public void onDestroyActionMode(ActionMode mode) {

        if(!wipeonfinish)
            ActionBarManager.setActionBarBackOnlyWithLogo(activity, R.drawable.icon, activity.getResources().getString(R.string.label_files), R.menu.basic, R.color.actionbar_basic);
        else{
            if(fm!=null)
                fm.getSelectedFiles().clear();
        }
        ListView lv = (ListView) activity.findViewById(R.id.files_list);
        GridView listImages=(GridView)  activity.findViewById(R.id.files_list_grid);
        //FileManager.getSelectedFiles().clear();
        mMode=null;
        isActionModeShowing=false;
        if(lv!=null) {
            lv.invalidateViews();
        }
        if(listImages!=null) {
            listImages.invalidateViews();
        }

    }

