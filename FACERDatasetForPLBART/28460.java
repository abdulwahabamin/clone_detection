    private void updateConfetti(long elapsedTime) {
        final Iterator<Confetto> iterator = confetti.iterator();
        while (iterator.hasNext()) {
            final Confetto confetto = iterator.next();
            if (!confetto.applyUpdate(elapsedTime)) {
                iterator.remove();
                recycledConfetti.add(confetto);
            }
        }
    }

