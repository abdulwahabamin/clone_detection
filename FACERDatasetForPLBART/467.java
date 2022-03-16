    private void sendMultimediaMessage(byte[] image) {
        if (chatController.getState() != ChatController.STATE_CONNECTED) {
            Toast.makeText(this, "¡Connexión perdida!", Toast.LENGTH_SHORT).show();
            return;
        }
        chatController.write(image, tipo_mensaje);
        tipo_mensaje = "texto";
    }

