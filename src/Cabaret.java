import java.util.ArrayList;

public class Cabaret {
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name) {
        this.name = name;
        performers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Performer> getPerformers() {
        return performers;
    }

    public boolean addPerformer(Performer p) {
        if (performers.contains(p)) {
            return false;
        }
        else {
            performers.add(p);
        }
        return true;
    }

    public boolean removePerformer(Performer p) {
        if (performers.contains(p)) {
            performers.remove(performers.indexOf(p));
            return true;
        }
        return false;
    }

    public double averagePerformerAge() {
        int total = 0;
        int count = 0;
        for (Performer p : performers) {
            total+=p.getAge();
            count++;
        }
        return (double)total/count;
    }

    public ArrayList<Performer> performersOverAge(int min) {
        ArrayList<Performer> performersOverAge = new ArrayList<>();
        for (Performer p : performers) {
            if (p.getAge() >= min) {
                performersOverAge.add(p);
            }
        }
        return performersOverAge;
    }

    public void groupRehearsal() {
        for (Performer p : performers) {
            System.out.println("REHEARSAL CALL! " + p.getName());
            if (p instanceof Comedian) {
                Comedian temp = (Comedian) p;
                temp.rehearse(false);
            }
            else {
                p.rehearse();
            }
        }
    }

    public void cabaretShow() {
        for (Performer p : performers) {
            System.out.println("Welcome to the cabaret! Next act up... " + p.getName());
            if (p instanceof Dancer) {
                ((Dancer) p).pirouette(2);
                p.perform();
            }
            else {
                p.perform();
            }
        }

    }
}
