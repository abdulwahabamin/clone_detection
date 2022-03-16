        void save() {
            if (!cachedirty) return;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putStringSet(PREFERENCE_CACHE_NAME, queries);
            editor.apply();
        }

