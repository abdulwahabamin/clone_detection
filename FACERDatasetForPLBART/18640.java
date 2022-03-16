		@Override
		public void onProgressChanged(SeekBar arg0, int seekBarLevel, boolean changedByUser) {
			
			try {
				//Get the appropriate equalizer band.
				short sixtyHertzBand = mApp.getService().getEqualizerHelper().getCurrentEqualizer().getBand(50000);
				
				//Set the gain level text based on the slider position.
				if (seekBarLevel==16) {
					text50HzGainTextView.setText("0 dB");
					mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(sixtyHertzBand, (short) 0);
				} else if (seekBarLevel < 16) {
					
					if (seekBarLevel==0) {
						text50HzGainTextView.setText("-" + "15 dB");
						mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(sixtyHertzBand, (short) (-1500));
					} else {
						text50HzGainTextView.setText("-" + (16-seekBarLevel) + " dB");
						mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(sixtyHertzBand, (short) -((16-seekBarLevel)*100));
					}
					
				} else if (seekBarLevel > 16) {
					text50HzGainTextView.setText("+" + (seekBarLevel-16) + " dB");
					mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(sixtyHertzBand, (short) ((seekBarLevel-16)*100));
				}
				
				fiftyHertzLevel = seekBarLevel;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

