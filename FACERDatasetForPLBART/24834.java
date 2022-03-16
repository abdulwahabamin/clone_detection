    private boolean checkAndRequestAudioFocus() {
        if (mAudioManagerHelper.hasAudioFocus() == false) {
            if (requestAudioFocus() == true) {
                return true;
            } else {
                return false;
            }

        } else {
            return true;
        }

    }

