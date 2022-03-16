        public void run(){

            // buffer nesnesi oluşturma
            byte [] buffer = new byte[1024];

            // bytes değişkeni
            int bytes;

            // true değeri döndükçe
            while (true){

                try {
                    // bytes değişkenine read buffer yap.
                    bytes = inputStream.read(buffer);

                    // parametreleri tutan bir mesaj oluşturmak için kullanılır.
                    handler.obtainMessage(STATE_MESSAGE_RECEIVED,bytes,-1,buffer).sendToTarget();

                   // hatayı yakalama işlemi
                } catch (IOException e) {
                    // hatayı yazdır
                    e.printStackTrace();
                }
            }
        }

