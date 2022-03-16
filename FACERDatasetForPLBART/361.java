    public void write(final String msg){
        try{
                outputStream.write(msg.getBytes());
                outputStream.flush();

                Message msg_sended= mhandler.obtainMessage(1,msg);
                msg_sended.sendToTarget();

        }catch (Exception e2){
            Toast.makeText(context,"On n'a pas pu écrire le message",Toast.LENGTH_SHORT).show();
        }
    }

