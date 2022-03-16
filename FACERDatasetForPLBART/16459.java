    final void mayBeBlackScreen(Throwable e) {
        try {
            onMayBeBlackScreen(e);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

