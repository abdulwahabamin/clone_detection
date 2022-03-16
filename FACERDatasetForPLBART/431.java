        public ServerClass(){

            try{
                // serverSocket değerine uuid değerini kayıtla
                serverSocket = bluetoothAdapter.listenUsingRfcommWithServiceRecord(APP_NAME,MY_UUID);

                // IOException yakalama
            }catch (IOException e){
                // hatayı bastır
                e.printStackTrace();
            }
        }

