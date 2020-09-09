package arithmetic;

public class BitwiseComplement {
    public int bitwiseComplement(int N) {
        if(N==0) return 1;
        int i = 1;
        while(i<N) {
            i = i<<1;
        }
        i = i-1;
        return ~N&i;
    }
}
