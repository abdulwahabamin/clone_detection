        public void run(){

            try {

                // socket'i connect et.
                socket.connect();

                // bir mesaj örneği alabilmek için bu metot kullanılır. Alınan mesaja istediğimiz değerler verilir.
                Message message = Message.obtain();

                // kullanıcı tanımlı mesaj kodudur. Int tipinde tanımlanır.
                message.what = STATE_CONNECTED;

                // mesaj kuyruğunun sonuna bir mesaj eklemeyi sağlar.
                handler.sendMessage(message);

                // sendReceive nesnesi işlemi
                sendReceive = new SendReceive(socket);

                // sendReceive başlat
                sendReceive.start();

            } catch (IOException e) {
                e.printStackTrace();

                // Alınan message istediğimiz değerler verilir.
                Message message = Message.obtain();

                // eğer fail olduysa değer
                message.what = STATE_CONNECTION_FAILED;

                // handler sendmessage işlemi
                handler.sendMessage(message);
            }
        }

