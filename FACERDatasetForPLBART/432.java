        public void run(){

            // BluetoothSocket nesnesine null verildi.
            BluetoothSocket socket = null;

            // socket değeri null ise
            while (socket == null){

                try{

                    // Alınan mesajı istediğimiz değerleri verebiliriz.
                    Message message = Message.obtain();

                    // bağlantı oluştuğunda
                    message.what = STATE_CONNECTING;

                    // mesajı yollama işi
                    handler.sendMessage(message);

                    // socket işini kabul et
                    socket = serverSocket.accept();

                } catch (IOException e) {
                    e.printStackTrace();

                    // mesaj örneğini alma işi
                    Message message = Message.obtain();

                    // STATE_CONNECTION_FAILED olayı olunca
                    message.what = STATE_CONNECTION_FAILED;

                    // mesajı yollama
                    handler.sendMessage(message);
                }

                // socket değeri null değilse
                if (socket!=null){

                    // Alınan mesajı istediğimiz değerleri verebiliriz.
                    Message message = Message.obtain();

                    // bağlantı oluştuğunu anlama işi
                    message.what = STATE_CONNECTED;

                    // mesajı yollama işini handler ile yap
                    handler.sendMessage(message);


                    // sendReceive nesnesi tanımı
                    sendReceive = new SendReceive(socket);

                    // sendReceive işini başlat
                    sendReceive.start();

                    // işlemi kırk bırak
                    break;
                }

            }
        }

