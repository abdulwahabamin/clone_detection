    public void close(){
        if (connectedThread==null)
        {
            return;
        }
        try {
            connectedThread.cancel();
            connectedThread=null;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

