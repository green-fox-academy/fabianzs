package sharpieset;

import java.util.ArrayList;
import java.util.List;

public class SharpieSet {
    List<Sharpie> sharpies;

    public SharpieSet() {
        this.sharpies = new ArrayList<>();
    }

    public int countUsable() {
        int usableSharpie = 0;
        for (Sharpie oneSharpie : sharpies) {
            if (oneSharpie.inkAmount != 0) {
                usableSharpie += 1;
            }
        }
        return usableSharpie;
    }

    public void removeTrash() {
        List<Sharpie> temp = new ArrayList<>();

        for (Sharpie oneSharpie : sharpies) {
            if (oneSharpie.inkAmount != 0) {
                temp.add(oneSharpie);
            }
        }

        sharpies.clear();

        for (Sharpie oneSharpie : temp) {
                sharpies.add(oneSharpie);
        }


    }

}
