        ReadWriteThread(BluetoothSocket client)
        {
            try {
                in = client.getInputStream();
                out = client.getOutputStream();
            }
            catch(Exception e)
            {}
        }

