    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

        StringBuilder selectedItems = new StringBuilder();
        boolean intercepted=false;
        if (item==menuitems.get(0)) {
            // Delete
            wipeonfinish=false;
            if(fm!=null)
                State.addCachedFileManager(fm);
            intercepted=true;
            Bgo.openFragmentBackStack(activity, new FilesDeleteFragment());

        } else if (item==menuitems.get(1)) {
            // Archive
            wipeonfinish=false;
            if(fm!=null)
                State.addCachedFileManager(fm);
            intercepted=true;
            Bgo.openFragmentBackStack(activity, new FilesArchiveFragment());

        } else if (item==menuitems.get(2)) {

            fm.moveSelectedFilesToClipboard();
            fm.isCutPasteFilesOnClipboard=true;
            intercepted=true;
            //Bgo.goPreviousFragment(activity);
            Bgo.refreshCurrentFragment(activity);
            wipeonfinish=true;

        } else {
            //BLog.e("FEF", getSelectedFilesAsJSONArray().toString());

            fm.moveSelectedFilesToClipboard();
            fm.isCutPasteFilesOnClipboard=false;
            intercepted=true;
            Bgo.refreshCurrentFragment(activity);
            wipeonfinish=true;

        }
        if(intercepted)
            mode.finish();
        return intercepted;
    }

