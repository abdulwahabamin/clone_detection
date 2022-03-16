        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_CLEAR_AUTHORIZATIONS:
                    // Remove authorization
                    UUID uuid = UUID.fromString(msg.getData().getString(EXTRA_AUTH_ID));
                    AUTHORIZATIONS.remove(uuid);
                    break;

                default:
                    break;
            }
            return true;
        }

