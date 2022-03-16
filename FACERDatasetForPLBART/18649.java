		@Override
		public void onProgressChanged(SeekBar arg0, int seekBarLevel, boolean changedByUser) {
			
			try {
				//Get the appropriate equalizer band.
				short threeKiloHertzBand = mApp.getService().getEqualizerHelper().getCurrentEqualizer().getBand(800000);
				
				//Set the gain level text based on the slider position.
				if (seekBarLevel==16) {
					text800HzGainTextView.setText("0 dB");
					mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(threeKiloHertzBand, (short) 0);
				} else if (seekBarLevel < 16) {
					
					if (seekBarLevel==0) {
						text800HzGainTextView.setText("-" + "15 dB");
						mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(threeKiloHertzBand, (short) (-1500));
					} else {
						text800HzGainTextView.setText("-" + (16-seekBarLevel) + " dB");
						mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(threeKiloHertzBand, (short) -((16-seekBarLevel)*100));
					}
					
				} else if (seekBarLevel > 16) {
					text800HzGainTextView.setText("+" + (seekBarLevel-16) + " dB");
					mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(threeKiloHertzBand, (short) ((seekBarLevel-16)*100));
				}
				
				eightHundredHertzLevel = seekBarLevel;
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

