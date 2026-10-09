abstract class Instrument {
    protected String name;

    public Instrument(String name) {
        this.name = name;
    }

    public abstract void play();
    public abstract void tune();
}

class Guitar extends Instrument {
    public Guitar() {
        super("Acoustic Guitar");
    }

    @Override
    public void play() {
        System.out.println("Strumming acoustic chord progressions.");
    }

    @Override
    public void tune() {
        System.out.println("Tuning guitar strings to Standard E-A-D-G-B-E.");
    }
}

class Piano extends Instrument {
    public Piano() {
        super("Grand Piano");
    }

    @Override
    public void play() {
        System.out.println("Playing harmonic arpeggios on ivory keys.");
    }

    @Override
    public void tune() {
        System.out.println("Aligning piano tension pins to A440 concert pitch.");
    }
}
