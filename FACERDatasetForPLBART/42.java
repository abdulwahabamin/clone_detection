        @Override
        public void run() {
            try {
                BluetoothSocket client = bd.createInsecureRfcommSocketToServiceRecord(UUID.fromString("4e5d48e0-75df-11e3-981f-0800200c9a66"));
                client.connect();
                rwt=new ReadWriteThread(client);
                rwt.start();;
            }
            catch(Exception e)
            {}
        }

