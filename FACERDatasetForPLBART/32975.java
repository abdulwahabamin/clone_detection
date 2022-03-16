        @Override
        public VoiceSettingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(VoiceSettingsActivity.this);
            View v = inflater.inflate(R.layout.voice_setting_item, parent, false);
            return new VoiceSettingHolder(v);
        }

