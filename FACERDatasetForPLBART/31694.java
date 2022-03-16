        private void setNewTextTime(int hourOfDay, int minute) {
            final Calendar c = Calendar.getInstance();
            c.set(Calendar.HOUR_OF_DAY, hourOfDay);
            c.set(Calendar.MINUTE, minute);

            Button voiceSettingButton = (Button) getActivity().findViewById(R.id.button_voice_setting_time);
            voiceSettingButton.setText(AppPreference.getLocalizedTime(getContext(), c.getTime(), applicationLocale));
            prepareNextTime(getActivity(), voiceSettingId, applicationLocale, voiceSettingParametersDbHelper);
        }

