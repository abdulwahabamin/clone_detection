        @Override
        public void onPlay() {
            FireLog.d(TAG, "(++) onPlay");
            if (queueManager.getCurrentMusic() == null) {
//                queueManager.setRandomQueue();
                Toast.makeText(((Service) serviceCallback).getApplicationContext(), "no queue", Toast.LENGTH_LONG).show();
            }
            handlePlayRequest();
        }

