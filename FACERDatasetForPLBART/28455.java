    private void cleanupExistingAnimation() {
        if (animator != null) {
            animator.cancel();
        }

        lastEmittedTimestamp = 0;
        final Iterator<Confetto> iterator = confetti.iterator();
        while (iterator.hasNext()) {
            recycledConfetti.add(iterator.next());
            iterator.remove();
        }
    }

