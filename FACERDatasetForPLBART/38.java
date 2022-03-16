    BluetoothChatService(boolean isClient,BluetoothDevice bd,Handler h)
    {
        this.h=h;
        if(isClient==true)
        {
            ClientThread ct=new ClientThread(bd);
            ct.start();
        }
        else
        {
            ServerThread st=new ServerThread();
            st.start();
        }
    }

