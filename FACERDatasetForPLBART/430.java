        @Override
        public boolean handleMessage(Message msg) {

            // Handler : UI Thread ile haberleşmeyi sağlayan bir sınıftır.
            switch (msg.what){

                // what : kullanıcı tanımlı mesaj kodudur.
                // Bu mesajın neyle ilgili olduğuna kullanıcı karar verebilir.
                // int tipinde tanımlanır.

                // STATE_LISTENING değeriyse
                case STATE_LISTENING:

                    // Listening texti yaz
                    status.setText("Listening");
                    break;

                // STATE_CONNECTING değeriyse
                case STATE_CONNECTING:

                    // Connecting texti yaz
                    status.setText("Connecting");
                    break;

                // STATE_CONNECTED değeriyse
                case STATE_CONNECTED:

                    // Connected texti yaz
                    status.setText("Connected");
                    break;

                // STATE_CONNECTION_FAILED değeriyse
                case STATE_CONNECTION_FAILED:

                    // Connection Failed texti yaz
                    status.setText("Connection Failed");
                    break;

                // STATE_MESSAGE_RECEIVED değeriyse
                case STATE_MESSAGE_RECEIVED:

                    // readBuffer değişkeni mesaj objesini al
                    byte[] readBuffer = (byte[]) msg.obj;

                    // tempMessage değişkine değerler işleniyor
                    String tempMessage = new String(readBuffer,0,msg.arg1);

                    // messageBox değerine mesajları yaz
                    messageBox.setText(tempMessage);

                    // işlemi bitir.
                    break;
            }

            // değeri true döndür
            return true;
        }

