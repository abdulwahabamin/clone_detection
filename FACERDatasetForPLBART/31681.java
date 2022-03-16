    private void setTextHandler(int textViewId, final VoiceSettingParamType paramType) {
        EditText textView = (EditText)findViewById(textViewId);

        String originalValue = voiceSettingParametersDbHelper.getStringParam(
                voiceSettingId,
                paramType.getVoiceSettingParamTypeId());

        textView.setText(originalValue, TextView.BufferType.EDITABLE);
        textView.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0)
                    voiceSettingParametersDbHelper.saveStringParam(
                            voiceSettingId,
                            paramType.getVoiceSettingParamTypeId(),
                            s.toString());
                }
            }
        );
    }

