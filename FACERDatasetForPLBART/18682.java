		@SuppressWarnings("unchecked")
		@Override
		public void onPostExecute(Boolean result) {
			super.onPostExecute(result);
			
			fiftyHertzLevel = eqValues[0];
			oneThirtyHertzLevel = eqValues[1];
			threeTwentyHertzLevel = eqValues[2];
			eightHundredHertzLevel = eqValues[3];
			twoKilohertzLevel = eqValues[4];
			fiveKilohertzLevel = eqValues[5];
			twelvePointFiveKilohertzLevel = eqValues[6];
			virtualizerLevel = eqValues[7];
			bassBoostLevel = eqValues[8];
			reverbSetting = eqValues[9];
			
			//Move the sliders to the equalizer settings.
			equalizer50HzSeekBar.setProgressAndThumb(fiftyHertzLevel);
			equalizer130HzSeekBar.setProgressAndThumb(oneThirtyHertzLevel);
			equalizer320HzSeekBar.setProgressAndThumb(threeTwentyHertzLevel);
			equalizer800HzSeekBar.setProgressAndThumb(eightHundredHertzLevel);
			equalizer2kHzSeekBar.setProgressAndThumb(twoKilohertzLevel);
			equalizer5kHzSeekBar.setProgressAndThumb(fiveKilohertzLevel);
			equalizer12_5kHzSeekBar.setProgressAndThumb(twelvePointFiveKilohertzLevel);
	        virtualizerSeekBar.setProgress(virtualizerLevel);
	        bassBoostSeekBar.setProgress(bassBoostLevel);
	        reverbSpinner.setSelection(reverbSetting, false);

			//50Hz Band.
			if (fiftyHertzLevel==16) {
				text50HzGainTextView.setText("0 dB");
			} else if (fiftyHertzLevel < 16) {
				
				if (fiftyHertzLevel==0) {
					text50HzGainTextView.setText("-" + "15 dB");
				} else {
					text50HzGainTextView.setText("-" + (16-fiftyHertzLevel) + " dB");
				}
				
			} else if (fiftyHertzLevel > 16) {
				text50HzGainTextView.setText("+" + (fiftyHertzLevel-16) + " dB");
			}
			
			//130Hz Band.
			if (oneThirtyHertzLevel==16) {
				text130HzGainTextView.setText("0 dB");
			} else if (oneThirtyHertzLevel < 16) {
				
				if (oneThirtyHertzLevel==0) {
					text130HzGainTextView.setText("-" + "15 dB");
				} else {
					text130HzGainTextView.setText("-" + (16-oneThirtyHertzLevel) + " dB");
				}
				
			} else if (oneThirtyHertzLevel > 16) {
				text130HzGainTextView.setText("+" + (oneThirtyHertzLevel-16) + " dB");
			}
			
			//320Hz Band.
			if (threeTwentyHertzLevel==16) {
				text320HzGainTextView.setText("0 dB");
			} else if (threeTwentyHertzLevel < 16) {
				
				if (threeTwentyHertzLevel==0) {
					text320HzGainTextView.setText("-" + "15 dB");
				} else {
					text320HzGainTextView.setText("-" + (16-threeTwentyHertzLevel) + " dB");
				}
				
			} else if (threeTwentyHertzLevel > 16) {
				text320HzGainTextView.setText("+" + (threeTwentyHertzLevel-16) + " dB");
			}
			
			//800Hz Band.
			if (eightHundredHertzLevel==16) {
				text800HzGainTextView.setText("0 dB");
			} else if (eightHundredHertzLevel < 16) {
				
				if (eightHundredHertzLevel==0) {
					text800HzGainTextView.setText("-" + "15 dB");
				} else {
					text800HzGainTextView.setText("-" + (16-eightHundredHertzLevel) + " dB");
				}
				
			} else if (eightHundredHertzLevel > 16) {
				text800HzGainTextView.setText("+" + (eightHundredHertzLevel-16) + " dB");
			}
			
			//2kHz Band.
			if (twoKilohertzLevel==16) {
				text2kHzGainTextView.setText("0 dB");
			} else if (twoKilohertzLevel < 16) {
				
				if (twoKilohertzLevel==0) {
					text2kHzGainTextView.setText("-" + "15 dB");
				} else {
					text2kHzGainTextView.setText("-" + (16-twoKilohertzLevel) + " dB");
				}
				
			} else if (twoKilohertzLevel > 16) {
				text2kHzGainTextView.setText("+" + (twoKilohertzLevel-16) + " dB");
			}
			
			//5kHz Band.
			if (fiveKilohertzLevel==16) {
				text5kHzGainTextView.setText("0 dB");
			} else if (fiveKilohertzLevel < 16) {
				
				if (fiveKilohertzLevel==0) {
					text5kHzGainTextView.setText("-" + "15 dB");
				} else {
					text5kHzGainTextView.setText("-" + (16-fiveKilohertzLevel) + " dB");
				}
				
			} else if (fiveKilohertzLevel > 16) {
				text5kHzGainTextView.setText("+" + (fiveKilohertzLevel-16) + " dB");
			}
			
			//12.5kHz Band.
			if (twelvePointFiveKilohertzLevel==16) {
				text12_5kHzGainTextView.setText("0 dB");
			} else if (twelvePointFiveKilohertzLevel < 16) {
				
				if (twelvePointFiveKilohertzLevel==0) {
					text12_5kHzGainTextView.setText("-" + "15 dB");
				} else {
					text12_5kHzGainTextView.setText("-" + (16-twelvePointFiveKilohertzLevel) + " dB");
				}
				
			} else if (twelvePointFiveKilohertzLevel > 16) {
				text12_5kHzGainTextView.setText("+" + (twelvePointFiveKilohertzLevel-16) + " dB");
			}
			
		}

