    private Long enableAndFillCustomText(int index,
                                         boolean checked,
                                         Long partsToSay,
                                         int editTextId,
                                         int defaultSayText,
                                         int originalTextId) {
        if (checked) {
            partsToSay += TimeUtils.getTwoPower(index);
            EditText customText = findViewById(editTextId);
            customText.setVisibility(View.VISIBLE);
            if (TextUtils.isEmpty(customText.getText())) {
                customText.setText(getString(defaultSayText));
            }
            TextView originalText = findViewById(originalTextId);
            originalText.setTextColor(Color.GRAY);
        } else {
            partsToSay -= TimeUtils.getTwoPower(index);
            findViewById(editTextId).setVisibility(View.GONE);
            TextView originalText = findViewById(originalTextId);
            originalText.setTextColor(Color.BLACK);
        }
        return partsToSay;
    }

