    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_ENABLE_BLUETOOTH:
                if (resultCode == Activity.RESULT_OK) {
                    chatController = new ChatController(this, handler);
                } else {
                    Toast.makeText(this, "Bluetooth no se pudo habilitar, cerrando apñlicación", Toast.LENGTH_SHORT).show();
                    finish();
                };
            case SELECT_PICTURE:
                if (resultCode == Activity.RESULT_OK){
                    if(data != null){
                        tipo_mensaje = "imagen";
                        try{
                            Uri imgUri = data.getData();
                            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imgUri);
                            bitmap = Bitmap.createScaledBitmap(bitmap,  600 ,600, true);
                            imagen.setImageBitmap(bitmap);
                        }catch (Exception e){
                            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }else {
                    Toast.makeText(this, "Error al escoger imagen", Toast.LENGTH_SHORT).show();
                }
        }
    }

