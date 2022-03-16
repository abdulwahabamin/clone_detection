    @Override
    protected void onPause() {
        EventBus.getDefault().unregister(this);
        MyApplication.currentWindow="";
        saveData();

        try{
            if (thread instanceof AcceptThread)
            {
                ((AcceptThread) thread).cancel();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        super.onPause();
    }

