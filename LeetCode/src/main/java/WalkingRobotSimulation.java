import java.util.HashSet;
import java.util.Set;

class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int currX = 0, currY = 0;
        int[] directX = {0, 1, 0, -1};
        int[] directY = {1, 0, -1, 0};
        int di = 0;
        int ans = 0;
        Set<Pair<Integer, Integer>> obset = new HashSet<>();
        for(int[] ob : obstacles){
            obset.add(Pair.createPair(ob[0], ob[1]));
        }
        for(int i = 0; i < commands.length; i++){
            int currcom = commands[i];
            if(currcom == -1){
                di = (di + 1) % 4;
            }
            else if(currcom == -2){
                di = (di + 3) % 4;
            }
            else{
                for(int j = 0; j < currcom; j++){
                    int tmpx = currX + directX[di];
                    int tmpy = currY + directY[di];
                    Pair<Integer, Integer> tmp = Pair.createPair(tmpx, tmpy);
                    if(!obset.contains(tmp)){
                        currX = tmpx;
                        currY = tmpy;
                        ans = Math.max(ans, currX*currX + currY*currY);
                    }
                }
            }
        }
        return ans;
    }

}

class Pair<K, V>{

    private final K key;
    private final V value;

    public static <K, V> Pair<K, V> createPair(K element0, V element1) {
        return new Pair<K, V>(element0, element1);
    }

    public Pair(K element0, V element1) {
        this.key = element0;
        this.value = element1;
    }
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 31 * hash + (key != null ? key.hashCode() : 0);
        hash = 31 * hash + (value != null ? value.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Pair){
            Pair pair = (Pair) o;
            return (this.key == pair.key && this.value == pair.value);
        }
        return false;

    }
    public String toString(){
        return this.key + " " + this.value;
    }
}
