abstract class Human {}


class HumanRanger extends Human {}


class HumanWarrior extends Human {}


class HumanWizard extends  Human {}


abstract class Goblin {}


class GoblinRanger extends Goblin {}


class GoblinWarrior extends Goblin {}


class GoblinWizard extends Goblin {}

// class EmberFactory
class HumanToolkit extends AbstractFactory {
    @Override
    public Human createRanger() {
        return new HumanRanger();
    }

    @Override
    public Human createWarrior() {
        return new HumanWarrior();
    }
    
    public Human createWizard() {
    	return new HumanWizard();
    }
}

// class EnginolaFactory
class GoblinToolkit extends AbstractFactory {
    @Override
    public Goblin createRanger() {
        return new GoblinRanger();
    }

    @Override
    public Goblin createWarrior() {
        return new GoblinWarrior();
    }
    
    public Goblin createWizard() {
    	return new GoblinWizard();
    }
}

enum Architecture {
    HUMAN, GOBLIN
}

abstract class AbstractFactory {
    private static final HumanToolkit HUMAN_TOOLKIT = new HumanToolkit();
    private static final GoblinToolkit GOBLIN_TOOLKIT = new GoblinToolkit();

    // Returns a concrete factory object that is an instance of the
    // concrete factory class appropriate for the given architecture.
    static AbstractFactory getFactory(Architecture architecture) {
        AbstractFactory factory = null;
        switch (architecture) {
            case Golbin:
                factory =GOBLIN_TOOLKIT;
                break;
            case HUMAN:
                factory = HUMAN_TOOLKIT;
                break;
        }
        return factory;
    }

    public abstract Human createRanger();

    public abstract Goblin createRanger();
}

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = AbstractFactory.getFactory(Architecture.HUMAN);
        Human human = factory.createWarrior();
    }
}

