	/**
	 * Retrieves the EQ values for mMediaPlayer's current song and 
	 * applies them to the EQ engine.
	 * 
	 * @param songId The id of the song that mMediaPlayer is current handling.
	 */
	private void applyMediaPlayerEQ(String songId) {
		
		if (mEqualizerHelper==null)
			return;
		
		short fiftyHertzBand = mEqualizerHelper.getEqualizer().getBand(50000);
		short oneThirtyHertzBand = mEqualizerHelper.getEqualizer().getBand(130000);
		short threeTwentyHertzBand = mEqualizerHelper.getEqualizer().getBand(320000);
		short eightHundredHertzBand = mEqualizerHelper.getEqualizer().getBand(800000);
		short twoKilohertzBand = mEqualizerHelper.getEqualizer().getBand(2000000);
		short fiveKilohertzBand = mEqualizerHelper.getEqualizer().getBand(5000000);
		short twelvePointFiveKilohertzBand = mEqualizerHelper.getEqualizer().getBand(9000000);

		//Get the equalizer/audioFX settings for this specific song.
		int[] eqValues = mApp.getDBAccessHelper().getSongEQValues(songId);

		//50Hz Band.
		if (eqValues[0]==16) {
			mEqualizerHelper.getEqualizer().setBandLevel(fiftyHertzBand, (short) 0);
		} else if (eqValues[0] < 16) {
			
			if (eqValues[0]==0) {
				mEqualizerHelper.getEqualizer().setBandLevel(fiftyHertzBand, (short) -1500);
			} else {
				mEqualizerHelper.getEqualizer().setBandLevel(fiftyHertzBand, (short) (-(16-eqValues[0])*100));
			}
			
		} else if (eqValues[0] > 16) {
			mEqualizerHelper.getEqualizer().setBandLevel(fiftyHertzBand, (short) ((eqValues[0]-16)*100));
		}
		
		//130Hz Band.
		if (eqValues[1]==16) {
			mEqualizerHelper.getEqualizer().setBandLevel(oneThirtyHertzBand, (short) 0);
		} else if (eqValues[1] < 16) {
			
			if (eqValues[1]==0) {
				mEqualizerHelper.getEqualizer().setBandLevel(oneThirtyHertzBand, (short) -1500);
			} else {
				mEqualizerHelper.getEqualizer().setBandLevel(oneThirtyHertzBand, (short) (-(16-eqValues[1])*100));
			}
			
		} else if (eqValues[1] > 16) {
			mEqualizerHelper.getEqualizer().setBandLevel(oneThirtyHertzBand, (short) ((eqValues[1]-16)*100));
		}
		
		//320Hz Band.
		if (eqValues[2]==16) {
			mEqualizerHelper.getEqualizer().setBandLevel(threeTwentyHertzBand, (short) 0);
		} else if (eqValues[2] < 16) {
			
			if (eqValues[2]==0) {
				mEqualizerHelper.getEqualizer().setBandLevel(threeTwentyHertzBand, (short) -1500);
			} else {
				mEqualizerHelper.getEqualizer().setBandLevel(threeTwentyHertzBand, (short) (-(16-eqValues[2])*100));
			}
			
		} else if (eqValues[2] > 16) {
			mEqualizerHelper.getEqualizer().setBandLevel(threeTwentyHertzBand, (short) ((eqValues[2]-16)*100));
		}
		
		//800Hz Band.
		if (eqValues[3]==16) {
			mEqualizerHelper.getEqualizer().setBandLevel(eightHundredHertzBand, (short) 0);
		} else if (eqValues[3] < 16) {
			
			if (eqValues[3]==0) {
				mEqualizerHelper.getEqualizer().setBandLevel(eightHundredHertzBand, (short) -1500);
			} else {
				mEqualizerHelper.getEqualizer().setBandLevel(eightHundredHertzBand, (short) (-(16-eqValues[3])*100));
			}
			
		} else if (eqValues[3] > 16) {
			mEqualizerHelper.getEqualizer().setBandLevel(eightHundredHertzBand, (short) ((eqValues[3]-16)*100));
		}
		
		//2kHz Band.
		if (eqValues[4]==16) {
			mEqualizerHelper.getEqualizer().setBandLevel(twoKilohertzBand, (short) 0);
		} else if (eqValues[4] < 16) {
			
			if (eqValues[4]==0) {
				mEqualizerHelper.getEqualizer().setBandLevel(twoKilohertzBand, (short) -1500);
			} else {
				mEqualizerHelper.getEqualizer().setBandLevel(twoKilohertzBand, (short) (-(16-eqValues[4])*100));
			}
			
		} else if (eqValues[4] > 16) {
			mEqualizerHelper.getEqualizer().setBandLevel(twoKilohertzBand, (short) ((eqValues[4]-16)*100));
		}
		
		//5kHz Band.
		if (eqValues[5]==16) {
			mEqualizerHelper.getEqualizer().setBandLevel(fiveKilohertzBand, (short) 0);
		} else if (eqValues[5] < 16) {
			
			if (eqValues[5]==0) {
				mEqualizerHelper.getEqualizer().setBandLevel(fiveKilohertzBand, (short) -1500);
			} else {
				mEqualizerHelper.getEqualizer().setBandLevel(fiveKilohertzBand, (short) (-(16-eqValues[5])*100));
			}
			
		} else if (eqValues[5] > 16) {
			mEqualizerHelper.getEqualizer().setBandLevel(fiveKilohertzBand, (short) ((eqValues[5]-16)*100));
		}
		
		//12.5kHz Band.
		if (eqValues[6]==16) {
			mEqualizerHelper.getEqualizer().setBandLevel(twelvePointFiveKilohertzBand, (short) 0);
		} else if (eqValues[6] < 16) {
			
			if (eqValues[6]==0) {
				mEqualizerHelper.getEqualizer().setBandLevel(twelvePointFiveKilohertzBand, (short) -1500);
			} else {
				mEqualizerHelper.getEqualizer().setBandLevel(twelvePointFiveKilohertzBand, (short) (-(16-eqValues[6])*100));
			}
			
		} else if (eqValues[6] > 16) {
			mEqualizerHelper.getEqualizer().setBandLevel(twelvePointFiveKilohertzBand, (short) ((eqValues[6]-16)*100));
		}
		
		//Set the audioFX values.
		mEqualizerHelper.getVirtualizer().setStrength((short) eqValues[7]);
		mEqualizerHelper.getBassBoost().setStrength((short) eqValues[8]);
		
		if (eqValues[9]==0) {
			mEqualizerHelper.getReverb().setPreset(PresetReverb.PRESET_NONE);
		} else if (eqValues[9]==1) {
			mEqualizerHelper.getReverb().setPreset(PresetReverb.PRESET_LARGEHALL);
		} else if (eqValues[9]==2) {
			mEqualizerHelper.getReverb().setPreset(PresetReverb.PRESET_LARGEROOM);
		} else if (eqValues[9]==3) {
			mEqualizerHelper.getReverb().setPreset(PresetReverb.PRESET_MEDIUMHALL);
		} else if (eqValues[9]==4) {
			mEqualizerHelper.getReverb().setPreset(PresetReverb.PRESET_MEDIUMROOM);
		} else if (eqValues[9]==5) {
			mEqualizerHelper.getReverb().setPreset(PresetReverb.PRESET_SMALLROOM);
		} else if (eqValues[9]==6) {
			mEqualizerHelper.getReverb().setPreset(PresetReverb.PRESET_PLATE);
		}
		
	}

