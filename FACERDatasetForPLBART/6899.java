    @Override
    public void onBackPressed() {
        if(ifSearching){
            ifSearching=false;
            showChanged(getPathString());
        }else{
            if(nowPathStack.peek()==rootPath){
                super.onBackPressed();
            }else{
                nowPathStack.pop();
                showChanged(getPathString());
            }
        }
    }

