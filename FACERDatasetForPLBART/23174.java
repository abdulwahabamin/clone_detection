        @Override
            public void run() {
                while (true) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    Log.d("Runwa", "run: " + 1);
                    if (mediaPlayer != null) {
                        seekBar.post(new Runnable() {
                            @Override
                            public void run() {
                                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                            }
                        });

                        Log.d("Runwa", "run: " + mediaPlayer.getCurrentPosition());
                    }
                }
            }

