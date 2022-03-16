    @Override
    public synchronized  void close(){
        if(myDatabase != null){
            myDatabase.close();
        }
        super.close();
    }

