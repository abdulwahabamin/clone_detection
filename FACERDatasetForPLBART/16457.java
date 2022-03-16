    final void bandageExceptionHappened(Throwable throwable) {
        try {//�?�获监�?�中异常，防止使用方代�?抛出异常时导致的�??�?调用
            onBandageExceptionHappened(throwable);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

