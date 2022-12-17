class line {
    public long m, c;
    line() {
        m = 0;
        c = 0;
    }
    public long getY(long x) { return m * x + c; }
} 
class Solution {
    line bit[];
    void insert(int id, int l, int r, line nline) {
        if (l == r) {
            if (bit[id].getY(l) <= nline.getY(l)) bit[id] = nline;
            return;
        }
        int mid = (l + r) / 2;
        if (nline.getY(l) >= bit[id].getY(l) &&
            nline.getY(mid) >=
                bit[id].getY(mid)) // intersection point lie in [mid+1,r]
        {
            line tmp = nline;
            nline = bit[id];
            bit[id] = tmp;
            insert(2 * id + 1, mid + 1, r, nline);
        } else if (nline.getY(l) <= bit[id].getY(l) &&
                   nline.getY(mid) <= bit[id].getY(mid)) {
insert(2 * id + 1, mid + 1, r, nline);
        } else if (nline.getY(r) >= bit[id].getY(r) &&
                   nline.getY(mid + 1) >=
                       bit[id].getY(mid +
                                    1)) // intersection point lie in [l,mid]
        {
            line tmp = nline;
            nline = bit[id];
            bit[id] = tmp;
            insert(2 * id, l, mid, nline);
        } else if (nline.getY(r) <= bit[id].getY(r) &&
                   nline.getY(mid + 1) <= bit[id].getY(mid + 1)) {
            insert(2 * id, l, mid, nline);
        } else {
            return;
        }
    }

    long get(int id, int l, int r, long x) {
        long y = bit[id].getY(x);
        if (l == r) {
            return y;
        }
        int mid = (l + r) / 2;
        if (x <= mid)
            return Math.max(y, get(2 * id, l, mid, x));
        else
            return Math.max(y, get(2 * id + 1, mid + 1, r, x));
    }
    ArrayList<Long> solve(int N, int A[], int B[], int Q, int Queries[]) {
        int mxK = Math.min(10 * N, 100000);
        bit = new line[4 * mxK + 5];
        for (int i = 0; i < 4 * mxK + 5; i++) bit[i] = new line();
        for (int i = 0; i < N; i++) {
            line l = new line();
            l.m = A[i];
            l.c = B[i];
            insert(1, 1, mxK, l);
}
        ArrayList<Long> ans = new ArrayList<Long>();
        for (int K = 0; K < Q; K++) {
            ans.add(get(1, 1, mxK, Queries[K]));
        }
        return ans;
        
    }
}
