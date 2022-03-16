    @Override
    public void run() {
        int mInt;
        while(true){
            try{
                mInt=inputStream.read(messageBytes);
                //Dans le package android.os on prend Handler
                Message msg= mhandler.obtainMessage(2,mInt,-1,messageBytes);
                msg.sendToTarget();

            }catch (Exception e){

            }
        }
    }

