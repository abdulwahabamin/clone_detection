        @Override
    public void handleMessage(Message msg){
            int numOfBytesReceived = msg.arg1;
            byte[] buffer = (byte[]) msg.obj;
            // Convertir el array de Byte en una cadena. //
            String strReceived = new String(buffer);
            // Sé extrae sólo la cadena recibida. //
            strReceived = strReceived.substring(0, numOfBytesReceived);
            //Mostrar en el TextView el texto que se ha recibido. //
            txtData.setText(txtData.getText().toString() + strReceived);
        }

