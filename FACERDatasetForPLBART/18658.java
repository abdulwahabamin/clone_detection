		@Override
		public void onProgressChanged(SeekBar arg0, int seekBarLevel, boolean changedByUser) {
			
			try {
				//Get the appropriate equalizer band.
				short twelvePointFiveKiloHertzBand = mApp.getService().getEqualizerHelper().getCurrentEqualizer().getBand(9000000);
				
				//Set the gain level text based on the slider position.
				if (seekBarLevel==16) {
					text12_5kHzGainTextView.setText("0 dB");
					mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(twelvePointFiveKiloHertzBand, (short) 0);
				} else if (seekBarLevel < 16) {
					
					if (seekBarLevel==0) {
						text12_5kHzGainTextView.setText("-" + "15 dB");
						mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(twelvePointFiveKiloHertzBand, (short) (-1500));
					} else {
						text12_5kHzGainTextView.setText("-" + (16-seekBarLevel) + " dB");
						mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(twelvePointFiveKiloHertzBand, (short) -((16-seekBarLevel)*100));
					}
					
				} else if (seekBarLevel > 16) {
					text12_5kHzGainTextView.setText("+" + (seekBarLevel-16) + " dB");
					mApp.getService().getEqualizerHelper().getCurrentEqualizer().setBandLevel(twelvePointFiveKiloHertzBand, (short) ((seekBarLevel-16)*100));
				}
				
				twelvePointFiveKilohertzLevel = seekBarLevel;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

