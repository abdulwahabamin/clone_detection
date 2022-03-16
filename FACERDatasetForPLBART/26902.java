    @Override
    public String getCondition(int code, String lang) {
        String result = null;
        for (int i = 0; conditions != null && i < conditions.length(); i++) {
            try {
                JSONObject jCondition = conditions.getJSONObject(i);
                if (jCondition.getInt("code") == code) {
                    JSONArray jLanguages = jCondition.getJSONArray("languages");
                    for (int j = 0; jLanguages != null && j < jLanguages.length(); j++) {
                        JSONObject jLanguage = jLanguages.getJSONObject(j);
                        if (lang.equals(jLanguage.getString("lang_iso"))) {
                            result = jLanguage.getString("day_text");
                            break;
                        }
                    }
                    break;
                }
            } catch(JSONException e) {
                Log.e(LOG_TAG, "Unable to get condition from json, " + e);
            }
        }
        return result;
    }

