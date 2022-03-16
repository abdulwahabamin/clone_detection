    /**
     * Make a printable string of this JSONTokener.
     *
     * @return " at {index} [character {character} line {line}]"
     */
    public String toString() {
        return " at " + this.index + " [character " + this.character + " line " +
            this.line + "]";
    }

