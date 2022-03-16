    @Override
    public void onBackPressed() {
        if(selectionList.size()>0){
            mediaAdapter.disableSelection();
        }
        else{
            super.onBackPressed();
        }
    }

