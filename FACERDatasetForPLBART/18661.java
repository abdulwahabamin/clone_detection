		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
			
			if (mApp.isServiceRunning())
				if (index==0) {
					mApp.getService().getEqualizerHelper().getCurrentReverb().setPreset(PresetReverb.PRESET_NONE);
					reverbSetting = 0;
				} else if (index==1) {
					mApp.getService().getEqualizerHelper().getCurrentReverb().setPreset(PresetReverb.PRESET_LARGEHALL);
					reverbSetting = 1;
				} else if (index==2) {
					mApp.getService().getEqualizerHelper().getCurrentReverb().setPreset(PresetReverb.PRESET_LARGEROOM);
					reverbSetting = 2;
				} else if (index==3) {
					mApp.getService().getEqualizerHelper().getCurrentReverb().setPreset(PresetReverb.PRESET_MEDIUMHALL);
					reverbSetting = 3;
				} else if (index==4) {
					mApp.getService().getEqualizerHelper().getCurrentReverb().setPreset(PresetReverb.PRESET_MEDIUMROOM);
					reverbSetting = 4;
				} else if (index==5) {
					mApp.getService().getEqualizerHelper().getCurrentReverb().setPreset(PresetReverb.PRESET_SMALLROOM);
					reverbSetting = 5;
				} else if (index==6) {
					mApp.getService().getEqualizerHelper().getCurrentReverb().setPreset(PresetReverb.PRESET_PLATE);
					reverbSetting = 6;
				}
			
			else
				reverbSetting = 0;
		}

