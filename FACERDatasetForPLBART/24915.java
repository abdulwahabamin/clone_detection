    void setHandler(){
        mHandler1=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                Log.e("call",String.valueOf(counter));
                counter++;
                runAction();
                return false;
            }
        });
    }

