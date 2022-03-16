    @Subscribe(threadMode = ThreadMode.MAIN)
    public void storeMessage(MessageEvent me) {
        long current_time=System.currentTimeMillis();
        Utils.log("storing in application"+me.toString());
        String data;
        if (me.message.what== BluetoothService.MessageConstants.MESSAGE_READ)
        {
            data = new String(((byte[]) me.message.obj),0,me.message.arg1);

        }else
        {
            data = new String((byte[]) me.message.obj);
        }

        if (user==null)
        {
            Number n;
            final int m_id;

            RealmManager.getRealm().beginTransaction();

            n=RealmManager.getRealm().where(User.class).max("message_id");
            if (n==null)
            {
                m_id=1;
            }else
            {
                m_id=n.intValue()+1;
            }
            user=new User(me.user_name,me.macAddress_other,m_id);
            user=RealmManager.getRealm().copyToRealm(user);
            Utils.log("user created");
            RealmManager.getRealm().commitTransaction();
        }

        RealmManager.getRealm().beginTransaction();
        user.last_message = data;
        user.last_msg_time = current_time;
        RealmManager.getRealm().commitTransaction();

        RealmManager.saveData(new model.Message(data,me.macAddress,current_time,user.message_id));
        if (me.message.what== BluetoothService.MessageConstants.MESSAGE_READ)
        {
            showNotification(me.macAddress_other,me.user_name,data);
        }
    }

