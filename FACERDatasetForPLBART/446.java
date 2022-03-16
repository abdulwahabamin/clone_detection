    public void write(byte[] out, String tipo_mensaje) {
        tipo_envio = tipo_mensaje;

        ReadWriteThread r;
        synchronized (this) {
            if (state != STATE_CONNECTED)
                return;
            r = connectedThread;
        }
        r.write(out, tipo_envio);
    }

