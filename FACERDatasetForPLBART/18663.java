		@Override
		public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
			mApp.getService().getEqualizerHelper().getCurrentBassBoost().setStrength((short) arg1);
			bassBoostLevel = (short) arg1;
			
		}

