    @Override
    public void onBackPressed() {

        if(dirLevel==1){
            searchListAdapter.setFileDirectoryList(searchResultList);
            searchListAdapter.notifyDataSetChanged();
            dirLevel--;
        }

        else if(dirLevel>1){
            fileEx.goUp();
            searchListAdapter.setFileDirectoryList(getFileList(fileEx.listFiles()));
            searchListAdapter.notifyDataSetChanged();
            dirLevel--;
        }

        else{
            NavUtils.navigateUpFromSameTask(this);
        }
    }

