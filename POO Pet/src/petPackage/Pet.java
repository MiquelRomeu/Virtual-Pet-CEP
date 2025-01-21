package petPackage;

public class Pet {
    private char type;
    private String name;
    private int energy, fatigue, sleep, hygiene, weight;
    private boolean dead;

    private final int statMin = 40, statMax = 60;

    public Pet(String type, String name) {
        this.type = type.toLowerCase().charAt(0);
        this.name = name;
        this.energy = (int) ((Math.random() * (statMax - statMin + 1)) + statMin);;
        this.fatigue = (int) ((Math.random() * (statMax - statMin + 1)) + statMin);
        this.sleep = (int) ((Math.random() * (statMax - statMin + 1)) + statMin);
        this.hygiene = (int) ((Math.random() * (statMax - statMin + 1)) + statMin);
        this.weight = (int) ((Math.random() * (statMax - statMin + 1)) + statMin);
        this.dead = false;
    }

    public char getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public int getEnergy() {
        return this.energy;
    }

    public int getFatigue() {
        return this.fatigue;
    }

    public int getSleep() {
        return this.sleep;
    }

    public int getHygiene() {
        return this.hygiene;
    }

    public int getWeight() {
        return this.weight;
    }

    public void sleep() {
        System.out.println("Sleeping..........");
        if (this.type == 'c') {
            this.sleep -= 20;
        } else if (this.type == 'd') {
            this.sleep -= 25;
        }
        this.fatigue -= 15;
        this.energy += 15;
    }
    public void play() {
        System.out.println("Playing..........");
        if (this.type == 'c') {
            this.sleep += 20;
        } else if (this.type == 'd') {
            this.sleep += 25;
        }
        this.fatigue += 15;
        this.energy -= 15;
    }
    public void eat() {
        System.out.println("Eating..........");
        if (this.type == 'c') {
            this.sleep += 10;
        } else if (this.type == 'd') {
            this.sleep += 15;
        }
        this.energy += 10;
        this.hygiene -= 10;
        this.weight += 10;
    }
    public void clean() {
        if (this.type == 'c') {
            System.out.println("Cleaning..........");
            this.sleep += 10;
            this.hygiene += 20;
        } else if (this.type == 'd') {
            System.out.println("Showering..........");
            this.sleep -= 15;
            this.hygiene += 20;
        }
    }
    // 0: energy, 1: fatigue, 2: sleep, 3: hygiene, 4: weight.
    public boolean checkAttributes() {
        if (this.energy <= 0 || this.energy > 100) {
            this.dead = true;
        } else if (this.fatigue <= 0 || this.fatigue > 100) {
            this.dead = true;
        } else if (this.sleep <= 0 || this.sleep > 100) {
            this.dead = true;
        } else if (this.hygiene <= 0 || this.hygiene > 100) {
            this.dead = true;
        } else if (this.weight <= 0 || this.weight > 100) {
            this.dead = true;
        }

        return this.dead;
    }
}
