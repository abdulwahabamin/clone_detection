    private void addNewConfetti(int numConfetti, long initialDelay) {
        for (int i = 0; i < numConfetti; i++) {
            Confetto confetto = recycledConfetti.poll();
            if (confetto == null) {
                confetto = confettoGenerator.generateConfetto(random);
            }
            configureConfetto(confetto, confettiSource, random, initialDelay);
            this.confetti.add(confetto);
        }
    }

