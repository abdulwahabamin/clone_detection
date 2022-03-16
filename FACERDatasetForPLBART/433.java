        public ClientClass(BluetoothDevice device1){

            // nesneye device değerine device1'i ata
            device = device1;

            try{
                // uuid değerine socket işine ata
                socket = device.createRfcommSocketToServiceRecord(MY_UUID);

                // hatayı yakala
            } catch (IOException e) {
                // hatayı yazdır
                e.printStackTrace();
            }
        }

