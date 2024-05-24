import java.util.ArrayList;
import java.util.Queue;

public class Workshop_Department{

    public boolean checkEnergyLevels(ArrayList<MakerElf> makers, ArrayList<BuilderElf> builders) {
        boolean b = false;
        for (int i = 0; i < makers.size(); i++) {
            int e = makers.get(i).getEnergy();
            if (e <= 0) {
                b = true;
            }
        }
        for (int i = 0; i < builders.size(); i++) {
            int e = builders.get(i).getEnergy();
            if (e <= 0) {
                b = true;
            }
        }
        return b;
    }

    public void makeMaterials(ArrayList<MakerElf>makers,Queue materials) {
        for (int i = 0; i < makers.size(); i++) {
            MakerElf elf = makers.get(i);
            if (elf.getEnergy() >= 2) {
                materials.add(elf.chopWood());
            } else {
                materials.add(elf.weaveCotton());
            }
        }
    }

    public void buildToys(ArrayList<BuilderElf> builders, Queue materials, ArrayList trains, ArrayList animals) {
        for (int i = 0; i < builders.size(); i++) {
            BuilderElf elf = builders.get(i);
            if (materials.isEmpty()) {
                elf.relax();
            } else {
                Object material = materials.peek();
                if (material instanceof Wood) {
                    trains.add(elf.build((Wood) material));
                } else if (material instanceof Cotton) {
                    animals.add(elf.build((Cotton) material));
                }
                materials.remove(material);

            }
        }
    }


}
