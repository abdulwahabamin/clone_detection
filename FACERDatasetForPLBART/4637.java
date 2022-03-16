    public void setStartAtPosition(int pos) {
        if(pos==0 || fileList.isEmpty())
            startAtPosition=0;
        else if(pos>fileList.size()-1)
            startAtPosition=fileList.size()-1;
        else
            startAtPosition=pos;
    }

