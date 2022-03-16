		@Override
		public void onProgressChanged(SeekBar arg0, int seekBarLevel, boolean changedByUser) {
			
			try {
				//Get the appropriate equalizer band.
				short nineTenHertzBand = mApp.getService().getEqualizerHelper().getCurrentEqualizer().getBand(320000);
				
				//Set the gain level text based on the slider position.
				if (seekBarLevel==16) {
					text320HzGainTextView.setText("0 dB");
					mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(nineTenHertzBand, (short) 0);
				} else if (seekBarLevel < 16) {
					
					if (seekBarLevel==0) {
						text320HzGainTextView.setText("-" + "15 dB");
						mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(nineTenHertzBand, (short) (-1500));
					} else {
						text320HzGainTextView.setText("-" + (16-seekBarLevel) + " dB");
						mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(nineTenHertzBand, (short) -((16-seekBarLevel)*100));
					}
					
				} else if (seekBarLevel > 16) {
					text320HzGainTextView.setText("+" + (seekBarLevel-16) + " dB");
					mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(nineTenHertzBand, (short) ((seekBarLevel-16)*100));
				}
				
				threeTwentyHertzLevel = seekBarLevel;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

