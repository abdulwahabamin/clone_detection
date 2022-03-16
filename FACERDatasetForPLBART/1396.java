    /**
     *
     *  Some helper methods for the mHandler messaging mechanism
     *
     **/

    private void showIncomingMessage(String msg){
        mHandler.obtainMessage(Constants.MESSAGE_READ, msg.length(), -1, msg.getBytes())
                .sendToTarget();
    }

