package farm;

public class AnimalsOfTheFarm {
    public static void main(String[] args) {
        Farm southFarm = new Farm();
        southFarm.slot = 3;

        Animal pig = new Animal();
        Animal cow1 = new Animal();
        Animal cow2 = new Animal();
        Animal cow3 = new Animal();
        Animal cow4 = new Animal();
        Animal horse = new Animal();
        Animal chicken1 = new Animal();
        Animal chicken2 = new Animal();
        Animal chicken3 = new Animal();
        Animal chicken4 = new Animal();

        southFarm.animals.add(pig);
        southFarm.animals.add(cow1);
        southFarm.animals.add(cow2);
        southFarm.animals.add(cow3);
        southFarm.animals.add(cow4);
        southFarm.animals.add(horse);
        southFarm.animals.add(chicken1);
        southFarm.animals.add(chicken2);
        southFarm.animals.add(chicken3);
        southFarm.animals.add(chicken4);

        chicken4.eat();
        chicken4.eat();
        chicken1.eat();
        cow1.play();
        cow1.play();

        System.out.println("Number of animals: " + southFarm.animals.size());

        southFarm.breed();
        southFarm.breed();
        southFarm.breed();

        System.out.println("Number of animals: " + southFarm.animals.size());

        southFarm.breed();
        southFarm.breed();
        southFarm.breed();
        southFarm.breed();

        System.out.println("Number of animals: " + southFarm.animals.size());
        System.out.println("\n");

        System.out.println("Slots: " + southFarm.slot);
        System.out.println("\n");

       /* for (Animal animal: southFarm.animals) {
            System.out.println(animal.hunger);
        }*/
        System.out.println("\n");

        southFarm.slaughter();

        System.out.println("Number of animals: " + southFarm.animals.size());
        System.out.println("Slots: " + southFarm.slot);



    }




}
