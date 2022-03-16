        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_STATE_CHANGE:  // Si es mensaje de cambio de estado
                    switch (msg.arg1) {
                        case ChatController.STATE_CONNECTED:  // Si es estado conectado
                            setStatus("Conectado a: " + connectingDevice.getName());  // Se envía el mensaje como parámetro
                            btnConnect.setEnabled(false);  // Se deshabilita el botón de Conectar
                            break;
                        case ChatController.STATE_CONNECTING:  // Si es estado conectando
                            setStatus("Conectando...");  // Se envía el mensaje como parámetro
                            btnConnect.setEnabled(false);  // Se deshabilita el botón de Conectar
                            break;
                        case ChatController.STATE_LISTEN:
                        case ChatController.STATE_NONE:
                            setStatus("No conectado");
                            break;
                    }
                    break;
                case MESSAGE_WRITE:    // Si es mensaje escrito
                    byte[] writeBuf = (byte[]) msg.obj;

                    String writeMessage = new String(writeBuf);  // Se almacena el mensaje a mostrar
                    chatMessages.add("Yo: " + writeMessage);        // Se agrega el mensaje al arreglo de mensajes
                    chatAdapter.notifyDataSetChanged();
                    break;
                case MESSAGE_READ:      // Si es mensaje lectura
                    /*byte[] readBuf = (byte[]) msg.obj;
                    String readMessage = new String(readBuf, 0, msg.arg1);
                    chatMessages.add(connectingDevice.getName() + ":  " + readMessage);
                    chatAdapter.notifyDataSetChanged();
                    break;*/
                    byte[] readBuf = (byte[]) msg.obj;
                    try{
                        Bitmap bm = BitmapFactory.decodeByteArray(readBuf, 0, msg.arg1);
                        bm = Bitmap.createScaledBitmap(bm,  600 ,600, true);
                        imagen.setImageBitmap(bm);
                    }catch (Exception e){
                        Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }
                    break;

                case MESSAGE_DEVICE_OBJECT:     // Si es mensaje del objeto del dispositivo
                    connectingDevice = msg.getData().getParcelable(DEVICE_OBJECT);      // Se guarda los datos del dispositivo
                    Toast.makeText(getApplicationContext(), "Conectado a " + connectingDevice.getName(),
                            Toast.LENGTH_SHORT).show();
                    break;
                case MESSAGE_TOAST:
                    Toast.makeText(getApplicationContext(), msg.getData().getString("toast"),
                            Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }

