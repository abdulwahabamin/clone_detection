    public void SendMessage(View view){

        if(connectToServerThread != null){
            new WriteTask().execute(txtMessage.getText().toString());
        }
        else{
            Toast.makeText(this, "Seleccione un cliente primero", Toast.LENGTH_SHORT).show();
        }
    }

