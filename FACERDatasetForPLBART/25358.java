    public static PlayMode getUpdateCurrentPlayMode(PlayMode newPlayMode) {
        if (newPlayMode == PlayMode.SHUFFLE) {
            if (currentPlayMode == PlayMode.NONE || currentPlayMode == PlayMode.SINGLE_REPEAT) {
                currentPlayMode = PlayMode.SHUFFLE;
            } else if (currentPlayMode == PlayMode.ALL_REPEAT) {
                currentPlayMode = PlayMode.SHUFFLE_REPEAT;
            } else if (currentPlayMode == PlayMode.SHUFFLE_REPEAT) {
                currentPlayMode = PlayMode.ALL_REPEAT;
            } else if (currentPlayMode == PlayMode.SHUFFLE) {
                currentPlayMode = PlayMode.NONE;
            }
        } else if (newPlayMode == PlayMode.REPEAT) {
            if (currentPlayMode == PlayMode.NONE) {
                currentPlayMode = PlayMode.SINGLE_REPEAT;
            } else if (currentPlayMode == PlayMode.SINGLE_REPEAT) {
                currentPlayMode = PlayMode.ALL_REPEAT;
            } else if (currentPlayMode == PlayMode.ALL_REPEAT) {
                currentPlayMode = PlayMode.NONE;
            } else if (currentPlayMode == PlayMode.SHUFFLE) {
                currentPlayMode = PlayMode.SHUFFLE_REPEAT;
            } else if (currentPlayMode == PlayMode.SHUFFLE_REPEAT) {
                currentPlayMode = PlayMode.SHUFFLE;
            }
        }
        return currentPlayMode;
    }

