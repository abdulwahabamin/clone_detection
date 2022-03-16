    private void setEmojiconFragment(boolean useSystemDefault) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.chat_emojicons, EmojiconsFragment.newInstance(useSystemDefault))
                .commit();
    }

