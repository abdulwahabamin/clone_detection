        @Override
        public void run() {
            try {
                BluetoothServerSocket server = adapter.listenUsingInsecureRfcommWithServiceRecord("server", UUID.fromString("4e5d48e0-75df-11e3-981f-0800200c9a66"));
                BluetoothSocket client = server.accept();
                BluetoothDevice bd = client.getRemoteDevice();
                String name = bd.getName();
                h.obtainMessage(1, name).sendToTarget();
                rwt=new ReadWriteThread(client);
                rwt.start();
            }
            catch(Exception e)
            {}
        }

