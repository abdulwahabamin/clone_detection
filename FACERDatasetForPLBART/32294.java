        @Override
        public void run() {
            if (context == null) {
                return;
            }
            sendMessageToWeatherByVoiceService(context);
        }

