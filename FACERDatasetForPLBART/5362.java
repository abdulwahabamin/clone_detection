    @Override
    public void onClick(View view, int position) {
        if(fileDirectoryList.get(position).getFileOrDir()==FileDirectory.FILE){
            Intent i=openFile(fileDirectoryList.get(position).getPath());
            if(i!=null){
                startActivity(i);
            }
        }
        else{
            fileEx.setCurrentDir(fileDirectoryList.get(position).getPath());
            fileEx.openDir(fileDirectoryList.get(position).getName());
            dirLevel++;
            getFileList(fileEx.listFiles());
            searchListAdapter.setFileDirectoryList(fileDirectoryList);
            searchListAdapter.notifyDataSetChanged();
        }
    }

