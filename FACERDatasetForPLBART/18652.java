		@Override
		public void onProgressChanged(SeekBar arg0, int seekBarLevel, boolean changedByUser) {
			
			try {
				//Get the appropriate equalizer band.
				short fourteenKiloHertzBand = mApp.getService().getEqualizerHelper().getCurrentEqualizer().getBand(2000000);
				
				//Set the gain level text based on the slider position.
				if (seekBarLevel==16) {
					text2kHzGainTextView.setText("0 dB");
					mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(fourteenKiloHertzBand, (short) 0);
				} else if (seekBarLevel < 16) {
					
					if (seekBarLevel==0) {
						text2kHzGainTextView.setText("-" + "15 dB");
						mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(fourteenKiloHertzBand, (short) (-1500));
					} else {
						text2kHzGainTextView.setText("-" + (16-seekBarLevel) + " dB");
						mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(fourteenKiloHertzBand, (short) -((16-seekBarLevel)*100));
					}
					
				} else if (seekBarLevel > 16) {
					text2kHzGainTextView.setText("+" + (seekBarLevel-16) + " dB");
					mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(fourteenKiloHertzBand, (short) ((seekBarLevel-16)*100));
				}
				
				twoKilohertzLevel = seekBarLevel;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

