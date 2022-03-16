		@Override
		public void onProgressChanged(SeekBar arg0, int seekBarLevel, boolean changedByUser) {
			
			try {
				//Get the appropriate equalizer band.
				short twoThirtyHertzBand = mApp.getService().getEqualizerHelper().getCurrentEqualizer().getBand(130000);
				
				//Set the gain level text based on the slider position.
				if (seekBarLevel==16) {
					text130HzGainTextView.setText("0 dB");
					mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(twoThirtyHertzBand, (short) 0);
				} else if (seekBarLevel < 16) {
					
					if (seekBarLevel==0) {
						text130HzGainTextView.setText("-" + "15 dB");
						mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(twoThirtyHertzBand, (short) (-1500));
					} else {
						text130HzGainTextView.setText("-" + (16-seekBarLevel) + " dB");
						mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(twoThirtyHertzBand, (short) -((16-seekBarLevel)*100));
					}
					
				} else if (seekBarLevel > 16) {
					text130HzGainTextView.setText("+" + (seekBarLevel-16) + " dB");
					mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(twoThirtyHertzBand, (short) ((seekBarLevel-16)*100));
				}
				
				oneThirtyHertzLevel = seekBarLevel;
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

