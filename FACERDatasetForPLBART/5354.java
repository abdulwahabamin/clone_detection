    @Override
    public void onItemListChanged(List<FileDirectory> list) {
        selectionList=list;
        if(selectionList.size()>0){
            share.setVisibility(View.VISIBLE);
            delete.setVisibility(View.VISIBLE);
        }else{
            share.setVisibility(View.GONE);
            delete.setVisibility(View.GONE);
        }
    }

