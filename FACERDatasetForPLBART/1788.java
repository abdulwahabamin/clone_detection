    @Subscribe(threadMode = ThreadMode.MAIN)
    public void storeMessage(MessageEvent me) {

        if (!me.macAddress_other.equals(macAddress_other))
        {
            return;
        }

        String data;

        String who;
        if (me.message.what== BluetoothService.MessageConstants.MESSAGE_READ)
        {
            data = new String(((byte[]) me.message.obj),0,me.message.arg1);
            who=macAddress_other;
        }else
        {
            data = new String((byte[]) me.message.obj);
            who=macAddress_my;
        }

        list.add(0,new Message(data,who,System.currentTimeMillis(),0));
        cAdapter.notifyItemInserted(0);
    }

